package com.project.tienda.services;

import com.project.tienda.dto.PedidoDTO;
import com.project.tienda.entities.Pedido;
import com.project.tienda.entities.Usuario;
import com.project.tienda.repositories.PedidoRepository;
import com.project.tienda.repositories.UsuarioRepository;
import com.project.tienda.exceptions.RecursoNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.tienda.dto.ActualizarEstadoPedidoDTO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "Pedido no encontrado"));
    }

    public List<Pedido> listarPorUsuario(Long usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId);
    }

    public Pedido guardar(PedidoDTO pedidoDTO) {

        Usuario usuario = usuarioRepository.findById(pedidoDTO.getUsuarioId())
                .orElseThrow();

        Pedido pedido = new Pedido();

        pedido.setFecha(LocalDateTime.now());
        pedido.setEstado("PENDIENTE");
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setUsuario(usuario);

        pedido.setNombreCliente(pedidoDTO.getNombreCliente());
        pedido.setDni(pedidoDTO.getDni());
        pedido.setTelefono(pedidoDTO.getTelefono());
        pedido.setDireccion(pedidoDTO.getDireccion());
        pedido.setDistrito(pedidoDTO.getDistrito());
        pedido.setMetodoPago(pedidoDTO.getMetodoPago());
        pedido.setObservacion(pedidoDTO.getObservacion());

        return pedidoRepository.save(pedido);
    }

    public Pedido actualizar(Long id, PedidoDTO pedidoDTO) {

        Pedido pedidoDB = pedidoRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "Pedido no encontrado"));

        pedidoDB.setTotal(pedidoDTO.getTotal());

        if (pedidoDTO.getEstado() != null) {
            pedidoDB.setEstado(pedidoDTO.getEstado());
        }

        if (pedidoDTO.getNombreCliente() != null) {
            pedidoDB.setNombreCliente(pedidoDTO.getNombreCliente());
        }

        if (pedidoDTO.getDni() != null) {
            pedidoDB.setDni(pedidoDTO.getDni());
        }

        if (pedidoDTO.getTelefono() != null) {
            pedidoDB.setTelefono(pedidoDTO.getTelefono());
        }

        if (pedidoDTO.getDireccion() != null) {
            pedidoDB.setDireccion(pedidoDTO.getDireccion());
        }

        if (pedidoDTO.getDistrito() != null) {
            pedidoDB.setDistrito(pedidoDTO.getDistrito());
        }

        if (pedidoDTO.getMetodoPago() != null) {
            pedidoDB.setMetodoPago(pedidoDTO.getMetodoPago());
        }

        if (pedidoDTO.getObservacion() != null) {
            pedidoDB.setObservacion(pedidoDTO.getObservacion());
        }

        return pedidoRepository.save(pedidoDB);
    }

    public void eliminar(Long id) {
        pedidoRepository.deleteById(id);
    }
    public List<Pedido> buscarPorEstado(String estado) {
        return pedidoRepository.buscarPorEstado(estado);
    }

    public Double totalVentas() {
        Double total = pedidoRepository.totalVentas();
        return total != null ? total : 0.0;
    }

    public Pedido actualizarEstado(
            Long id,
            ActualizarEstadoPedidoDTO dto) {

        Pedido pedidoDB = pedidoRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "Pedido no encontrado"));

        List<String> estadosValidos = List.of(
                "PENDIENTE",
                "CONFIRMADO",
                "EN_PREPARACION",
                "EN_CAMINO",
                "ENTREGADO",
                "CANCELADO"
        );

        if (dto.getEstado() == null || !estadosValidos.contains(dto.getEstado())) {
            throw new RuntimeException("Estado de pedido no válido");
        }

        pedidoDB.setEstado(dto.getEstado());

        return pedidoRepository.save(pedidoDB);
    }
}