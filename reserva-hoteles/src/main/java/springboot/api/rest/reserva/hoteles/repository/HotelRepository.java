package springboot.api.rest.reserva.hoteles.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot.api.rest.reserva.hoteles.entity.Availability;
import springboot.api.rest.reserva.hoteles.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>,  JpaSpecificationExecutor<Hotel> {

//	@Modifying
//	@Query(value = "UPDATE Hotel h SET h.hotelsAvailability.date= :rooms"
//			+ " WHERE a.id_hotel = :idHotel AND "
//			+ " a.date=:d")
//	public void  updateRoomsByIdHotelAndDate(@Param("idHotel") Integer idHotel,
//				@Param("d") LocalDate d,@Param("rooms") Integer rooms);
//	
	
	@Query("FROM Hotel h JOIN FETCH h.hotelsAvailability a where a.date BETWEEN :desde AND :hasta")
	List<Hotel> findByDatesJoinFetch(LocalDate desde,LocalDate hasta);
	
	@Query("FROM Hotel h JOIN FETCH h.hotelsBookings b where b.id=:id")
	Hotel findByIdJoinFetch(Integer id);
}
