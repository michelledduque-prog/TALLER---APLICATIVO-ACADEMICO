package com.uniajc.vista;

import com.uniajc.controlador.ControladorGrupo;
import java.util.Scanner;

public class VistaGrupo {

    private static final Scanner SCANNER = new Scanner(System.in);

    public void crearGrupo() {

        ControladorGrupo c = new ControladorGrupo();

        System.out.println("=== GRUPO ===");

        System.out.print("ID Materia: ");
        int idMateria = SCANNER.nextInt();

        System.out.print("ID Docente: ");
        int idDocente = SCANNER.nextInt();
        SCANNER.nextLine(); 

        System.out.print("Aula: ");
        String aula = SCANNER.nextLine();

        System.out.print("Horario: ");
        String horario = SCANNER.nextLine();

        c.crear(idMateria, idDocente, aula, horario);

        System.out.println("Grupo guardado correctamente");
    }
}