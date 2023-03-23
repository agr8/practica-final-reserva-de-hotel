package springboot.api.rest.reserva.hoteles.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

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

}
