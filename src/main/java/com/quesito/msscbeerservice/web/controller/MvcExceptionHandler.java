package com.quesito.msscbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex){
        return new ResponseEntity(ex.getConstraintViolations().stream()
        .map(constraintViolation -> constraintViolation.getMessage())
        .collect(Collectors.toList()), HttpStatus.BAD_REQUEST);
    }
}
