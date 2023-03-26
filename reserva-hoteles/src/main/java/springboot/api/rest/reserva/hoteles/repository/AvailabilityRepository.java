package springboot.api.rest.reserva.hoteles.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot.api.rest.reserva.hoteles.entity.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> , JpaSpecificationExecutor<Availability> {

	
	@Query(value = "FROM Availability a WHERE a.id_hotel = :idHotel")
	List<Availability>  findByIdHotel(@Param("idHotel") Integer idHotel);
	
	@Modifying
	@Query(value = "UPDATE Availability a SET a.rooms= a.rooms+:morerooms"
			+ " WHERE a.id_hotel = :idHotel AND "
			+ " a.date=:d")
	public void  updateRoomsByIdHotelAndDate(@Param("idHotel") Integer idHotel,
				@Param("d") LocalDate d,@Param("morerooms") Integer rooms);
	
	List<Availability> findByDate(LocalDate date);

	
}

