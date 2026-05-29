package com.project.tienda.dto;

public class PedidoDTO {

    private Double total;
    private Long usuarioId;

    public PedidoDTO() {
    }

    public PedidoDTO(Double total, Long usuarioId) {
        this.total = total;
        this.usuarioId = usuarioId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}