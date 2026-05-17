package com.uniajc.servicios;

import com.uniajc.dao.InscripcionDao;
import com.uniajc.modelo.InscripcionCurso;

public class InscripcionService {

    private InscripcionDao dao = new InscripcionDao();

    public void crear(InscripcionCurso i) {
        dao.guardar(i);
    }
}
