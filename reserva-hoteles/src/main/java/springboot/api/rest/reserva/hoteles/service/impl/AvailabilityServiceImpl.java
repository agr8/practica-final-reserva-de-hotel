package springboot.api.rest.reserva.hoteles.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;

import springboot.api.rest.reserva.hoteles.dto.AvailabilityDto;
import springboot.api.rest.reserva.hoteles.entity.Availability;
import springboot.api.rest.reserva.hoteles.repository.AvailabilityRepository;
import springboot.api.rest.reserva.hoteles.service.AvailabilityService;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

	private AvailabilityRepository availabilityRepository;
	
	
	
	public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository) {
		super();
		this.availabilityRepository = availabilityRepository;
	}



	@Override
	public Availability consultarDisponibilidadporId(Integer idDisponibilidad) {
		return availabilityRepository.getById(idDisponibilidad);
	}



	@Override
	public Collection<Availability> listarDisponibilidades() {
		return availabilityRepository.findAll();
	}

}
