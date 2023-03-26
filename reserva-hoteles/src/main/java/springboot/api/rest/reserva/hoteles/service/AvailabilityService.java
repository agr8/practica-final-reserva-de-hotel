package springboot.api.rest.reserva.hoteles.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import springboot.api.rest.reserva.hoteles.dto.AvailabilityDto;
import springboot.api.rest.reserva.hoteles.dto.HotelsAvailabilityDto;
import springboot.api.rest.reserva.hoteles.entity.Availability;
import springboot.api.rest.reserva.hoteles.entity.Hotel;
import springboot.api.rest.reserva.hoteles.repository.FiltrosAvailability;

public interface AvailabilityService {

	public Availability consultarDisponibilidadporId(Integer idDisponibilidad);

	public Collection<Availability> listarDisponibilidades();

	public void abrirDisponibilidad(Integer idHotel, LocalDate fechaIni, LocalDate fechaFin, Integer rooms);

	public List<Availability> consultarDisponibilidadporIdHotel(Integer idHotel);
	
	public List<HotelsAvailabilityDto> buscarDisponibilidadEntreFechas(FiltrosAvailability filtros);

}
