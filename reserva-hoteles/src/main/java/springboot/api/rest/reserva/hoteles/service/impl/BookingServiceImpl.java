package springboot.api.rest.reserva.hoteles.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;

import springboot.api.rest.reserva.hoteles.dto.BookingDto;
import springboot.api.rest.reserva.hoteles.entity.Booking;
import springboot.api.rest.reserva.hoteles.entity.Hotel;
import springboot.api.rest.reserva.hoteles.repository.BookingRepository;
import springboot.api.rest.reserva.hoteles.repository.HotelRepository;
import springboot.api.rest.reserva.hoteles.service.BookingService;
@Service
public class BookingServiceImpl implements BookingService {

	private BookingRepository bookingRepository;
	private HotelRepository hotelRepository;


	public BookingServiceImpl(BookingRepository bookingRepository,HotelRepository hotelRepository) {
		super();
		this.bookingRepository = bookingRepository;
		this.hotelRepository = hotelRepository;
	}

	@Override
	public Collection<Booking> listarReservas() {
		
		return bookingRepository.findAll();
	}

	@Override
	public Booking consultarReservaporId(Integer idReserva) {
		return bookingRepository.findById(idReserva).get();
	}

	@Override
	public Hotel consultarHotelReservaporId(Integer idReserva) {
		
		return hotelRepository.findByIdJoinFetch(idReserva);
		
	}

}
