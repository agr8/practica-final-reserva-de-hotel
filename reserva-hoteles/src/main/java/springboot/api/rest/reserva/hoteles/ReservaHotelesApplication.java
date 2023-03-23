package springboot.api.rest.reserva.hoteles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@ComponentScan("springboot.api.rest.reserva.hoteles")
@SpringBootApplication
public class ReservaHotelesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservaHotelesApplication.class, args);
	}
	
	@Bean
	public Hibernate5Module hibernateModule() {
		Hibernate5Module module = new Hibernate5Module();
		module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
		module.enable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);
		return module;
	}
}
