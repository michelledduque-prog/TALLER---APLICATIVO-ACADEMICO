package com.uniajc.vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaPrincipalSwing extends JFrame {

    public VistaPrincipalSwing() {

        setTitle("Sistema Académico");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("MENÚ PRINCIPAL");
        titulo.setBounds(120, 30, 300, 40);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 26));

        JButton btnDocentes = new JButton("DOCENTES");
        btnDocentes.setBounds(150, 100, 180, 40);

        JButton btnEstudiantes = new JButton("ESTUDIANTES");
        btnEstudiantes.setBounds(150, 160, 180, 40);

        JButton btnMaterias = new JButton("MATERIAS");
        btnMaterias.setBounds(150, 220, 180, 40);

        JButton btnGrupos = new JButton("GRUPOS");
        btnGrupos.setBounds(150, 280, 180, 40);

        JButton btnInscripciones = new JButton("INSCRIPCIONES");
        btnInscripciones.setBounds(150, 340, 180, 40);

        // BOTÓN DOCENTES
        btnDocentes.addActionListener(e -> {

            VistaDocenteSwing docente = new VistaDocenteSwing();
            docente.setVisible(true);

        });

        // BOTÓN ESTUDIANTES
        btnEstudiantes.addActionListener(e -> {

            VistaEstudianteSwing estudiante = new VistaEstudianteSwing();
            estudiante.setVisible(true);

        });

        panel.add(titulo);

        panel.add(btnDocentes);
        panel.add(btnEstudiantes);
        panel.add(btnMaterias);
        panel.add(btnGrupos);
        panel.add(btnInscripciones);

        add(panel);
    }
}