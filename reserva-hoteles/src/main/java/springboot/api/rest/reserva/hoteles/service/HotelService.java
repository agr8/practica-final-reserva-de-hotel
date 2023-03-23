package springboot.api.rest.reserva.hoteles.service;

import java.util.List;
import java.util.Optional;

import springboot.api.rest.reserva.hoteles.entity.Hotel;

public interface HotelService  {
	
	public Hotel consultarHotelporId(Integer id);
	
	public List<Hotel> listarHoteles();
	
	public Hotel crearHotel(Hotel nuevoHotel);

}
