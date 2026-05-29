package com.project.tienda.controllers;

import com.project.tienda.dto.CategoriaDTO;
import com.project.tienda.entities.Categoria;
import com.project.tienda.services.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar() {

        return categoriaService.listar();
    }

    @GetMapping("/{id}")
    public Categoria buscar(
            @PathVariable Long id) {

        return categoriaService.buscarPorId(id);
    }

    @PostMapping
    public Categoria guardar(
            @RequestBody CategoriaDTO categoriaDTO) {

        return categoriaService.guardar(
                categoriaDTO);
    }

    @PutMapping("/{id}")
    public Categoria actualizar(
            @PathVariable Long id,
            @RequestBody CategoriaDTO categoriaDTO) {

        return categoriaService.actualizar(
                id,
                categoriaDTO);
    }

    @DeleteMapping("/{id}")
    public String eliminar(
            @PathVariable Long id) {

        categoriaService.eliminar(id);

        return "Categoría eliminada";
    }
}