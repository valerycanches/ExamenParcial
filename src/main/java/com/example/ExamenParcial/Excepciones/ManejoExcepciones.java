package com.example.ExamenParcial.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Esta clase captura todas las excepciones personalizadas
@ControllerAdvice
public class ManejoExcepciones {

    // Manejo de excepciones personalizadas
    @ExceptionHandler(Excepciones.class)
    public ResponseEntity<String> manejarExcepcion(Excepciones ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Manejo de excepciones generales (opcional)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarExcepcionGenerica(Exception ex) {
        return new ResponseEntity<>("Ocurrió un error inesperado: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
