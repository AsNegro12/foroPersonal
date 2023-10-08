CREATE TABLE categorias(
    id BIGINT NOT NULL auto_increment,
    titulo VARCHAR(50) NOT NUll UNIQUE,
    descripcion VARCHAR(150) NOT NUll,
    fecha_creacion DATE NOT NULL,

    PRIMARY KEY(id)
);