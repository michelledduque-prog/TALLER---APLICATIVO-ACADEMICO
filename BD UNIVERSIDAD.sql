CREATE DATABASE universidad;


-- TABLA ESTUDIANTE


CREATE TABLE estudiante (
    id_estudiante SERIAL PRIMARY KEY,
    documento VARCHAR(20),
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    correo VARCHAR(100),
    telefono VARCHAR(20),
    programa VARCHAR(100),
    semestre VARCHAR(20)
);



-- TABLA MATERIA


CREATE TABLE materia (
    id_materia SERIAL PRIMARY KEY,
    nombre_materia VARCHAR(50),
    creditos INT
);



-- TABLA DOCENTE


CREATE TABLE docente (
    id_docente SERIAL PRIMARY KEY,
    nombre VARCHAR(50),
    especialidad VARCHAR(50)
);


-- TABLA GRUPO


CREATE TABLE grupo (
    id_grupo SERIAL PRIMARY KEY,
    id_materia INT,
    id_docente INT,
    aula VARCHAR(20),
    horario VARCHAR(20),

    CONSTRAINT fk_materia
        FOREIGN KEY (id_materia)
        REFERENCES materia(id_materia),

    CONSTRAINT fk_docente
        FOREIGN KEY (id_docente)
        REFERENCES docente(id_docente)
);



-- TABLA INSCRIPCION


CREATE TABLE inscripcion_curso (
    id_inscripcion SERIAL PRIMARY KEY,
    id_estudiante INT,
    id_grupo INT,
    nota_final FLOAT,
    estado VARCHAR(20),

    CONSTRAINT fk_estudiante
        FOREIGN KEY (id_estudiante)
        REFERENCES estudiante(id_estudiante),

    CONSTRAINT fk_grupo
        FOREIGN KEY (id_grupo)
        REFERENCES grupo(id_grupo)
);



-- CONSULTAS


SELECT * FROM estudiante;

SELECT * FROM docente;

SELECT * FROM materia;

SELECT * FROM grupo;

SELECT * FROM inscripcion_curso;






DROP TABLE IF EXISTS inscripcion_curso CASCADE;
DROP TABLE IF EXISTS grupo CASCADE;
DROP TABLE IF EXISTS docente CASCADE;
DROP TABLE IF EXISTS materia CASCADE;
DROP TABLE IF EXISTS estudiante CASCADE;


CREATE TABLE estudiante (
    id_estudiante SERIAL PRIMARY KEY,
    documento VARCHAR(20),
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    correo VARCHAR(100),
    telefono VARCHAR(20),
    programa VARCHAR(100),
    semestre VARCHAR(20)
);


CREATE TABLE materia (
    id_materia SERIAL PRIMARY KEY,
    nombre_materia VARCHAR(50),
    creditos INT
);


CREATE TABLE docente (
    id_docente SERIAL PRIMARY KEY,
    nombre VARCHAR(50),
    correo VARCHAR(100),
    materia VARCHAR(100)
);


CREATE TABLE grupo (
    id_grupo SERIAL PRIMARY KEY,
    id_materia INT,
    id_docente INT,
    aula VARCHAR(20),
    horario VARCHAR(20),

    FOREIGN KEY (id_materia)
    REFERENCES materia(id_materia),

    FOREIGN KEY (id_docente)
    REFERENCES docente(id_docente)
);


CREATE TABLE inscripcion_curso (
    id_inscripcion SERIAL PRIMARY KEY,
    id_estudiante INT,
    id_grupo INT,
    nota_final FLOAT,
    estado VARCHAR(20),

    FOREIGN KEY (id_estudiante)
    REFERENCES estudiante(id_estudiante),

    FOREIGN KEY (id_grupo)
    REFERENCES grupo(id_grupo)
);








-- ELIMINAR TABLAS ANTERIORES


DROP TABLE IF EXISTS inscripcion_curso CASCADE;
DROP TABLE IF EXISTS grupo CASCADE;
DROP TABLE IF EXISTS materia CASCADE;
DROP TABLE IF EXISTS docente CASCADE;
DROP TABLE IF EXISTS estudiante CASCADE;



-- TABLA ESTUDIANTE


CREATE TABLE estudiante (

    codigo_estudiante SERIAL PRIMARY KEY,

    nombre_completo VARCHAR(100),

    documento VARCHAR(20),

    carrera VARCHAR(100),

    semestre VARCHAR(20),

    correo VARCHAR(100),

    telefono VARCHAR(20),

    direccion VARCHAR(200)
);


-- TABLA DOCENTE


CREATE TABLE docente (

    id_docente SERIAL PRIMARY KEY,

    nombre_completo VARCHAR(100),

    especialidad VARCHAR(100),

    correo VARCHAR(100),

    telefono VARCHAR(20),

    materias_asignadas VARCHAR(200)
);




SELECT * FROM estudiante;

SELECT * FROM docente;








