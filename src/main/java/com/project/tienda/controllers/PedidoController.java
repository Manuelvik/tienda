package com.project.tienda.controllers;

import com.project.tienda.dto.PedidoDTO;
import com.project.tienda.entities.Pedido;
import com.project.tienda.services.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.project.tienda.dto.ActualizarEstadoPedidoDTO;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listar();
    }


    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }
    @GetMapping("/estado/{estado}")
    public List<Pedido> buscarPorEstado(
            @PathVariable String estado) {

        return pedidoService.buscarPorEstado(estado);
    }


    @GetMapping("/total-ventas")
    public Double totalVentas() {
        return pedidoService.totalVentas();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Pedido> listarPorUsuario(@PathVariable Long usuarioId) {
        return pedidoService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public Pedido guardar(@RequestBody PedidoDTO pedidoDTO) {
        return pedidoService.guardar(pedidoDTO);
    }

    @PutMapping("/{id}")
    public Pedido actualizar(
            @PathVariable Long id,
            @RequestBody PedidoDTO pedidoDTO) {

        return pedidoService.actualizar(id, pedidoDTO);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        pedidoService.eliminar(id);
        return "Pedido eliminado";
    }
    @PutMapping("/{id}/estado")
    public Pedido actualizarEstado(
            @PathVariable Long id,
            @RequestBody ActualizarEstadoPedidoDTO dto) {

        return pedidoService.actualizarEstado(id, dto);
    }
}