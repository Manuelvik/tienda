package com.project.tienda.dto;

public class CarritoDTO {

    private Integer cantidad;

    private Long usuarioId;

    private Long productoId;

    public CarritoDTO() {
    }

    public CarritoDTO(
            Integer cantidad,
            Long usuarioId,
            Long productoId) {

        this.cantidad = cantidad;
        this.usuarioId = usuarioId;
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(
            Integer cantidad) {

        this.cantidad = cantidad;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(
            Long usuarioId) {

        this.usuarioId = usuarioId;
    }

    public Long getProductoId() {
        return productoId;
    }


    public void setProductoId(
            Long productoId) {

        this.productoId = productoId;
    }
}