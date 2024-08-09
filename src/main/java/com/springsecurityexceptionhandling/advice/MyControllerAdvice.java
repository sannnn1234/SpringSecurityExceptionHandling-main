package com.springsecurityexceptionhandling.advice;

import com.springsecurityexceptionhandling.customException.EmptyInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler (EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException, WebRequest request){
        return new ResponseEntity<String>("Input field is Empty Please look into it" , HttpStatus.BAD_REQUEST);
    }
}
