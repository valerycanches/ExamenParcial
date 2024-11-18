package com.example.ExamenParcial.Excepciones;

// Esta es la clase personalizada de excepciones
public class Excepciones extends RuntimeException {
    public Excepciones(String mensaje) {
        super(mensaje); // Llama al constructor de RuntimeException
    }
}
