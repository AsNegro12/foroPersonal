package com.mx.foroAnime.foroAnime.Usurios;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(@NotNull Integer id, String nombre, String apellido) {
}
