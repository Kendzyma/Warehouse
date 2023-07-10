package com.example.clusterdatawarehouse.dto.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse<T> {
    private String message;
    private boolean status;
    private HttpStatus httpStatus;
    private T data;


    public ApiResponse(String message, boolean status, T data,HttpStatus httpStatus) {
        this.message = message;
        this.status = status;
        this.data = data;
        this.httpStatus = httpStatus;
    }
    public ApiResponse(boolean status,String message,HttpStatus httpStatus) {
        this.message = message;
        this.status = status;
        this.httpStatus = httpStatus;
    }
}
