package com.uniajc.modelo;

public class InscripcionCurso {

    private int id_inscripcion;
    private int id_estudiante;
    private int id_grupo;

    public InscripcionCurso(int id, int estudiante, int grupo) {
        this.id_inscripcion = id;
        this.id_estudiante = estudiante;
        this.id_grupo = grupo;
    }

    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public int getId_grupo() {
        return id_grupo;
    }
}
