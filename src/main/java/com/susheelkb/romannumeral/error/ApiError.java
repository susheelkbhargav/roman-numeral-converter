package com.susheelkb.romannumeral.error;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {
	private HttpStatus error;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;	
	/**
	 * 
	 * @param status
	 * @param message
	 */
	public ApiError(HttpStatus status,Throwable ex){
        this.timestamp = LocalDateTime.now();
		this.error = status;
		this.message = ex.getMessage();
	}
	
	
	public ApiError(HttpStatus status, String message){
        this.timestamp = LocalDateTime.now();
		this.error = status;
		this.message = message;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public HttpStatus getError() {
		return error;
	}

	/**
	 * 
	 * @param status
	 */
	public void setError(HttpStatus status) {
		this.error = status;
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
