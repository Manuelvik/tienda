package com.project.tienda.services;

import com.project.tienda.dto.UsuarioDTO;
import com.project.tienda.entities.Usuario;
import com.project.tienda.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow();
    }

    public Usuario guardar(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();

        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(
                passwordEncoder.encode(usuarioDTO.getPassword())
        );
        usuario.setRol(usuarioDTO.getRol());

        return usuarioRepository.save(usuario);
    }

    public Usuario actualizar(Long id, UsuarioDTO usuarioDTO) {

        Usuario usuarioDB = usuarioRepository.findById(id)
                .orElseThrow();

        usuarioDB.setNombre(usuarioDTO.getNombre());
        usuarioDB.setEmail(usuarioDTO.getEmail());
        usuarioDB.setRol(usuarioDTO.getRol());

        if (usuarioDTO.getPassword() != null &&
                !usuarioDTO.getPassword().isBlank()) {

            usuarioDB.setPassword(
                    passwordEncoder.encode(usuarioDTO.getPassword())
            );
        }

        return usuarioRepository.save(usuarioDB);
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}