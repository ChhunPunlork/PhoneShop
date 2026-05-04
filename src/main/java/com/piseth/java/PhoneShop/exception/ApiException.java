package com.piseth.java.PhoneShop.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Getter
@Setter
public class ApiException extends RuntimeException {
    private final HttpStatus status;
    private final String message;
    public ApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
