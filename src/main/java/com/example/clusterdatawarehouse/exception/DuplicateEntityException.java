package com.example.clusterdatawarehouse.exception;

public class DuplicateEntityException extends RuntimeException{
    public DuplicateEntityException(String message) {
        super(message);
    }
}
