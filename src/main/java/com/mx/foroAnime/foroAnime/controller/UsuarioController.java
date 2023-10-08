package com.mx.foroAnime.foroAnime.controller;

import com.mx.foroAnime.foroAnime.domain.usurio.*;
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

    @PutMapping
    @Transactional
    public ResponseEntity actialuzarDatosUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario)
    {
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id());
        usuario.actualizarDatos(datosActualizarUsuario);
        return ResponseEntity.ok(
                new DatosRespuestaUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getUsuarioNombre())
        );
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Integer id)
    {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if(usuario == null)
        {
            return ResponseEntity.notFound().build();
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
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
