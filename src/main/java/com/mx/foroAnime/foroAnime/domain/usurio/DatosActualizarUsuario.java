package com.mx.foroAnime.foroAnime.domain.usurio;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(@NotNull Integer id, String nombre, String apellido) {
}
