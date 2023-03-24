package springboot.api.rest.reserva.hoteles.mapper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Component;

import springboot.api.rest.reserva.hoteles.dto.HotelsAvailabilityDto;
import springboot.api.rest.reserva.hoteles.entity.Availability;
import springboot.api.rest.reserva.hoteles.entity.Hotel;

@Component

public class HotelsAvailabilityMapper {


//	public HotelsAvailabilityDto mapToDto(Hotel hotel, List<Availability> availability) {
//		
//		return new HotelsAvailabilityDto(hotel.getId(),hotel.getName(),hotel.getCategory(),
//											availability);
//		
//	}
//	
	public Hotel mapToHotelEntity(HotelsAvailabilityDto hotelsAvailability) {
		
		return new Hotel(hotelsAvailability.getId(),hotelsAvailability.getName(),hotelsAvailability.getCategory());
		
		
	}
	
	public List<Availability> mapToAvailabilityEntity(HotelsAvailabilityDto hotelsAvailability) {
		
		List<Availability> availabilities = new  ArrayList<Availability>();
		hotelsAvailability.getDateRooms().forEach((d,r)->{
			
			Availability availability = new Availability();
			availability.setDate(d);
			availability.setRooms(r);
			availability.setId_hotel(hotelsAvailability.getId_hotel());

		});
	
		return availabilities;
		
		
	}
}
