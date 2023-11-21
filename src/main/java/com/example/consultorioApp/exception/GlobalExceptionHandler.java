package com.example.consultorioApp.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class GlobalExceptionHandler  {

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
    public Map<String, String> manejarResourceNotFoundException(ResourceNotFoundException e) {
        Map<String, String> exceptionMessage  = new HashMap<>();
        exceptionMessage.put("message", "Recurso no encontrado " + e.getMessage());
        return exceptionMessage;
    }

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    public Map<String, String> manejarBadRequestException(BadRequestException e) {
        Map<String, String> exceptionMessage  = new HashMap<>();
        exceptionMessage.put("message", "Solicitud incorrecta: " + e.getMessage());
        return exceptionMessage;
    }

}

