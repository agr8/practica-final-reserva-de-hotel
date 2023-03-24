package springboot.api.rest.reserva.hoteles.service;

import java.util.List;
import java.util.Optional;

import springboot.api.rest.reserva.hoteles.dto.HotelsAvailabilityDto;
import springboot.api.rest.reserva.hoteles.entity.Hotel;

public interface HotelService  {
	
	public Hotel consultarHotelporId(Integer id);
	
	public List<Hotel> listarHoteles();
	
	public Hotel crearHotel(Hotel nuevoHotel);

	public Hotel modificarHotel(Integer idHotel, Hotel hotelModificado);

	public List<HotelsAvailabilityDto> listarHotelesDTO();

}
