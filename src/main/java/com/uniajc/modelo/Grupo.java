package com.uniajc.modelo;

public class Grupo {
    private int id_grupo;
    private int id_materia;
    private int id_docente;
    private String aula;
    private String horario;

    public Grupo(int id, int mat, int doc, String aula, String horario) {
        this.id_grupo = id;
        this.id_materia = mat;
        this.id_docente = doc;
        this.aula = aula;
        this.horario = horario;
    }

    public int getId_grupo() { return id_grupo; }
    public int getId_materia() { return id_materia; }
    public int getId_docente() { return id_docente; }
    public String getAula() { return aula; }
    public String getHorario() { return horario; }
}