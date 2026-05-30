CREATE TABLE mascotas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    raza VARCHAR(20) UNIQUE NOT NULL,
    fecha_nacimiento_mascota DATE
);