package com.mx.foroAnime.foroAnime.controller;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(@NotNull Integer id, String nombre, String apellido) {
}
