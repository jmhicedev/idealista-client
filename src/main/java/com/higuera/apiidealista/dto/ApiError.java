package com.higuera.apiidealista.dto;

public class ApiError {
	
	/* Error response from any method */
	private Integer httpStatus;
	private String message;
	
	/* Error response from authentication */
	private String error;
	private String error_description;
	
	
	public ApiError(){}
	
	public ApiError(Integer httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public ApiError(String error, String error_description) {
		this.error = error;
		this.error_description = error_description;
	}

	
	/* Getters and Setters */
	public Integer getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getError_description() {
		return error_description;
	}
	public void setError_description(String error_description) {
		this.error_description = error_description;
	}
	
	
}
