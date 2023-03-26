package springboot.api.rest.reserva.hoteles.repository;

import java.time.LocalDate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import springboot.api.rest.reserva.hoteles.entity.Availability;

public class FiltrosAvailability {
	
	private LocalDate desde;
	private LocalDate hasta;


	public LocalDate getDesde() {
		return desde;
	}


	public void setDesde(LocalDate desde) {
		this.desde = desde;
	}


	public LocalDate getHasta() {
		return hasta;
	}


	public void setHasta(LocalDate hasta) {
		this.hasta = hasta;
	}


	
}
