package springboot.api.rest.reserva.hoteles.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import springboot.api.rest.reserva.hoteles.dto.AvailabilityDto;
import springboot.api.rest.reserva.hoteles.dto.HotelsAvailabilityDto;
import springboot.api.rest.reserva.hoteles.entity.Availability;
import springboot.api.rest.reserva.hoteles.entity.Hotel;
import springboot.api.rest.reserva.hoteles.repository.AvailabilityRepository;
import springboot.api.rest.reserva.hoteles.repository.FiltrosAvailability;
import springboot.api.rest.reserva.hoteles.repository.HotelRepository;
import springboot.api.rest.reserva.hoteles.service.AvailabilityService;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

	private AvailabilityRepository availabilityRepository;
	private HotelRepository hotelRepository;

	
	public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository, 
			HotelRepository hotelRepository) {
		super();
		this.availabilityRepository = availabilityRepository;
		this.hotelRepository = hotelRepository;
	}



	@Override
	public Availability consultarDisponibilidadporId(Integer idDisponibilidad) {
		return availabilityRepository.getById(idDisponibilidad);
	}
	
	@Override
	public List<Availability> consultarDisponibilidadporIdHotel(Integer idHotel) {
		return availabilityRepository.findByIdHotel(idHotel);
	}


	@Override
	public Collection<Availability> listarDisponibilidades() {
		return availabilityRepository.findAll();
	}



	@Override
	@Transactional
	public void abrirDisponibilidad(Integer idHotel, LocalDate fechaIni, LocalDate fechaFin, Integer rooms) {
				List<Availability> hotelAvailability = availabilityRepository.findByIdHotel(idHotel);

		List<LocalDate> rangeDates;
		rangeDates = fechaIni.datesUntil(fechaFin.plusDays(1)).toList();
		List<LocalDate> datesAvailables = new ArrayList<LocalDate>();
		hotelAvailability.forEach(a -> {
			datesAvailables.add(a.getDate());
		});
		
		rangeDates.forEach( d -> {
			
			if(datesAvailables.contains(d)) {
				availabilityRepository.updateRoomsByIdHotelAndDate(idHotel,d,rooms);

			}else {
				//create availability
			
			}
			
		});
	}	

	
	@Override
	@Transactional
	public List<HotelsAvailabilityDto> buscarDisponibilidadEntreFechas(FiltrosAvailability filtros) {

//		Specification<Hotel> spec = Specification.where(null);
//
//		if(filtros.getDesde()!=null) {
//			Specification<Hotel> desdeSpec = (Root<Hotel> root, CriteriaQuery<?> query,
//					CriteriaBuilder criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("date"), filtros.getDesde());
//			spec = spec.and(desdeSpec);
//		}
//		if(filtros.getHasta()!=null) {
//				
//			Specification<Hotel> hastaSpec = (Root<Hotel> root, CriteriaQuery<?> query,
//					CriteriaBuilder criteriaBuilder) -> 
//			criteriaBuilder.lessThanOrEqualTo(root.get("date"), filtros.getHasta());
//			
//			spec = spec.and(hastaSpec);
//					
//		}
		List<Hotel> hotels =  hotelRepository.findByDatesJoinFetch(filtros.getDesde(),filtros.getHasta());
		List<HotelsAvailabilityDto> hotelsAvailabilityDto = new ArrayList<HotelsAvailabilityDto>();

		hotels.forEach(h->{
			
			HotelsAvailabilityDto dto = new HotelsAvailabilityDto();
			
			dto.setId(h.getId());
			dto.setName(h.getName());
			dto.setCategory(h.getCategory());
			dto.setCategory(h.getCategory());
			h.getHotelsAvailability().forEach(a -> {
				dto.setId_hotel(a.getId_hotel());
			});
			Map<LocalDate, Integer> dateRooms = new HashMap<>();
			h.getHotelsAvailability().forEach(a -> {
				dateRooms.put(a.getDate(),a.getRooms());
			});
			dto.setDateRooms(dateRooms);
		
			hotelsAvailabilityDto.add(dto);
		});
		return hotelsAvailabilityDto;
	}
	
}
