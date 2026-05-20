package com.uniajc.controlador;

import com.uniajc.dao.EstudianteDao;
import com.uniajc.modelo.Estudiante;

import java.util.List;

public class ControladorEstudiante {

    private EstudianteDao dao;

    public ControladorEstudiante() {
        dao = new EstudianteDao();
    }

    public List<Estudiante> listarEstudiantes() {
        return dao.listar();
    }

    public boolean actualizarEstudiante(Estudiante estudiante) {
        return dao.actualizar(estudiante);
    }

    public boolean eliminarEstudiante(int codigoEstudiante) {
        return dao.eliminar(codigoEstudiante);
    }

    public boolean guardarEstudiante(
            String nombreCompleto,
            String documento,
            String carrera,
            String semestre,
            String correo,
            String telefono,
            String direccion
    ) {

        Estudiante estudiante = new Estudiante();

        estudiante.setNombreCompleto(nombreCompleto);
        estudiante.setDocumento(documento);
        estudiante.setCarrera(carrera);
        estudiante.setSemestre(semestre);
        estudiante.setCorreo(correo);
        estudiante.setTelefono(telefono);
        estudiante.setDireccion(direccion);

        return dao.guardar(estudiante);
    }
}


