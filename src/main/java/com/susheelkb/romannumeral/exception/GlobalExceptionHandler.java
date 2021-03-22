package com.susheelkb.romannumeral.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.susheelkb.romannumeral.error.ApiError;
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
		ApiError errorDetails = new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, exception);
		logger.error("Number out of Range", exception);
		return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);

	}

	/**
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(RangeQueryException.class)
	public ResponseEntity<Object> rangeIsNotCorrect(RangeQueryException exception) {
		ApiError errorDetails = new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, exception);
		logger.error("Min and Max values of the given range do not follow order", exception);
		return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);

	}

	/**
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(NumberIsZeroException.class)
	public ResponseEntity<Object> numberIsZeroHandling(NumberIsZeroException exception) {
		ApiError errorDetails = new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, exception);
		logger.error("Number is Zero", exception);
		return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);

	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<Object> notANumberHandling(NumberFormatException exception) {
		ApiError errorDetails = new ApiError(HttpStatus.BAD_REQUEST, "Given parameter cannot be converted into an integer");
		logger.error("Number is Not an Integer", exception);
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);

	}
    
}
