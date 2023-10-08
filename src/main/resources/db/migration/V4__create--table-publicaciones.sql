CREATE TABLE publicaciones(
    id BIGINT NOT NULL auto_increment,
    mesaje VARCHAR(250) NOT NULL,
    fecha_creacion DATE NOT NULL,
    estatus VARCHAR(50) NOT NULL,
    usuario_id BIGINT NOT NULL,
    categoria_id BIGINT NOT NULL,

    PRIMARY KEY(id)
);
ALTER TABLE publicaciones
ADD CONSTRAINT fk_idusuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id);

ALTER TABLE publicaciones
ADD CONSTRAINT fk_idcategoria FOREIGN KEY (categoria_id) REFERENCES categorias(id);
