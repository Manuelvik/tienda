package com.project.tienda.controllers;

import com.project.tienda.dto.DetallePedidoDTO;
import com.project.tienda.entities.DetallePedido;
import com.project.tienda.services.DetallePedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-pedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    public List<DetallePedido> listar() {
        return detallePedidoService.listar();
    }

    @GetMapping("/pedido/{id}")
    public List<DetallePedido> listarPedido(@PathVariable Long id) {
        return detallePedidoService.listarPorPedido(id);
    }

    @PostMapping
    public DetallePedido guardar(@RequestBody DetallePedidoDTO detallePedidoDTO) {
        return detallePedidoService.guardar(detallePedidoDTO);
    }
}