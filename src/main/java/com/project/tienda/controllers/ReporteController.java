package com.project.tienda.controllers;

import com.project.tienda.repositories.PedidoRepository;
import com.project.tienda.repositories.ProductoRepository;
import com.project.tienda.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/resumen")
    public Map<String, Object> resumen() {

        Map<String, Object> datos = new HashMap<>();

        datos.put("totalUsuarios", usuarioRepository.count());
        datos.put("totalProductos", productoRepository.count());
        datos.put("totalPedidos", pedidoRepository.count());

        return datos;
    }
}