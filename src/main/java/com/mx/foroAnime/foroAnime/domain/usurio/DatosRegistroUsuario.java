package com.mx.foroAnime.foroAnime.domain.usurio;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @NotBlank
        @Email
        String email,
        @NotNull
        Date fecha_nacimiento,
        @NotBlank
        String usuario_nombre,
        @NotBlank
        String clave)
{ }