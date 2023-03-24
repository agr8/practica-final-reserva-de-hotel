package springboot.api.rest.reserva.hoteles.dto;

import java.time.LocalDate;
import java.util.List;

import springboot.api.rest.reserva.hoteles.entity.Availability;

public class HotelDto {

	private Integer id;
	private String name;
	private String category;
	private List<Availability> availability;
	
	
	
	public HotelDto(Integer id, String name, String category, List<Availability> availability) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.availability = availability;
		
	}

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

	public List<Availability> getAvailability() {
		return availability;
	}

	public void setAvailability(List<Availability> availability) {
		this.availability = availability;
	}


	
	
	
	
}
