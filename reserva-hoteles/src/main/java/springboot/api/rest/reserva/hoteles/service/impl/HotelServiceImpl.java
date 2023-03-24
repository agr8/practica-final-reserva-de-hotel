package springboot.api.rest.reserva.hoteles.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import springboot.api.rest.reserva.hoteles.dto.HotelsAvailabilityDto;
import springboot.api.rest.reserva.hoteles.entity.Hotel;
import springboot.api.rest.reserva.hoteles.repository.HotelRepository;
import springboot.api.rest.reserva.hoteles.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	private HotelRepository hotelRepository;
	
	
	public HotelServiceImpl(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}



	@Override
	public Hotel consultarHotelporId(Integer id) {
		
		return hotelRepository.findById(id).get();
	}



	@Override
	public List<Hotel> listarHoteles() {
	
		return hotelRepository.findAll();
		
	}
	
	@Override
	public List<HotelsAvailabilityDto> listarHotelesDTO() {
		
		List<Hotel> hotels =  hotelRepository.findAll();
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



	@Override
	@Transactional
	public Hotel crearHotel(Hotel nuevoHotel) {
		
		return hotelRepository.save(nuevoHotel);
		
	}



	@Override
	@Transactional
	public Hotel modificarHotel(Integer idHotel, Hotel hotelModificado) {
		hotelModificado.setId(idHotel);
		return hotelRepository.save(hotelModificado);
	}

}
