package com.project.tienda.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/productos")
public class ImagenProductoController {

    private final Path carpetaProductos = Paths.get("uploads/productos");

    @PostMapping("/imagen")
    public ResponseEntity<?> subirImagen(@RequestParam("imagen") MultipartFile imagen) {

        try {
            if (imagen.isEmpty()) {
                return ResponseEntity.badRequest().body("La imagen está vacía");
            }

            String contentType = imagen.getContentType();

            if (contentType == null || !contentType.startsWith("image/")) {
                return ResponseEntity.badRequest().body("El archivo debe ser una imagen");
            }

            Files.createDirectories(carpetaProductos);

            String nombreOriginal = imagen.getOriginalFilename();

            if (nombreOriginal == null || nombreOriginal.isBlank()) {
                return ResponseEntity.badRequest().body("Nombre de archivo inválido");
            }

            String extension = "";

            int punto = nombreOriginal.lastIndexOf(".");
            if (punto >= 0) {
                extension = nombreOriginal.substring(punto);
            }

            String nombreArchivo = UUID.randomUUID().toString() + extension;

            Path rutaDestino = carpetaProductos.resolve(nombreArchivo);

            Files.copy(imagen.getInputStream(), rutaDestino, StandardCopyOption.REPLACE_EXISTING);

            String urlImagen = "http://localhost:8080/uploads/productos/" + nombreArchivo;

            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("imagenUrl", urlImagen);

            return ResponseEntity.ok(respuesta);

        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error al subir imagen: " + e.getMessage());
        }
    }
}