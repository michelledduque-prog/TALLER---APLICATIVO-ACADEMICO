package com.uniajc.servicios;

import com.uniajc.dao.DocenteDao;
import com.uniajc.modelo.Docente;

public class DocenteService {

    private DocenteDao dao = new DocenteDao();

    public void crear(Docente d) {
        dao.guardar(d);
    }
}
