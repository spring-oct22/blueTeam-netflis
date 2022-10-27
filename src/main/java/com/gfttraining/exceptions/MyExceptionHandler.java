package com.gfttraining.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class MyExceptionHandler extends ResponseEntityExceptionHandler{	
	
	@ExceptionHandler (NotFoundException.class)
	public final ResponseEntity <Object> handlerUserNotFoundException(Exception ex, WebRequest request){
		AllException exception = new AllException(ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity <>(exception, HttpStatus.NOT_FOUND);
	}

}
