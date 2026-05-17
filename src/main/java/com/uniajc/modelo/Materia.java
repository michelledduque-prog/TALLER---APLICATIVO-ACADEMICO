package com.uniajc.modelo;

public class Materia {
    private int id_materia;
    private String nombre_materia;
    private int creditos;

    public Materia() {}

    public Materia(int id, String nombre, int creditos) {
        this.id_materia = id;
        this.nombre_materia = nombre;
        this.creditos = creditos;
    }

    public int getId_materia() { return id_materia; }
    public void setId_materia(int id_materia) { this.id_materia = id_materia; }

    public String getNombre_materia() { return nombre_materia; }
    public void setNombre_materia(String nombre_materia) { this.nombre_materia = nombre_materia; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
}