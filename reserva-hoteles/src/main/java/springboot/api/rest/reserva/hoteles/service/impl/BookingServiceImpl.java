package springboot.api.rest.reserva.hoteles.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;

import springboot.api.rest.reserva.hoteles.dto.BookingDto;
import springboot.api.rest.reserva.hoteles.entity.Booking;
import springboot.api.rest.reserva.hoteles.repository.BookingRepository;
import springboot.api.rest.reserva.hoteles.repository.HotelRepository;
import springboot.api.rest.reserva.hoteles.service.BookingService;
@Service
public class BookingServiceImpl implements BookingService {

	private BookingRepository bookingRepository;

	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}

	@Override
	public Collection<Booking> listarReservas() {
		
		return bookingRepository.findAll();
	}

}
