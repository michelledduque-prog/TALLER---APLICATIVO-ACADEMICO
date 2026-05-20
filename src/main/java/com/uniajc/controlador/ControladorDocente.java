package com.uniajc.controlador;

import com.uniajc.dao.DocenteDao;
import com.uniajc.modelo.Docente;

import java.util.List;

public class ControladorDocente {

    private DocenteDao dao;

    public ControladorDocente() {
        dao = new DocenteDao();
    }

    public List<Docente> listarDocentes() {
        return dao.listar();
    }

    public boolean actualizarDocente(Docente docente) {
        return dao.actualizar(docente);
    }

    public boolean eliminarDocente(int idDocente) {
        return dao.eliminar(idDocente);
    }

    public boolean guardarDocente(
            String nombreCompleto,
            String correo,
            String telefono,
            String especialidad,
            String materiasAsignadas
    ) {
        Docente docente = new Docente();
        docente.setNombreCompleto(nombreCompleto);
        docente.setCorreo(correo);
        docente.setTelefono(telefono);
        docente.setEspecialidad(especialidad);
        docente.setMateriasAsignadas(materiasAsignadas);
        return dao.guardar(docente);
    }
}

