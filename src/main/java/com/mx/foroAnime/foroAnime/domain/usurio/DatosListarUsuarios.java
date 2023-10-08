package com.mx.foroAnime.foroAnime.domain.usurio;

public record DatosListarUsuarios(Integer id, String nombre, String apellido, String email, String usuario_nombre){
    public DatosListarUsuarios(Usuario usuario)
    {
        this(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getUsuarioNombre());
    }
}
