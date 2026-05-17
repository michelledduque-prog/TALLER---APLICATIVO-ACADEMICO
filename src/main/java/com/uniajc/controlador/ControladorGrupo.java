package com.uniajc.controlador;

import com.uniajc.modelo.Grupo;
import com.uniajc.dao.GrupoDao;

public class ControladorGrupo {

    private GrupoDao dao = new GrupoDao();

    public void crear(int mat, int doc, String aula, String horario) {
        Grupo g = new Grupo(0, mat, doc, aula, horario);
        dao.guardar(g);
    }
}
