package com.shortrent.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShortRentExceptionHandler {

	@ExceptionHandler(ShortRentException.class)
	public ResponseEntity<ShortRentErrorMessage> handleShortRentException(ShortRentException ex){
		return new ResponseEntity<ShortRentErrorMessage>(ex.getErrorMessage(),HttpStatus.BAD_REQUEST);
	}
}
