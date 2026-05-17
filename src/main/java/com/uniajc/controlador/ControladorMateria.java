package com.uniajc.controlador;

import com.uniajc.modelo.Materia;
import com.uniajc.servicios.MateriaService;

public class ControladorMateria {

    private MateriaService service = new MateriaService();

    public void crear(String nombre, int creditos) {

        Materia m = new Materia();
        m.setNombre_materia(nombre);
        m.setCreditos(creditos);

        service.crear(m);
    }
}