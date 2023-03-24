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
import springboot.api.rest.reserva.hoteles.dto.HotelDto;
import springboot.api.rest.reserva.hoteles.mapper.AvailabilityMapper;
import springboot.api.rest.reserva.hoteles.service.AvailabilityService;

@RestController
@RequestMapping("disponibilidad")
public class AvailabilityController {
	
	private AvailabilityService availabilityService;
	private AvailabilityMapper availabilityMapper;
	
	public AvailabilityController(AvailabilityService availabilityService, AvailabilityMapper availabilityMapper) {
		super();
		this.availabilityService = availabilityService;
		this.availabilityMapper = availabilityMapper;
	}
	
	@GetMapping(value = "{idDisponibilidad}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  AvailabilityDto obtenerDisponibilidad(@PathVariable(value = "idDisponibilidad") Integer idDisponibilidad){
		
		return availabilityMapper.mapToDto(availabilityService.consultarDisponibilidadporId(idDisponibilidad));
	}
	
	@GetMapping( value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<AvailabilityDto>> obtenerListadoDisponibilidades(){
				
		Collection<AvailabilityDto> availabilityDto = availabilityService.listarDisponibilidades().stream()
												.map(a->availabilityMapper.mapToDto(a)).toList();
		
		return new ResponseEntity<Collection<AvailabilityDto>>(availabilityDto,HttpStatus.OK);
	
	}
}
