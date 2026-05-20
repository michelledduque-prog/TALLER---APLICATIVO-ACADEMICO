package com.uniajc.controlador;

import com.uniajc.dao.MateriaDao;
import com.uniajc.modelo.Materia;

import java.util.List;

public class ControladorMateria {

    private MateriaDao dao;

    public ControladorMateria() {

        dao = new MateriaDao();
    }

    public List<Materia> listarMaterias() {

        return dao.listar();
    }

    public boolean actualizarMateria(Materia materia) {

        return dao.actualizar(materia);
    }

    public boolean eliminarMateria(int idMateria) {

        return dao.eliminar(idMateria);
    }

    public boolean guardarMateria(
            String nombreMateria,
            int creditos
    ) {

        Materia materia = new Materia();

        materia.setNombreMateria(nombreMateria);
        materia.setCreditos(creditos);

        return dao.guardar(materia);
    }
}