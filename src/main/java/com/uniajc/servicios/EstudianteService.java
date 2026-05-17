package com.uniajc.servicios;

import com.uniajc.dao.EstudianteDao;
import com.uniajc.modelo.Estudiante;

public class EstudianteService {

    private EstudianteDao dao = new EstudianteDao();

    public void crear(Estudiante e) {
        dao.guardar(e);
    }
}