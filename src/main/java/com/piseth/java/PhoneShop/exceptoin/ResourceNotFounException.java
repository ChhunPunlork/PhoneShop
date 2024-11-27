package com.piseth.java.PhoneShop.exceptoin;

import org.springframework.http.HttpStatus;

public class ResourceNotFounException extends ApiException {

//	public ResourceNotFounException(HttpStatus status, Integer id) {
//		//super(status, message);
//		super(HttpStatus.NOT_FOUND, message)
//	}
	public ResourceNotFounException(String resourceName, Integer id) {
		super(HttpStatus.NOT_FOUND, String.format("%s with id = %d not found", resourceName, id));
	}

}
