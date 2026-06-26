package com.project.tienda.services;

import com.project.tienda.dto.DetallePedidoDTO;
import com.project.tienda.entities.DetallePedido;
import com.project.tienda.entities.Pedido;
import com.project.tienda.entities.Producto;
import com.project.tienda.repositories.DetallePedidoRepository;
import com.project.tienda.repositories.PedidoRepository;
import com.project.tienda.repositories.ProductoRepository;
import com.project.tienda.exceptions.RecursoNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<DetallePedido> listar() {
        return detallePedidoRepository.findAll();
    }

    public List<DetallePedido> listarPorPedido(Long pedidoId) {
        return detallePedidoRepository.findByPedidoId(pedidoId);
    }

    public DetallePedido guardar(DetallePedidoDTO detallePedidoDTO) {

        Pedido pedido = pedidoRepository.findById(detallePedidoDTO.getPedidoId())
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "Pedido no encontrado"));

        Producto producto = productoRepository.findById(detallePedidoDTO.getProductoId())
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "Producto no encontrado"));

        DetallePedido detalle = new DetallePedido();

        detalle.setCantidad(detallePedidoDTO.getCantidad());
        detalle.setPrecioUnitario(detallePedidoDTO.getPrecioUnitario());
        detalle.setPedido(pedido);
        detalle.setProducto(producto);

        return detallePedidoRepository.save(detalle);
    }

}