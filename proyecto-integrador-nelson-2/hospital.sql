CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    contrasena VARCHAR(100) NOT NULL,
    rol ENUM('administrador', 'usuario_generico') NOT NULL
);


INSERT INTO usuarios (nombre, contrasena, rol) VALUES ('admin', 'administrador', 'administrador');

INSERT INTO usuarios (nombre, contrasena, rol) VALUES ('user', 'usuarioo', 'usuario_generico');

GRANT SELECT, INSERT, UPDATE, DELETE ON dbpacientes.* TO 'administrador'@'localhost';

GRANT SELECT, UPDATE ON dbpacientes.* TO 'usuario_generico'@'localhost';
