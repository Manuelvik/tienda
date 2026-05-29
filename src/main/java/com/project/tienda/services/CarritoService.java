package com.project.tienda.services;

import com.project.tienda.dto.CarritoDTO;
import com.project.tienda.entities.Carrito;
import com.project.tienda.entities.Producto;
import com.project.tienda.entities.Usuario;
import com.project.tienda.repositories.CarritoRepository;
import com.project.tienda.repositories.ProductoRepository;
import com.project.tienda.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<Carrito> listar() {

        return carritoRepository.findAll();
    }

    public List<Carrito> listarPorUsuario(
            Long usuarioId) {

        return carritoRepository
                .findByUsuarioId(usuarioId);
    }

    public Carrito guardar(
            CarritoDTO carritoDTO) {

        Usuario usuario =
                usuarioRepository
                        .findById(
                                carritoDTO.getUsuarioId())
                        .orElseThrow();

        Producto producto =
                productoRepository
                        .findById(
                                carritoDTO.getProductoId())
                        .orElseThrow();

        Carrito carrito =
                new Carrito();

        carrito.setCantidad(
                carritoDTO.getCantidad());

        carrito.setUsuario(usuario);

        carrito.setProducto(producto);

        return carritoRepository
                .save(carrito);
    }

    public Carrito actualizarCantidad(
            Long id,
            CarritoDTO carritoDTO) {

        Carrito carritoDB =
                carritoRepository
                        .findById(id)
                        .orElseThrow();

        carritoDB.setCantidad(
                carritoDTO.getCantidad());

        return carritoRepository
                .save(carritoDB);
    }


    public void eliminar(
            Long id) {

        carritoRepository
                .deleteById(id);
    }
}