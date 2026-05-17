package com.uniajc.servicios;

import com.uniajc.dao.MateriaDao;
import com.uniajc.modelo.Materia;

public class MateriaService {

    private MateriaDao dao = new MateriaDao();

    public void crearMateria(Materia m) {
        if (m.getNombre_materia().isEmpty()) {
            System.out.println("Nombre obligatorio");
            return;
        }
        dao.guardar(m);
    }

    public void crear(Materia m) {
        if (m.getNombre_materia().isEmpty()) {
            System.out.println("Nombre obligatorio");
            return;
        }
        dao.guardar(m);
    }
}