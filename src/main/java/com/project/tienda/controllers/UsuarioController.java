package com.project.tienda.controllers;

import com.project.tienda.dto.UsuarioDTO;
import com.project.tienda.entities.Usuario;
import com.project.tienda.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    public Usuario guardar(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.guardar(usuarioDTO);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(
            @PathVariable Long id,
            @RequestBody UsuarioDTO usuarioDTO) {

        return usuarioService.actualizar(id, usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return "Usuario eliminado";
    }
}