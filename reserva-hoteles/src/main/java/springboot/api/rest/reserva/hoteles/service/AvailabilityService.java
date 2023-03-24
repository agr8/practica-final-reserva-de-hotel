package springboot.api.rest.reserva.hoteles.service;

import java.util.Collection;

import springboot.api.rest.reserva.hoteles.dto.AvailabilityDto;
import springboot.api.rest.reserva.hoteles.entity.Availability;

public interface AvailabilityService {

	public Availability consultarDisponibilidadporId(Integer idDisponibilidad);

	public Collection<Availability> listarDisponibilidades();

}
