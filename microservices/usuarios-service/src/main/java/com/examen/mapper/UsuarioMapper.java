package com.examen.mapper;

import com.examen.dto.UsuarioDTO;
import com.examen.entity.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO mapToUserDto(Usuario user){
        UsuarioDTO userDto = new UsuarioDTO(user.getId(), user.getUsuario(), user.getPassword(), user.getApellidoPaterno(), user.getApellidoMaterno(), user.getTelefono(), user.getCorreo());
        return  userDto;
    }

    public static Usuario mapToUser(UsuarioDTO userDto){
        Usuario user = new Usuario(userDto.getId(), userDto.getUsuario(), userDto.getPassword(), userDto.getApellidoPaterno(), userDto.getApellidoMaterno(), userDto.getTelefono(), userDto.getCorreo());
        return  user;
    }
}
