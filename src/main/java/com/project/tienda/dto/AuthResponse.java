package com.project.tienda.dto;

public class AuthResponse {

    private String token;
    private Long usuarioId;
    private String rol;

    public AuthResponse() {
    }

    public AuthResponse(String token, Long usuarioId, String rol) {
        this.token = token;
        this.usuarioId = usuarioId;
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}