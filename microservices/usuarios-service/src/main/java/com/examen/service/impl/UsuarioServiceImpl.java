package com.examen.service.impl;

import com.examen.dto.UsuarioDTO;
import com.examen.entity.Usuario;
import com.examen.exception.EmailAlreadyExistsException;
import com.examen.exception.ResourceNotFoundException;
import com.examen.repository.UsuarioRepository;
import com.examen.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO userDTO) {
        Optional<Usuario> optionalUser = usuarioRepository.findByCorreo(userDTO.getCorreo());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Correo existente!");
        }

        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        Usuario usuario = modelMapper.map(userDTO, Usuario.class);
        Usuario usuarioSaved = usuarioRepository.save(usuario);
        return modelMapper.map(usuarioSaved, UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO getUsuario(Long id) {
        Usuario user = usuarioRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Usuario", "id", id));
        return modelMapper.map(user, UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO editarUsuario(UsuarioDTO usuarioDTO, Long id) {
        Usuario existingUser = usuarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuario", "id", id));

        existingUser.setId(id);
        existingUser.setUsuario(usuarioDTO.getUsuario());
        existingUser.setApellidoPaterno(usuarioDTO.getApellidoPaterno());
        existingUser.setApellidoMaterno(usuarioDTO.getApellidoMaterno());
        existingUser.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
        existingUser.setTelefono(usuarioDTO.getTelefono());
        existingUser.setCorreo(usuarioDTO.getCorreo());

        Usuario savedUser = usuarioRepository.save(existingUser);
        return modelMapper.map(savedUser, UsuarioDTO.class);
    }

    @Override
    public void borrarUsuario(Long id) {
        Usuario existingUser = usuarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuario", "id", id));
        usuarioRepository.deleteById(id);
    }
}
