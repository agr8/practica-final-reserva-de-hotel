package springboot.api.rest.reserva.hoteles.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hotels")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "category")
	private String category;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
	private List<Availability> hotelsAvailability;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotelReservas")
	private List<Booking> hotelsBookings;
	
	
	public Hotel() {
		super();
	}

	public Hotel(Integer id, String name, String category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
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

	public List<Availability> getHotelsAvailability() {
		return hotelsAvailability;
	}

	public void setHotelsAvailability(List<Availability> hotelsAvailability) {
		this.hotelsAvailability = hotelsAvailability;
	}

	public List<Booking> getHotelsBookings() {
		return hotelsBookings;
	}

	public void setHotelsBookings(List<Booking> hotelsBookings) {
		this.hotelsBookings = hotelsBookings;
	}

	
	
	
	
}
