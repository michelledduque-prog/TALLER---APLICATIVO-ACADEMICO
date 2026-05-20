package com.uniajc.controlador;

import com.uniajc.dao.GrupoDao;
import com.uniajc.modelo.Grupo;

import java.util.List;

public class ControladorGrupo {

    private GrupoDao dao;

    public ControladorGrupo() {

        dao = new GrupoDao();
    }

    public List<Grupo> listarGrupos() {

        return dao.listar();
    }

    public boolean actualizarGrupo(Grupo grupo) {

        return dao.actualizar(grupo);
    }

    public boolean eliminarGrupo(int idGrupo) {

        return dao.eliminar(idGrupo);
    }

    public boolean guardarGrupo(
            int idMateria,
            int idDocente,
            String aula,
            String horario
    ) {

        Grupo grupo = new Grupo();

        grupo.setIdMateria(idMateria);
        grupo.setIdDocente(idDocente);
        grupo.setAula(aula);
        grupo.setHorario(horario);

        return dao.guardar(grupo);
    }
}