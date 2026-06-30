package com.project.tienda.services;

import com.project.tienda.dto.ProductoDTO;
import com.project.tienda.entities.Categoria;
import com.project.tienda.entities.Producto;
import com.project.tienda.repositories.CategoriaRepository;
import com.project.tienda.repositories.ProductoRepository;
import com.project.tienda.exceptions.RecursoNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "Producto no encontrado"));
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.buscarPorNombre(nombre);
    }

    public Producto guardar(ProductoDTO productoDTO) {

        Categoria categoria = categoriaRepository
                .findById(productoDTO.getCategoriaId())
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "Categoría no encontrada"));

        Producto producto = new Producto();

        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());
        producto.setImagenUrl(productoDTO.getImagenUrl());
        producto.setCategoria(categoria);

        return productoRepository.save(producto);
    }

    public Producto actualizar(Long id, ProductoDTO productoDTO) {

        Producto productoDB = productoRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "Producto no encontrado"));

        Categoria categoria = categoriaRepository
                .findById(productoDTO.getCategoriaId())
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "Categoría no encontrada"));

        productoDB.setNombre(productoDTO.getNombre());
        productoDB.setDescripcion(productoDTO.getDescripcion());
        productoDB.setPrecio(productoDTO.getPrecio());
        productoDB.setStock(productoDTO.getStock());
        productoDB.setImagenUrl(productoDTO.getImagenUrl());
        productoDB.setCategoria(categoria);

        return productoRepository.save(productoDB);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> buscarPorCategoria(Long categoriaId) {
        return productoRepository.buscarPorCategoria(categoriaId);
    }

    public Long contarProductosPorCategoria(Long categoriaId) {
        return productoRepository.contarProductosPorCategoria(categoriaId);
    }
}