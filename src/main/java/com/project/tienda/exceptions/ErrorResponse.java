package com.project.tienda.exceptions;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime fecha;
    private String mensaje;
    private int codigo;

    public ErrorResponse() {
    }

    public ErrorResponse(
            LocalDateTime fecha,
            String mensaje,
            int codigo) {

        this.fecha = fecha;
        this.mensaje = mensaje;
        this.codigo = codigo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}