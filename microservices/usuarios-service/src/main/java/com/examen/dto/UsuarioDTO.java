package com.examen.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
    private Long id;

    @NotEmpty(message = "Usuario, no debe ser null o vacio :(")
    private String usuario;

    @NotEmpty(message = "Password, no debe ser null o vacio :(")
    private String password;

    @NotEmpty(message = "Apellido Paterno, no debe ser null o vacio :(")
    private String apellidoPaterno;

    @NotEmpty(message = "Apellido Materno, no debe ser null o vacio :(")
    private String apellidoMaterno;

    @NotEmpty(message = "Telefono, no debe ser null o vacio :(")
    private String telefono;

    @NotEmpty(message = "Correo, no debe ser null o vacio :(")
    @Email(message = "User Email, formato no valido. :(")
    private String correo;
}
