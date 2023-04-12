package com.examen.controller;

import com.examen.entity.Usuario;
import com.examen.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("/consultar/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioService.getUsuario(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.crearUsuario(usuario));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario, @PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioService.editarUsuario(usuario, id));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") Long id){
        usuarioService.borrarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
