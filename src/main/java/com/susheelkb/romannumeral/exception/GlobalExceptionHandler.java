package com.susheelkb.romannumeral.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.susheelkb.romannumeral.error.RomanNumeralError;

import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(RangeViolationException.class)
	public ResponseEntity<Object> numberNotInRangeHandling(RangeViolationException exception) {
		RomanNumeralError errorDetails = new RomanNumeralError(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
		logger.error("Number out of Range", exception);
		return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);

	}

	/**
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(NotAnIntegerException.class)
	public ResponseEntity<Object> numberNotAnIntegerHandling(NotAnIntegerException exception) {
		RomanNumeralError errorDetails = new RomanNumeralError(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
		logger.error("Input is not an Integer", exception);
		return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);

	}

	/**
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(NumberIsZeroException.class)
	public ResponseEntity<?> numberIsZeroHandling(NumberIsZeroException exception) {
		RomanNumeralError errorDetails = new RomanNumeralError(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
		logger.error("Number is Zero", exception);
		return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);

	}

}
