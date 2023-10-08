package com.mx.foroAnime.foroAnime.domain.categoria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "categorias")
@Entity(name = "Categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    private Boolean activo;

    public Categoria(DatosRegistrarCategoria datos)
    {
        this.titulo = datos.titulo();
        this.descripcion = datos.descripcion();
        this.fechaCreacion = LocalDate.now();
        this.activo = true;
    }


    public void actualizarDatos(DatosActualizarCategoria datosActualizarCategoria)
    {
        if(datosActualizarCategoria.titulo() != null)
        {
            this.titulo = datosActualizarCategoria.titulo();
        }
        if(datosActualizarCategoria.descripcion() != null)
        {
            this.descripcion = datosActualizarCategoria.descripcion();
        }
    }

    public void desactivarCategoria()
    {
        this.activo = false;
    }
}
