package com.mx.foroAnime.foroAnime.domain.categoria;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DatosRegistrarCategoria(
    @NotBlank
    String titulo,
    @NotBlank
    String descripcion,
    LocalDate fecha_creacion
) { }
