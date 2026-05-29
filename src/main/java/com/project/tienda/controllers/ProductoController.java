package com.project.tienda.controllers;

import com.project.tienda.dto.ProductoDTO;
import com.project.tienda.entities.Producto;
import com.project.tienda.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> buscarPorCategoria(
            @PathVariable Long categoriaId) {

        return productoService.buscarPorCategoria(categoriaId);
    }

    @GetMapping("/categoria/{categoriaId}/cantidad")
    public Long contarProductosPorCategoria(
            @PathVariable Long categoriaId) {

        return productoService.contarProductosPorCategoria(categoriaId);
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    @GetMapping("/buscar/{nombre}")
    public List<Producto> buscarPorNombre(@PathVariable String nombre) {
        return productoService.buscarPorNombre(nombre);
    }

    @PostMapping
    public Producto guardar(@RequestBody ProductoDTO productoDTO) {
        return productoService.guardar(productoDTO);
    }

    @PutMapping("/{id}")
    public Producto actualizar(
            @PathVariable Long id,
            @RequestBody ProductoDTO productoDTO) {

        return productoService.actualizar(id, productoDTO);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return "Producto eliminado";
    }
}