package com.mx.foroAnime.foroAnime.Usurios;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @NotBlank
        @Email
        String email,
        @NotBlank
        Date fecha_nacimiento,
        @NotBlank
        String usuario_nombre,
        @NotBlank
        String clave)
{ }