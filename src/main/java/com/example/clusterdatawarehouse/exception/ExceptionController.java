package com.example.clusterdatawarehouse.exception;

import com.example.clusterdatawarehouse.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(DuplicateEntityException.class)
    public ApiResponse<String> CustomerNotFoundException(DuplicateEntityException ex) {
        return new ApiResponse<>(false,ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BadRequestException.class)
    public ApiResponse<String> Bad(BadRequestException ex) {
        return new ApiResponse<>(false, ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
