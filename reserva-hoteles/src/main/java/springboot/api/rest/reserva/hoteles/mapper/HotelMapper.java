package springboot.api.rest.reserva.hoteles.mapper;

import springboot.api.rest.reserva.hoteles.dto.HotelDto;
import springboot.api.rest.reserva.hoteles.entity.Hotel;

public class HotelMapper {

public HotelDto mapToDto(Hotel hotel) {
		
		return new HotelDto(hotel.getId(),hotel.getName(),hotel.getCategory());
		
	}
	
	public Hotel mapToEntity(HotelDto hotel) {
		
		return new Hotel(hotel.getId(),hotel.getName(),hotel.getCategory());
		
		
	}
}
