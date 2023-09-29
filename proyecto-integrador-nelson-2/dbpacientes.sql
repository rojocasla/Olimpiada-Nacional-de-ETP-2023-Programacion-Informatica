CREATE DATABASE dbpacientes;

CREATE TABLE pacientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(100),
    dni INT,
    internacion VARCHAR(100),
    observaciones VARCHAR(255)
);

INSERT INTO pacientes (nombre, apellido, dni, internacion, observaciones)
VALUES ('Luis', 'Mendez', 32323232, 'Habitacion 2', 'Se encuentra estable');

INSERT INTO pacientes (nombre, apellido, dni, internacion, observaciones)
VALUES ('Alejandro', 'Rojo', 46680605, 'Habitacion 1', '');

INSERT INTO pacientes (nombre, apellido, dni, internacion, observaciones)
VALUES ('Luciano', 'Bavosa', 4669549, 'Habitacion 3', 'Buen estado');

INSERT INTO pacientes (nombre, apellido, dni, internacion, observaciones)
VALUES ('Ulises', 'Martinez', 43424123, 'Terapia intensiva', 'Empeora día a día');
