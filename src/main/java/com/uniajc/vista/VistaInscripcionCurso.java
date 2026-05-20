package com.uniajc.vista;

import com.uniajc.controlador.ControladorInscripcionCurso;

import javax.swing.*;
import java.awt.*;

public class VistaInscripcionCurso extends JFrame {

    private JTextField txtIdEstudiante;
    private JTextField txtIdGrupo;
    private JTextField txtNotaFinal;
    private JTextField txtEstado;

    private JButton btnGuardar;

    private ControladorInscripcionCurso controlador;

    public VistaInscripcionCurso() {

        controlador = new ControladorInscripcionCurso();

        setTitle("Inscripción Curso");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("ID Estudiante:"));
        txtIdEstudiante = new JTextField();
        panel.add(txtIdEstudiante);

        panel.add(new JLabel("ID Grupo:"));
        txtIdGrupo = new JTextField();
        panel.add(txtIdGrupo);

        panel.add(new JLabel("Nota Final:"));
        txtNotaFinal = new JTextField();
        panel.add(txtNotaFinal);

        panel.add(new JLabel("Estado:"));
        txtEstado = new JTextField();
        panel.add(txtEstado);

        btnGuardar = new JButton("Guardar");
        panel.add(btnGuardar);
        panel.add(new JLabel());

        add(panel);

        btnGuardar.addActionListener(e -> guardarInscripcion());
    }

    private void guardarInscripcion() {

        int idEstudiante = Integer.parseInt(
                txtIdEstudiante.getText()
        );

        int idGrupo = Integer.parseInt(
                txtIdGrupo.getText()
        );

        double notaFinal = Double.parseDouble(
                txtNotaFinal.getText()
        );

        String estado = txtEstado.getText();

        boolean guardado = controlador.guardarInscripcion(
                idEstudiante,
                idGrupo,
                notaFinal,
                estado
        );

        if (guardado) {

            JOptionPane.showMessageDialog(this,
                    "Inscripción guardada correctamente");

        } else {

            JOptionPane.showMessageDialog(this,
                    "Error al guardar inscripción");
        }
    }
}