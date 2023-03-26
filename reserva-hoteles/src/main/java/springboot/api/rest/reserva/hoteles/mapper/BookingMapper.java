package springboot.api.rest.reserva.hoteles.mapper;

import org.springframework.stereotype.Component;

import springboot.api.rest.reserva.hoteles.dto.BookingDto;
import springboot.api.rest.reserva.hoteles.entity.Booking;
@Component

public class BookingMapper {

	public BookingDto mapToDto(Booking booking) {
			
		return new BookingDto(booking.getId(),booking.getId_hotel(),
				booking.getDate_from(),booking.getDate_to(),booking.getEmail());
			
	}
	
	public Booking mapToEntity(BookingDto booking) {
		
		return new Booking(booking.getId(),booking.getId_hotel(),
				booking.getDate_from(),booking.getDate_to(),booking.getEmail());
		
		
	}
}
