package com.susheelkb.romannumeral.error;
import org.springframework.http.HttpStatus;

public class RomanNumeralError {
	private HttpStatus status;
	private String message;
	
	/**
	 * 
	 * @param status
	 * @param message
	 */
	public RomanNumeralError(HttpStatus status, String message){
		this.status = status;
		this.message = message;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * 
	 * @return
	 */

	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}	
	
}
