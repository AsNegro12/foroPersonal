package com.mx.foroAnime.foroAnime.domain.usurio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "usuario_nombre")
    private String usuarioNombre;
    @Column(name = "clave")
    private String clave;

    public Usuario(DatosRegistroUsuario datos)
    {
        this.nombre = datos.nombre();
        this.apellido = datos.apellido();
        this.email = datos.email();
        this.fechaNacimiento = datos.fecha_nacimiento();
        this.usuarioNombre = datos.usuario_nombre();
        this.clave = datos.clave();
    }

    public void actualizarDatos(DatosActualizarUsuario datosActualizarUsuario)
    {
        if(datosActualizarUsuario.nombre() != null)
        {
            this.nombre = datosActualizarUsuario.nombre();
        }
        if(datosActualizarUsuario.apellido() != null)
        {
            this.apellido = datosActualizarUsuario.apellido();
        }
    }
}
