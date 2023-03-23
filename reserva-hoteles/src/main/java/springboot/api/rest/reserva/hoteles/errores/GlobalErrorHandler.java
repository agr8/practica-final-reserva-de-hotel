package springboot.api.rest.reserva.hoteles.errores;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex){
		
		return new ResponseEntity<>(new Error("404 - OBJECT NOT FOUND",ex.getMessage()),HttpStatus.NOT_FOUND);
		 
	}
	

//	@ExceptionHandler(value = RuntimeException.class)
//	public ResponseEntity<Object> handleRuntimeException(RuntimeException ex){
//		return new ResponseEntity<>(new Error("Exception",ex.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
//		 
//	}
	
	
}
