package springboot.api.rest.reserva.hoteles.controller;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.api.rest.reserva.hoteles.dto.HotelDto;
import springboot.api.rest.reserva.hoteles.entity.Hotel;
import springboot.api.rest.reserva.hoteles.mapper.HotelMapper;
import springboot.api.rest.reserva.hoteles.service.HotelService;


@RestController
@RequestMapping("hoteles")
public class HotelController {
	
	private HotelService hotelService;
	private HotelMapper hotelMapper;
	
	public HotelController(HotelService hotelService, HotelMapper hotelMapper) {

		this.hotelService = hotelService;
		this.hotelMapper = hotelMapper;
	}
	
	
	@GetMapping(value = "{idHotel}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelDto obtenerHotel(@PathVariable(value = "idHotel") Integer idHotel){
		
		return hotelMapper.mapToDto(hotelService.consultarHotelporId(idHotel));
	
	}
	
	
	
	
	
}
