package com.mx.foroAnime.foroAnime.controller;


import com.mx.foroAnime.foroAnime.categoria.Categoria;
import com.mx.foroAnime.foroAnime.categoria.CategoriaRepository;
import com.mx.foroAnime.foroAnime.categoria.DatosRegistrarCategoria;
import com.mx.foroAnime.foroAnime.categoria.DatosRespuestaCategoria;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaController
{
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaCategoria> registrarCategoria(@RequestBody @Valid DatosRegistrarCategoria datos, UriComponentsBuilder uriComponentsBuilder)
    {
        Categoria categoria = categoriaRepository.save(new Categoria(datos));
        DatosRespuestaCategoria datosRespuestaCategoria = new DatosRespuestaCategoria(
                categoria.getTitulo(), categoria.getDescripcion()
        );
        URI url = uriComponentsBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaCategoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaCategoria> retornarDatosUsuario(@PathVariable Integer id)
    {
        Categoria categoria = categoriaRepository.getReferenceById(id);
        var datosRetorno = new DatosRespuestaCategoria(categoria.getTitulo(), categoria.getDescripcion());
        return ResponseEntity.ok(datosRetorno);
    }
}
