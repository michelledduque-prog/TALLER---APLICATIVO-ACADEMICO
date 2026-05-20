package com.uniajc.servicios;

import com.uniajc.dao.MateriaDao;
import com.uniajc.modelo.Materia;

public class MateriaService {

    private MateriaDao dao = new MateriaDao();

    public void crear(Materia m) {

        dao.guardar(m);
    }
}