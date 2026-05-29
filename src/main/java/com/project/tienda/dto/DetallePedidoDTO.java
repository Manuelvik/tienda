package com.project.tienda.dto;

public class DetallePedidoDTO {

    private Integer cantidad;

    private Double precioUnitario;

    private Long pedidoId;

    private Long productoId;

    public DetallePedidoDTO() {
    }

    public DetallePedidoDTO(
            Integer cantidad,
            Double precioUnitario,
            Long pedidoId,
            Long productoId) {

        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.pedidoId = pedidoId;
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }
}