package springboot.api.rest.reserva.hoteles.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.api.rest.reserva.hoteles.dto.AvailabilityDto;
import springboot.api.rest.reserva.hoteles.dto.HotelDto;
import springboot.api.rest.reserva.hoteles.dto.HotelsAvailabilityDto;
import springboot.api.rest.reserva.hoteles.entity.Availability;
import springboot.api.rest.reserva.hoteles.entity.Hotel;
import springboot.api.rest.reserva.hoteles.mapper.AvailabilityMapper;
import springboot.api.rest.reserva.hoteles.mapper.HotelsAvailabilityMapper;
import springboot.api.rest.reserva.hoteles.repository.FiltrosAvailability;
import springboot.api.rest.reserva.hoteles.service.AvailabilityService;

@RestController
@RequestMapping("disponibilidad")
public class AvailabilityController {
	
	private AvailabilityService availabilityService;
	private AvailabilityMapper availabilityMapper;
	private HotelsAvailabilityMapper hotelsAvailabilityMapper;

	
	public AvailabilityController(AvailabilityService availabilityService, AvailabilityMapper availabilityMapper,HotelsAvailabilityMapper hotelsAvailabilityMapper) {
		super();
		this.availabilityService = availabilityService;
		this.availabilityMapper = availabilityMapper;
		this.hotelsAvailabilityMapper = hotelsAvailabilityMapper;
	}
	
	@GetMapping(value = "{idDisponibilidad}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  AvailabilityDto obtenerDisponibilidad(@PathVariable(value = "idDisponibilidad") Integer idDisponibilidad){
		
		return availabilityMapper.mapToDto(availabilityService.consultarDisponibilidadporId(idDisponibilidad));
	}
	
	@GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<AvailabilityDto>> obtenerListadoDisponibilidades(){
				
		Collection<AvailabilityDto> availabilityDtos = availabilityService.listarDisponibilidades().stream()
												.map(a->availabilityMapper.mapToDto(a)).toList();
		
		return new ResponseEntity<Collection<AvailabilityDto>>(availabilityDtos,HttpStatus.OK);
	
	}
	
	@PostMapping(value= "/abrir", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Collection<Availability>> abrirDisponibilidad(@RequestParam(name="idHotel") Integer idHotel,	@RequestParam(name="fechaIni")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaIni,
			@RequestParam(name="fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin, @RequestParam(name="rooms") Integer rooms) {

		 availabilityService.abrirDisponibilidad(idHotel, fechaIni, fechaFin, rooms);
		 List<Availability> availability = availabilityService.consultarDisponibilidadporIdHotel(idHotel);

		 return new ResponseEntity<Collection<Availability>>(availability, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/buscar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<HotelsAvailabilityDto> buscarDisponibilidad(
			@RequestParam(name = "desde", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
			@RequestParam(name = "hasta", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {
		FiltrosAvailability filtros = new FiltrosAvailability();
		if(desde!=null)
			filtros.setDesde(desde); 
		if(hasta!=null)
			filtros.setHasta(hasta);
		 
		return availabilityService.buscarDisponibilidadEntreFechas(filtros);
	}
	
	
}
