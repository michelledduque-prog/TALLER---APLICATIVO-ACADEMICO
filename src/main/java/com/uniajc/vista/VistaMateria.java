package com.uniajc.vista;

import com.uniajc.controlador.ControladorMateria;
import java.util.Scanner;

public class VistaMateria {

    private static final Scanner SCANNER = new Scanner(System.in);

    public void crearMateria() {

        ControladorMateria c = new ControladorMateria();

        System.out.println("=== MATERIA ===");

        System.out.print("Nombre: ");
        String nombre = SCANNER.nextLine();

        System.out.print("Creditos: ");
        int creditos = SCANNER.nextInt();

        c.crear(nombre, creditos);

        System.out.println("Materia guardada correctamente");
    }
}