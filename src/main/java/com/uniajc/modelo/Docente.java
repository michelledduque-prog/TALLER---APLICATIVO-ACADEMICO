package com.uniajc.modelo;

public class Docente {

    private int idDocente;
    private String nombreCompleto;
    private String especialidad;
    private String correo;
    private String telefono;
    private String materiasAsignadas;

   

    public Docente() {
    }

 

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMateriasAsignadas() {
        return materiasAsignadas;
    }

    public void setMateriasAsignadas(String materiasAsignadas) {
        this.materiasAsignadas = materiasAsignadas;
    }
}

