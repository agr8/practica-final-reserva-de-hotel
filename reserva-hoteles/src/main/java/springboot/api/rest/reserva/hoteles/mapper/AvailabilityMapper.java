package springboot.api.rest.reserva.hoteles.mapper;

import org.springframework.stereotype.Component;

import springboot.api.rest.reserva.hoteles.dto.AvailabilityDto;
import springboot.api.rest.reserva.hoteles.entity.Availability;

@Component
public class AvailabilityMapper {
	
	public AvailabilityDto mapToDto(Availability availability) {
		
		return new AvailabilityDto(availability.getId(),availability.getDate(),
						availability.getId_hotel(),availability.getRooms());
		
	}
	
	public Availability mapToEntity(AvailabilityDto availability) {
		
		return new Availability(availability.getId(),availability.getDate(),
						availability.getId_hotel(),availability.getRooms());
		
		
	}
}
