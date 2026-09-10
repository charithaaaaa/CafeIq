package com.cafeiq.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MenuNotFoundException.class)
    public ResponseEntity<String> handleMenuNotFound(MenuNotFoundException ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(CategoryNotFoundException.class)
public ResponseEntity<String> handleCategoryNotFound(CategoryNotFoundException ex) {

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);

}

@ExceptionHandler(InsufficientStockException.class)
public ResponseEntity<String> handleInsufficientStockException(
        InsufficientStockException ex) {

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
}

}