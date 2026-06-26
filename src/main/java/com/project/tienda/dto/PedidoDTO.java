package com.project.tienda.dto;

public class PedidoDTO {

    private Double total;
    private Long usuarioId;
    private String estado;

    public PedidoDTO() {
    }

    public PedidoDTO(Double total, Long usuarioId, String estado) {
        this.total = total;
        this.usuarioId = usuarioId;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}