package com.project.tienda.repositories;

import com.project.tienda.entities.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository
        extends JpaRepository<Producto, Long> {

    @Query("""
            SELECT p
            FROM Producto p
            WHERE LOWER(p.nombre)
            LIKE LOWER(CONCAT('%', :nombre, '%'))
            """)
    List<Producto> buscarPorNombre(
            @Param("nombre") String nombre);

    @Query("""
            SELECT p
            FROM Producto p
            WHERE p.categoria.id = :categoriaId
            """)
    List<Producto> buscarPorCategoria(
            @Param("categoriaId") Long categoriaId);

    @Query("""
            SELECT COUNT(p)
            FROM Producto p
            WHERE p.categoria.id = :categoriaId
            """)
    Long contarProductosPorCategoria(
            @Param("categoriaId") Long categoriaId);
}