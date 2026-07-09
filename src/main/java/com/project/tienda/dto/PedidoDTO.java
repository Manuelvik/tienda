package com.project.tienda.dto;

public class PedidoDTO {

    private Double total;
    private Long usuarioId;
    private String estado;

    private String nombreCliente;
    private String dni;
    private String telefono;
    private String direccion;
    private String distrito;
    private String metodoPago;
    private String observacion;

    public PedidoDTO() {
    }

    public PedidoDTO(
            Double total,
            Long usuarioId,
            String estado,
            String nombreCliente,
            String dni,
            String telefono,
            String direccion,
            String distrito,
            String metodoPago,
            String observacion) {

        this.total = total;
        this.usuarioId = usuarioId;
        this.estado = estado;
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.distrito = distrito;
        this.metodoPago = metodoPago;
        this.observacion = observacion;
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

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}