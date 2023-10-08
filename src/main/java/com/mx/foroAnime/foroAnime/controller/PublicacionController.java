package com.mx.foroAnime.foroAnime.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    @PostMapping
    public void crearPublicacion()
    {
    }
}
