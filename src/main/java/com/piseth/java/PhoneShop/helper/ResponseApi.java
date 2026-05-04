package com.piseth.java.PhoneShop.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseApi <T>{
    private HttpStatus status;
    private String message;
    private T data;
    private LocalDateTime timestamp =  LocalDateTime.now();

    public ResponseApi(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T>ResponseApi<T> ok(T data) {
        return new ResponseApi<>(HttpStatus.OK, "Success", data);
    }
    public static <T>ResponseApi<T> created(T data) {
        return new ResponseApi<>(HttpStatus.CREATED, "Created", data);
    }

    public static <T>ResponseApi<T> deleted(T data, HttpStatus status) {
        return new ResponseApi<>(status, "Deleted success", data);
    }

}
