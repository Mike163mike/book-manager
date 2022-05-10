package com.example.mike.bookmanager.controller.advice;

import com.example.mike.bookmanager.exception.AppException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(AppException.class)
    public String exceptionHandler(AppException e) {
        return "Advice is " + e.getMessage();
    }
}
