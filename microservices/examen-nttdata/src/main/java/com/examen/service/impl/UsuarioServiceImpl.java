package com.examen.service.impl;

import com.examen.entity.Usuario;
import com.examen.repository.UsuarioRepository;
import com.examen.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario crearUsuario(Usuario user) {
        return usuarioRepository.save(user);
    }

    @Override
    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    @Override
    public Usuario editarUsuario(Usuario usuarioUpd, Long id) {
        Usuario savedUser = null;
        if(usuarioRepository.findById(id).isPresent()) {
            Usuario user = Usuario.builder()
                    .id(id)
                    .usuario(usuarioUpd.getUsuario())
                    .apellidoPaterno(usuarioUpd.getApellidoPaterno())
                    .apellidoMaterno(usuarioUpd.getApellidoMaterno())
                    .password(usuarioUpd.getPassword())
                    .correo(usuarioUpd.getCorreo())
                    .telefono(usuarioUpd.getTelefono())
                    .build();
            savedUser = usuarioRepository.save(user);
            return savedUser;
        }else {
            return null;
        }
    }

    @Override
    public void borrarUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
            if(usuario.isPresent()) {
                usuarioRepository.delete(usuario.get());
            }
    }
}
