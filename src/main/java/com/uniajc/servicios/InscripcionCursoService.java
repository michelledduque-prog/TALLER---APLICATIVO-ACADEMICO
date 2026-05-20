package com.uniajc.servicios;

import com.uniajc.dao.InscripcionCursoDao;
import com.uniajc.modelo.InscripcionCurso;

public class InscripcionCursoService {

    private InscripcionCursoDao dao = new InscripcionCursoDao();

    public void crear(InscripcionCurso i) {

        dao.guardar(i);
    }
}