package springboot.api.rest.reserva.hoteles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.api.rest.reserva.hoteles.entity.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {

}
