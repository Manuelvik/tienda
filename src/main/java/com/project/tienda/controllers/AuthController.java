package com.project.tienda.controllers;

import com.project.tienda.dto.AuthResponse;
import com.project.tienda.dto.LoginRequest;
import com.project.tienda.entities.Usuario;
import com.project.tienda.repositories.UsuarioRepository;
import com.project.tienda.security.JwtService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/test")
    public String test() {
        return "FUNCIONA";
    }

    @PostMapping("/register")
    public String register(
            @RequestBody Usuario usuario) {

        usuario.setPassword(
                passwordEncoder.encode(
                        usuario.getPassword()
                )
        );

        usuario.setRol("USER");

        usuarioRepository.save(usuario);

        return "Usuario registrado";
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request) {

        Usuario usuario =
                usuarioRepository
                        .findByEmail(request.getEmail())
                        .orElseThrow();

        if (!passwordEncoder.matches(
                request.getPassword(),
                usuario.getPassword())) {

            throw new RuntimeException(
                    "Contraseña incorrecta"
            );
        }

        String token =
                jwtService.generateToken(
                        usuario.getEmail(),
                        usuario.getRol()
                );

        return new AuthResponse(
                token,
                usuario.getId(),
                usuario.getRol()
        );

    }
}