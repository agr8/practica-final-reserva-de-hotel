package springboot.api.rest.reserva.hoteles.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hotel", nullable = false)
	private Hotel hotelReservas;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "id_hotel",insertable=false, updatable=false)
	private Integer id_hotel;
	@Column(name = "date_from")
	private LocalDate date_from;
	@Column(name = "date_to")
	private LocalDate date_to;
	@Column(name = "email")
	private String email;
	
	
	
	public Booking() {
		super();
	}

	public Booking(Integer id, Integer id_hotel, LocalDate date_from, LocalDate date_to, String email) {
		super();
		this.id = id;
		this.id_hotel = id_hotel;
		this.date_from = date_from;
		this.date_to = date_to;
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(Integer id_hotel) {
		this.id_hotel = id_hotel;
	}
	public LocalDate getDate_from() {
		return date_from;
	}
	public void setDate_from(LocalDate date_from) {
		this.date_from = date_from;
	}
	public LocalDate getDate_to() {
		return date_to;
	}
	public void setDate_to(LocalDate date_to) {
		this.date_to = date_to;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
