package com.mx.foroAnime.foroAnime.Usurios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record DatosRespuestaUsuario(String nombre, String apellido, String email, String usuario_nombre) {
}
