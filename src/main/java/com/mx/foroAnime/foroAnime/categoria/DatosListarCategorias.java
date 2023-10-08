package com.mx.foroAnime.foroAnime.categoria;

public record DatosListarCategorias(String titulo, String descripcion)
{
    public DatosListarCategorias(Categoria categoria)
    {
        this(categoria.getTitulo(), categoria.getDescripcion());
    }
}
