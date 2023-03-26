package springboot.api.rest.reserva.hoteles.service;

import java.util.Collection;

import springboot.api.rest.reserva.hoteles.dto.BookingDto;
import springboot.api.rest.reserva.hoteles.entity.Booking;

public interface BookingService {

	public Collection<Booking> listarReservas();

}
