package com.cafeiq.exception;

public class SalesNotFoundException extends RuntimeException {

    public SalesNotFoundException(String message) {
        super(message);
    }
}