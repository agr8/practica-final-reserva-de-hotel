package springboot.api.rest.reserva.hoteles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.api.rest.reserva.hoteles.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
