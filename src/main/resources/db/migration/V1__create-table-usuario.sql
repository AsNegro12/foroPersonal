CREATE TABLE usuarios(
    id BIGINT NOT NULL,
    nombre VARCHAR(50) NOT NUll,
    apellido VARCHAR(50) NOT NUll,
    email VARCHAR(100) NOT NULL UNIQUE,
    fecha_nacimiento DATE NOT NULL,
    usuario_nombre VARCHAR(50) NOT NULL UNIQUE,
    clave VARCHAR(255) NOT NULL,

    PRIMARY KEY(id)
);