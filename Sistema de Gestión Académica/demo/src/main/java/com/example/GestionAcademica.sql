CREATE TABLE Alumnos (
    idAl INT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido1 VARCHAR(100),
    apellido2 VARCHAR(100),
    id_curso INT,
    FOREIGN KEY (id_curso) REFERENCES Cursos(idC) ON DELETE CASCADE
);


CREATE TABLE Profesores (
    idP INT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido1 VARCHAR(100,
    apellido2 VARCHAR(100)
);

CREATE TABLE Cursos (
    idC INT PRIMARY KEY,
    nombre VARCHAR(100),
   );

CREATE TABLE Asignaturas (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    id_curso INT,
    FOREIGN KEY (id_curso) REFERENCES Cursos(idC) ON DELETE CASCADE,
    id_profesor INT,
    FOREIGN KEY (id_profesor) REFERENCES Profesores(idP) ON DELETE CASCADE
);

-- Insertando en la tabla Alumnos
INSERT INTO Alumnos (idAl, nombre, apellido1, apellido2, id_curso) VALUES (1, 'Juan', 'Pérez', 'Gómez', 1);
INSERT INTO Alumnos (idAl, nombre, apellido1, apellido2, id_curso) VALUES (2, 'Ana', 'Martínez', 'López', 1);

-- Insertando en la tabla Profesores
INSERT INTO Profesores (idP, nombre, apellido1, apellido2) VALUES (1, 'Carlos', 'Sánchez', 'Rodríguez');
INSERT INTO Profesores (idP, nombre, apellido1, apellido2) VALUES (2, 'María', 'García', 'Fernández');

-- Insertando en la tabla Cursos
INSERT INTO Cursos (idC, nombre) VALUES (1, 'Matemáticas');
INSERT INTO Cursos (idC, nombre) VALUES (2, 'Física');

-- Insertando en la tabla Asignaturas
INSERT INTO Asignaturas (id, nombre, id_curso, id_profesor) VALUES (1, 'Álgebra', 1, 1);
INSERT INTO Asignaturas (id, nombre, id_curso, id_profesor) VALUES (2, 'Cálculo', 1, 2);
