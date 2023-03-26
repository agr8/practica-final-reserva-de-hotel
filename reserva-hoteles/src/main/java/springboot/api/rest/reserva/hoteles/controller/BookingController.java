package springboot.api.rest.reserva.hoteles.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.api.rest.reserva.hoteles.dto.AvailabilityDto;
import springboot.api.rest.reserva.hoteles.dto.BookingDto;
import springboot.api.rest.reserva.hoteles.dto.HotelDto;
import springboot.api.rest.reserva.hoteles.entity.Hotel;
import springboot.api.rest.reserva.hoteles.mapper.BookingMapper;
import springboot.api.rest.reserva.hoteles.mapper.HotelMapper;
import springboot.api.rest.reserva.hoteles.service.BookingService;

@RestController
@RequestMapping("reservas")
public class BookingController {
	
	private BookingService bookingService;
	private BookingMapper bookingMapper; 
	private HotelMapper hotelMapper;
	

	public BookingController(BookingService bookingService,BookingMapper bookingMapper, HotelMapper hotelMapper) {
		super();
		this.bookingService = bookingService;
		this.bookingMapper = bookingMapper;
		this.hotelMapper = hotelMapper;
	}


	@GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<BookingDto>> obtenerListadoReservas(){
				
		Collection<BookingDto> bookingsDtos = bookingService.listarReservas().stream()
												.map(a->bookingMapper.mapToDto(a)).toList();
		
		return new ResponseEntity<Collection<BookingDto>>(bookingsDtos,HttpStatus.OK);
	
	}
	
	@GetMapping(value = "{idReserva}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  BookingDto obtenerReserva(@PathVariable(value = "idReserva") Integer idReserva){
		return bookingMapper.mapToDto(bookingService.consultarReservaporId(idReserva));
	}
	
	@GetMapping(value = "/hotel/{idReserva}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  HotelDto obtenerHotelReserva(@PathVariable(value = "idReserva") Integer idReserva){
		return hotelMapper.mapToDto(bookingService.consultarHotelReservaporId(idReserva));
	}
	
	
	
}
