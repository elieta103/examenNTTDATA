package com.examen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "LIQ_MX_MAE_USR_DRO")
public class Usuario {
    @Id
    @Column(name = "ID_USR_PK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TXT_NOMBRE")
    private String usuario;

    @Column(name = "TXT_PASS")
    private String password;

    @Column(name = "TXT_APE_PAT")
    private String apellidoPaterno;

    @Column(name = "TXT_APE_MAT")
    private String apellidoMaterno;

    @Column(name = "TXT_TEL")
    private String telefono;

    @Column(name = "TXT_CORREO")
    private String correo;

    @CreationTimestamp
    @Column(name = "FCH_CARGA")
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    @Column(name = "FCH_ULT_CON")
    private LocalDateTime dateUpdated;

    public Usuario(Long id, String usuario, String password, String apellidoPaterno, String apellidoMaterno,
            String telefono, String correo){
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.correo = correo;
    }
}
