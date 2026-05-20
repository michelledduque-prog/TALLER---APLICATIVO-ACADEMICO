# Nombre 
Michelle Dayanna Duque Marín

### Grupo: 411

```
```


# SISTEMA ACADÉMICO UNIVERSITARIO 

Aplicación académica desarrollada en Java utilizando Swing para la interfaz gráfica y PostgreSQL como sistema de base de datos.

El sistema permite gestionar información de estudiantes, docentes, grupo, inscripción del curso y materias de manera organizada y persistente, almacenando los datos directamente en la base de datos para que permanezcan guardados incluso después de cerrar la aplicación.

---

# Objetivo del Proyecto

Desarrollar una aplicación académica que permita administrar información universitaria utilizando programación orientada a objetos, interfaces gráficas y conexión a bases de datos relacionales.

Además, el proyecto busca aplicar conceptos de:

* Programación orientada a objetos
* Arquitectura por capas
* Conexión a bases de datos
* Interfaces gráficas en Java
* Persistencia de datos

---

# Tecnologías Utilizadas

- Java 21 (LTS)
- Java Swing
- PostgreSQL
- JDBC
- Maven
- Visual Studio Code
- Git & GitHub

---


# Configuración de Base de Datos

La conexión se encuentra en:

```java
URL: jdbc:postgresql://localhost:5433/universidad
USER: postgres
PASSWORD: 12345
```

---

# Funcionalidades del Sistema

se realizo un login,
```java
USUARIO: admin
PASSWORD: 123
```

## Módulo de Estudiantes

Permite registrar información académica y personal de los estudiantes:

* Código del estudiante
* Nombre completo
* Documento
* Carrera
* Semestre
* Correo
* Teléfono
* Dirección

## Módulo de Docentes

Permite registrar información de los docentes:

* ID docente
* Nombre completo
* Especialidad
* Correo
* Teléfono
* Materias asignadas

## Módulo de Grupo


## Módulo de Inscripción de Curso


## Módulo de Materias

---

# Arquitectura del Proyecto

El proyecto está organizado por paquetes:

```bash
modelo/        → Entidades del sistema
dao/           → Operaciones CRUD y acceso a datos
controlador/   → Comunicación entre vista y lógica
vista/         → Interfaces gráficas Swing
config/        → Configuración de conexión PostgreSQL
servicios/     → Lógica de negocio
```

---




