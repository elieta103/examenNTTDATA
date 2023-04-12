package com.examen.service;

import com.examen.entity.Usuario;

public interface UsuarioService {
    Usuario crearUsuario(Usuario user);
    Usuario getUsuario(Long id);
    Usuario editarUsuario(Usuario user, Long id);
    void borrarUsuario(Long id);
}
