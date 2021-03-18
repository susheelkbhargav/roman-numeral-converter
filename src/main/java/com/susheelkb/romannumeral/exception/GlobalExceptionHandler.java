package com.susheelkb.romannumeral.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(RangeViolationException.class)
	public ResponseEntity<?>numberNotInRangeHandling(RangeViolationException exception){
		RomanNumeralError errorDetails = new RomanNumeralError(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
		
	}
	
	@ExceptionHandler(NotAnIntegerException.class)
	public ResponseEntity<Object>numberNotAnIntegerHandling(NotAnIntegerException exception){
		RomanNumeralError errorDetails = new RomanNumeralError(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
		
	}
	
	@ExceptionHandler(NumberIsZeroException.class)
	public ResponseEntity<?>numberIsZeroHandling(NumberIsZeroException exception){
		RomanNumeralError errorDetails = new RomanNumeralError(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
		
	}
}
