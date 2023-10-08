package com.mx.foroAnime.foroAnime.controller;

import com.mx.foroAnime.foroAnime.Usurios.*;
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
@RequestMapping("/usuarios")
public class UsuarioController
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaUsuario> registroUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario,
                                                                 UriComponentsBuilder uriComponentsBuilder)
    {
       Usuario usuario = usuarioRepository.save(new Usuario(datosRegistroUsuario));
       DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(
               usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getUsuarioNombre()
       );
       URI url = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

       return  ResponseEntity.created(url).body(datosRespuestaUsuario);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListarUsuarios>> listarUsuarios(@PageableDefault(size=5) Pageable pageable)
    {
        return ResponseEntity.ok(usuarioRepository.findAll(pageable).map(DatosListarUsuarios::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaUsuario> retornarDatosUsuario(@PathVariable Integer id)
    {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        var datosRetorno = new DatosRespuestaUsuario(
            usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getUsuarioNombre());
        return ResponseEntity.ok(datosRetorno);
    }
}
