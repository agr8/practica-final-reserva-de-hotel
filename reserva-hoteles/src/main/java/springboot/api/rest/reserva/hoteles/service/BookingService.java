package springboot.api.rest.reserva.hoteles.service;

import java.util.Collection;

import springboot.api.rest.reserva.hoteles.dto.BookingDto;
import springboot.api.rest.reserva.hoteles.entity.Booking;
import springboot.api.rest.reserva.hoteles.entity.Hotel;

public interface BookingService {

	public Collection<Booking> listarReservas();

	public Booking consultarReservaporId(Integer idReserva);

	public Hotel consultarHotelReservaporId(Integer idReserva);

}
