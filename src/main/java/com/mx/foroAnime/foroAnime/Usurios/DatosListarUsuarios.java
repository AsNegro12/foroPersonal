package com.mx.foroAnime.foroAnime.Usurios;

import com.mx.foroAnime.foroAnime.Usurios.Usuario;

public record DatosListarUsuarios(Integer id, String nombre, String apellido, String email, String usuario_nombre){
    public DatosListarUsuarios(Usuario usuario)
    {
        this(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getUsuarioNombre());
    }
}
