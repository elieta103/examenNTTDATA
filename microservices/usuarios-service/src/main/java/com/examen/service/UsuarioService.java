package com.examen.service;

import com.examen.dto.UsuarioDTO;

public interface UsuarioService {
    UsuarioDTO crearUsuario(UsuarioDTO userDTO);
    UsuarioDTO getUsuario(Long id);
    UsuarioDTO editarUsuario(UsuarioDTO user, Long id);
    void borrarUsuario(Long id);
}
