package com.gfttraining.exceptions;


public class Exception{
	
	private String message;
	private String status;
	
	public Exception() {}

	public Exception(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "allExceptions [message=" + message + ", status=" + status + "]";
	}
	
	
	
	
	
}