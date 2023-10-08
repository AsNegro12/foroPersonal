package com.mx.foroAnime.foroAnime.domain.publicacion;

import com.mx.foroAnime.foroAnime.domain.usurio.Usuario;
import com.mx.foroAnime.foroAnime.domain.categoria.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Table(name = "publicaciones")
@Entity(name = "Publicacion")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Publicacion
{
    //específicamente en el contexto de frameworks como Java Persistence API (JPA) o Hibernate.
    // Esta anotación se usa para configurar cómo se generan los valores de las claves primarias de
    // las entidades en una base de datos cuando se insertan registros.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String mesaje;
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private EstatusPublicacion estatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuarios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
