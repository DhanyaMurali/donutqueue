package com.springboot.donutqueue.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.donutqueue.errors.ErrorResponse;
import com.springboot.donutqueue.exception.ClientNotFoundException;

@ControllerAdvice
public class ClientRestExceptionHandler {
	
	//Add an exception handler for client not found exception
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(ClientNotFoundException exc){
		
		ErrorResponse error = new ErrorResponse(
									HttpStatus.NOT_FOUND.value(),
									exc.getMessage(),
									System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	//Add an exception handler for all other exceptions(catch all)
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exc){
		
		ErrorResponse error = new ErrorResponse(
									HttpStatus.BAD_REQUEST.value(),
									exc.getMessage(),
									System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	public ClientRestExceptionHandler() {
		
	
		
	}

}
