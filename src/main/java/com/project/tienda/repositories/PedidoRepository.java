package com.project.tienda.repositories;

import com.project.tienda.entities.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository
        extends JpaRepository<Pedido, Long> {

    List<Pedido> findByUsuarioId(Long usuarioId);

    @Query("""
            SELECT p
            FROM Pedido p
            WHERE p.estado = :estado
            """)
    List<Pedido> buscarPorEstado(
            @Param("estado") String estado);

    @Query("""
            SELECT SUM(p.total)
            FROM Pedido p
            """)
    Double totalVentas();
}