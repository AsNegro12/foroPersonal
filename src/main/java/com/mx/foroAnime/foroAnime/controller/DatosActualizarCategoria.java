package com.mx.foroAnime.foroAnime.controller;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DatosActualizarCategoria(@NotNull Integer id, String titulo, String descripcion) { }
