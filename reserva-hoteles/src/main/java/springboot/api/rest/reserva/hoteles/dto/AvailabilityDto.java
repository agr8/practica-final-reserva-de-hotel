package springboot.api.rest.reserva.hoteles.dto;

import java.time.LocalDate;


public class AvailabilityDto {

	private Integer id;
	private LocalDate date;
	private Integer id_hotel;
	private Integer rooms;
	
	public AvailabilityDto(Integer id, LocalDate date, Integer id_hotel, Integer rooms) {
		super();
		this.id = id;
		this.date = date;
		this.id_hotel = id_hotel;
		this.rooms = rooms;
	}

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
