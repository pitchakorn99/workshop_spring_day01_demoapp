package com.example.demoapp.employees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeControllerAdvice {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotFound(
            EmployeeNotFoundException exception
    ){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(404);
        errorResponse.setMessage(exception.getMessage());

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
