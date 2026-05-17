package com.uniajc.servicios;

import com.uniajc.dao.GrupoDao;
import com.uniajc.modelo.Grupo;

public class GrupoService {

    private GrupoDao dao = new GrupoDao();

    public void crear(Grupo g) {
        dao.guardar(g);
    }
}
