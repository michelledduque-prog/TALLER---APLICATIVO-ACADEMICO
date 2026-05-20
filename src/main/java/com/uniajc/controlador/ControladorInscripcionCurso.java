package com.uniajc.controlador;

import com.uniajc.dao.InscripcionCursoDao;
import com.uniajc.modelo.InscripcionCurso;

import java.util.List;

public class ControladorInscripcionCurso {

    private InscripcionCursoDao dao;

    public ControladorInscripcionCurso() {

        dao = new InscripcionCursoDao();
    }

    public List<InscripcionCurso> listarInscripciones() {

        return dao.listar();
    }

    public boolean actualizarInscripcion(InscripcionCurso inscripcion) {

        return dao.actualizar(inscripcion);
    }

    public boolean eliminarInscripcion(int idInscripcion) {

        return dao.eliminar(idInscripcion);
    }

    public boolean guardarInscripcion(
            int idEstudiante,
            int idGrupo,
            double notaFinal,
            String estado
    ) {

        InscripcionCurso inscripcion = new InscripcionCurso();

        inscripcion.setIdEstudiante(idEstudiante);
        inscripcion.setIdGrupo(idGrupo);
        inscripcion.setNotaFinal(notaFinal);
        inscripcion.setEstado(estado);

        return dao.guardar(inscripcion);
    }
}