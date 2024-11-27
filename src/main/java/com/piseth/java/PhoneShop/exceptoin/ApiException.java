package com.piseth.java.PhoneShop.exceptoin;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
	private HttpStatus status;
	private String message;

	public ApiException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
