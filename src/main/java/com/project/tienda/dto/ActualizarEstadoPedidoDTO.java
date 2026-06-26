package com.project.tienda.dto;

public class ActualizarEstadoPedidoDTO {

    private String estado;

    public ActualizarEstadoPedidoDTO() {
    }

    public ActualizarEstadoPedidoDTO(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}