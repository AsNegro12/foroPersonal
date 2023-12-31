package com.mx.foroAnime.foroAnime.domain.categoria;

public record DatosListarCategorias(Integer id, String titulo, String descripcion)
{
    public DatosListarCategorias(Categoria categoria)
    {
        this(categoria.getId(),categoria.getTitulo(), categoria.getDescripcion());
    }
}
