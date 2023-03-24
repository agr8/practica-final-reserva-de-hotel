package springboot.api.rest.reserva.hoteles.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


import springboot.api.rest.reserva.hoteles.entity.Availability;

public class HotelsAvailabilityDto {
	
	private Integer id;
	private String name;
	private String category;
//	private List<Availability> availability;
//	private LocalDate date;
	private Integer id_hotel;
	private Map<LocalDate, Integer> dateRooms;

//	private Integer rooms;
	
	public HotelsAvailabilityDto(Integer id, String name, String category,Integer id_hotel,
			Map<LocalDate, Integer> dateRooms) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
//		this.availability = availability;
//		this.date = date;
		this.id_hotel = id_hotel;
		this.dateRooms = dateRooms;
	}
	public HotelsAvailabilityDto() {
		
	};
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
//
//	public List<Availability> getAvailability() {
//		return availability;
//	}
//
//	public void setAvailability(List<Availability> availability) {
//		this.availability = availability;
//	}

//	public LocalDate getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}

	public Integer getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(Integer id_hotel) {
		this.id_hotel = id_hotel;
	}
//
//	public Integer getRooms() {
//		return rooms;
//	}
//
//	public void setRooms(Integer rooms) {
//		this.rooms = rooms;
//	}
	public Map<LocalDate, Integer> getDateRooms() {
		return dateRooms;
	}
	public void setDateRooms(Map<LocalDate, Integer> dateRooms) {
		this.dateRooms = dateRooms;
	}
	
	
	

}
