package com.project.tienda.controllers;

import com.project.tienda.dto.CarritoDTO;
import com.project.tienda.entities.Carrito;
import com.project.tienda.services.CarritoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public List<Carrito> listar() {

        return carritoService.listar();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Carrito> listarPorUsuario(
            @PathVariable Long usuarioId) {

        return carritoService
                .listarPorUsuario(usuarioId);
    }

    @PostMapping
    public Carrito agregar(
            @RequestBody CarritoDTO carritoDTO) {

        return carritoService
                .guardar(carritoDTO);
    }

    @PutMapping("/{id}")
    public Carrito actualizarCantidad(
            @PathVariable Long id,
            @RequestBody CarritoDTO carritoDTO) {

        return carritoService
                .actualizarCantidad(
                        id,
                        carritoDTO);
    }

    @DeleteMapping("/{id}")
    public String eliminar(
            @PathVariable Long id) {

        carritoService.eliminar(id);

        return "Producto eliminado del carrito";
    }
}