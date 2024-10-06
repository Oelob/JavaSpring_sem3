package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handlerIlligalArgumentException(IllegalArgumentException e){
        return ResponseEntity.badRequest().build();
    }@ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handlerNoSuchArgumentException(NoSuchElementException e){
        return ResponseEntity.notFound().build();
    }
}
