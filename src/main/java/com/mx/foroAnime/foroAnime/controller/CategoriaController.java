package com.mx.foroAnime.foroAnime.controller;


import com.mx.foroAnime.foroAnime.categoria.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping
    public ResponseEntity<Page<DatosListarCategorias>> listarCategorias(@PageableDefault(size=5) Pageable pageable)
    {
        return ResponseEntity.ok(categoriaRepository.findByActivoTrue(pageable).map(DatosListarCategorias:: new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarDatosCategoria(@RequestBody @Valid DatosActualizarCategoria datosActualizarCategoria)
    {
        Categoria categoria = categoriaRepository.getReferenceById(datosActualizarCategoria.id());
        categoria.actualizarDatos(datosActualizarCategoria);

        return ResponseEntity.ok(new DatosRespuestaCategoria(categoria.getTitulo(), categoria.getDescripcion()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaCategoria> retornarDatosCategorias(@PathVariable Integer id)
    {
        Categoria categoria = categoriaRepository.getReferenceById(id);
        var datosRetorno = new DatosRespuestaCategoria(categoria.getTitulo(), categoria.getDescripcion());
        return ResponseEntity.ok(datosRetorno);
    }
}
