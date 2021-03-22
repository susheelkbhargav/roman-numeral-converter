package com.susheelkb.romannumeral.error;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {
	private HttpStatus status;
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
		this.status = status;
		this.message = ex.getMessage();
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
