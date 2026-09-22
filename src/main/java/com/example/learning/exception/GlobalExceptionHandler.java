package com.example.learning.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String >> handleValidation(MethodArgumentNotValidException exception){

        Map<String, String > errors = new LinkedHashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error ->{
            errors.putIfAbsent(error.getField(), error.getDefaultMessage());
        });

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String , String >> handleUserNotFound(UserNotFoundException exception){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", exception.getMessage()));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String , String >> handleElementNotFound(NoSuchElementException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "No matching record found"));
    }


}
