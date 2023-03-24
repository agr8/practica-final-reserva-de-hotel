package springboot.api.rest.reserva.hoteles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.api.rest.reserva.hoteles.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	
}
