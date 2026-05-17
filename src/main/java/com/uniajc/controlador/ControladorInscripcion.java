package com.uniajc.controlador;

import com.uniajc.modelo.InscripcionCurso;
import com.uniajc.servicios.InscripcionService;

public class ControladorInscripcion {

    private InscripcionService service = new InscripcionService();

    public void crear(int idEstudiante, int idGrupo) {

        InscripcionCurso i = new InscripcionCurso(
                0,
                idEstudiante,
                idGrupo
        );

        service.crear(i);
    }
}