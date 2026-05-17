package com.uniajc.vista;

import java.util.Scanner;
import com.uniajc.controlador.ControladorInscripcion;

public class VistaInscripcion {

    private static final Scanner SCANNER = new Scanner(System.in);

    public void crearInscripcion() {

        ControladorInscripcion c = new ControladorInscripcion();

        System.out.println("=== INSCRIPCIÓN ===");

        System.out.print("ID Estudiante: ");
        int idEstudiante = SCANNER.nextInt();

        System.out.print("ID Grupo: ");
        int idGrupo = SCANNER.nextInt();

        c.crear(idEstudiante, idGrupo);

        System.out.println("Inscripción guardada correctamente");
    }
}