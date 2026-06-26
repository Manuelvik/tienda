package com.project.tienda.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            RecursoNoEncontradoException.class)
    public ResponseEntity<ErrorResponse>
    manejarNoEncontrado(
            RecursoNoEncontradoException ex) {

        ErrorResponse error =
                new ErrorResponse(
                        LocalDateTime.now(),
                        ex.getMessage(),
                        404);

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND);
    }
}