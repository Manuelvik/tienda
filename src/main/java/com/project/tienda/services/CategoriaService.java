package com.project.tienda.services;

import com.project.tienda.dto.CategoriaDTO;
import com.project.tienda.entities.Categoria;
import com.project.tienda.repositories.CategoriaRepository;
import com.project.tienda.exceptions.RecursoNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listar() {

        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(
            Long id) {

        return categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "Categoría no encontrada"));
    }

    public Categoria guardar(
            CategoriaDTO categoriaDTO) {

        Categoria categoria =
                new Categoria();

        categoria.setNombre(
                categoriaDTO.getNombre());

        categoria.setDescripcion(
                categoriaDTO.getDescripcion());

        return categoriaRepository
                .save(categoria);
    }

    public Categoria actualizar(
            Long id,
            CategoriaDTO categoriaDTO) {

        Categoria categoriaDB =
                categoriaRepository
                        .findById(id)
                        .orElseThrow();

        categoriaDB.setNombre(
                categoriaDTO.getNombre());

        categoriaDB.setDescripcion(
                categoriaDTO.getDescripcion());

        return categoriaRepository
                .save(categoriaDB);
    }

    public void eliminar(
            Long id) {

        categoriaRepository
                .deleteById(id);
    }
}