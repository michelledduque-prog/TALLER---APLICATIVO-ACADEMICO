CREATE DATABASE universidad;


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



-- TABLA MATERIA

CREATE TABLE materia (

    id_materia SERIAL PRIMARY KEY,

    nombre_materia VARCHAR(100),

    creditos INT
);



-- TABLA GRUPO


CREATE TABLE grupo (

    id_grupo SERIAL PRIMARY KEY,

    id_materia INT REFERENCES materia(id_materia),

    id_docente INT REFERENCES docente(id_docente),

    aula VARCHAR(20),

    horario VARCHAR(50)
);



-- TABLA INSCRIPCION CURSO


CREATE TABLE inscripcion_curso (

    id_inscripcion SERIAL PRIMARY KEY,

    id_estudiante INT REFERENCES estudiante(codigo_estudiante),

    id_grupo INT REFERENCES grupo(id_grupo),

    nota_final DOUBLE PRECISION,

    estado VARCHAR(30)
);



-- CONSULTAS PARA VERIFICAR


SELECT * FROM estudiante;

SELECT * FROM docente;

SELECT * FROM materia;

SELECT * FROM grupo;

SELECT * FROM inscripcion_curso;





-- ELIMINAR TABLAS

DROP TABLE IF EXISTS inscripcion_curso;

DROP TABLE IF EXISTS grupo;

DROP TABLE IF EXISTS materia;



-- TABLA MATERIA

CREATE TABLE materia (

    id_materia SERIAL PRIMARY KEY,

    nombre_materia VARCHAR(100),

    creditos INT
);

-- TABLA GRUPO

CREATE TABLE grupo (

    id_grupo SERIAL PRIMARY KEY,

    id_materia INT REFERENCES materia(id_materia),

    id_docente INT REFERENCES docente(id_docente),

    aula VARCHAR(20),

    horario VARCHAR(50)
);

-- TABLA INSCRIPCION CURSO

CREATE TABLE inscripcion_curso (

    id_inscripcion SERIAL PRIMARY KEY,

    id_estudiante INT REFERENCES estudiante(codigo_estudiante),

    id_grupo INT REFERENCES grupo(id_grupo),

    nota_final DOUBLE PRECISION,

    estado VARCHAR(30)
);





SELECT * FROM materia;

SELECT * FROM grupo;

SELECT * FROM inscripcion_curso;









