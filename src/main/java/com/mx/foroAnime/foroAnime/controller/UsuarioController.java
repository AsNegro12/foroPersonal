package com.mx.foroAnime.foroAnime.controller;

import com.mx.foroAnime.foroAnime.Usurios.DatosRegistroUsuario;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController
{
    public void registroUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario)
    {

    }
}
