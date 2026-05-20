package com.uniajc.vista;

import com.uniajc.controlador.ControladorGrupo;

import javax.swing.*;
import java.awt.*;

public class VistaGrupo extends JFrame {

    private JTextField txtIdMateria;
    private JTextField txtIdDocente;
    private JTextField txtAula;
    private JTextField txtHorario;

    private JButton btnGuardar;

    private ControladorGrupo controlador;

    public VistaGrupo() {

        controlador = new ControladorGrupo();

        setTitle("Registro Grupo");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("ID Materia:"));
        txtIdMateria = new JTextField();
        panel.add(txtIdMateria);

        panel.add(new JLabel("ID Docente:"));
        txtIdDocente = new JTextField();
        panel.add(txtIdDocente);

        panel.add(new JLabel("Aula:"));
        txtAula = new JTextField();
        panel.add(txtAula);

        panel.add(new JLabel("Horario:"));
        txtHorario = new JTextField();
        panel.add(txtHorario);

        btnGuardar = new JButton("Guardar");
        panel.add(btnGuardar);
        panel.add(new JLabel());

        add(panel);

        btnGuardar.addActionListener(e -> guardarGrupo());
    }

    private void guardarGrupo() {

        int idMateria = Integer.parseInt(
                txtIdMateria.getText()
        );

        int idDocente = Integer.parseInt(
                txtIdDocente.getText()
        );

        String aula = txtAula.getText();

        String horario = txtHorario.getText();

        boolean guardado = controlador.guardarGrupo(
                idMateria,
                idDocente,
                aula,
                horario
        );

        if (guardado) {

            JOptionPane.showMessageDialog(this,
                    "Grupo guardado correctamente");

        } else {

            JOptionPane.showMessageDialog(this,
                    "Error al guardar grupo");
        }
    }
}