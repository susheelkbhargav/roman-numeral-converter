package com.susheelkb.romannumeral.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.UNPROCESSABLE_ENTITY)
public class NumberIsZeroException extends RuntimeException {
	private static final long serialVersionUID = 2L;
	
	/**
	 * constructor
	 * @param message
	 */
	public NumberIsZeroException(String message){
		super(message);
	}
}