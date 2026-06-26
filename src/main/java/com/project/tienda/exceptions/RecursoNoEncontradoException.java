package com.project.tienda.exceptions;

public class RecursoNoEncontradoException
        extends RuntimeException {

    public RecursoNoEncontradoException(
            String mensaje) {

        super(mensaje);
    }
}