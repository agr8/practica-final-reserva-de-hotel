package springboot.api.rest.reserva.hoteles.controller;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public  HotelDto obtenerHotel(@PathVariable(value = "idHotel") Integer idHotel){
		
		return hotelMapper.mapToDto(hotelService.consultarHotelporId(idHotel));
	}
	
	
	@GetMapping( value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<HotelDto>> obtenerListadoHoteles(){
				
		Collection<HotelDto> hotelesDto = hotelService.listarHoteles().stream()
												.map(h->hotelMapper.mapToDto(h)).toList();
		
		return new ResponseEntity<Collection<HotelDto>>(hotelesDto,HttpStatus.OK);
	
	}
	
	
	@PostMapping(value= "/nuevo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<HotelDto> creaHotel(@RequestBody HotelDto hotel) {

		
		 HotelDto hotelCreado = hotelMapper.mapToDto(
				 					hotelService.crearHotel(hotelMapper.mapToEntity(hotel))
			 					);
		 
		 return new ResponseEntity<HotelDto>(hotelCreado, HttpStatus.CREATED);

	}
	
	@PutMapping(value= "{idHotel}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<HotelDto> modificarHotel(@PathVariable(name = "idHotel") Integer idHotel, @RequestBody HotelDto hotelDto ) {
		 HotelDto hotelModificado = hotelMapper.mapToDto(
				 						hotelService.modificarHotel(idHotel,
				 											hotelMapper.mapToEntity(hotelDto))
				 					);
		 
		 return new ResponseEntity<HotelDto>(hotelModificado, HttpStatus.OK);

	}
	
}
