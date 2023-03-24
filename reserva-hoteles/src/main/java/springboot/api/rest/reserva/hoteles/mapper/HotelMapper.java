package springboot.api.rest.reserva.hoteles.mapper;

import org.springframework.stereotype.Component;

import springboot.api.rest.reserva.hoteles.dto.HotelDto;
import springboot.api.rest.reserva.hoteles.entity.Hotel;

@Component
public class HotelMapper {

	public HotelDto mapToDto(Hotel hotel) {
		
		return new HotelDto(hotel.getId(),hotel.getName(),hotel.getCategory(), hotel.getHotelsAvailability());
		
	}
	
	public Hotel mapToEntity(HotelDto hotel) {
		
		return new Hotel(hotel.getId(),hotel.getName(),hotel.getCategory());
		
		
	}
}
