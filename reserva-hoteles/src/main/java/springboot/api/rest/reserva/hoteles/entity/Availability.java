package springboot.api.rest.reserva.hoteles.entity;

import java.time.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "availabilities")
public class Availability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "id_hotel")
	private Integer id_hotel;
	@Column(name = "rooms")
	private Integer rooms;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Integer getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(Integer id_hotel) {
		this.id_hotel = id_hotel;
	}
	public Integer getRooms() {
		return rooms;
	}
	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}
	
	
}
