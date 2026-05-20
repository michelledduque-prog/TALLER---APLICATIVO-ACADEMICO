package com.uniajc.vista;

import com.uniajc.controlador.ControladorMateria;

import javax.swing.*;
import java.awt.*;

public class VistaMateria extends JFrame {

    private JTextField txtNombreMateria;
    private JTextField txtCreditos;

    private JButton btnGuardar;

    private ControladorMateria controlador;

    public VistaMateria() {

        controlador = new ControladorMateria();

        setTitle("Registro Materia");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Nombre materia:"));
        txtNombreMateria = new JTextField();
        panel.add(txtNombreMateria);

        panel.add(new JLabel("Créditos:"));
        txtCreditos = new JTextField();
        panel.add(txtCreditos);

        btnGuardar = new JButton("Guardar");
        panel.add(btnGuardar);
        panel.add(new JLabel());

        add(panel);

        btnGuardar.addActionListener(e -> guardarMateria());
    }

    private void guardarMateria() {

        String nombreMateria = txtNombreMateria.getText();

        int creditos = Integer.parseInt(
                txtCreditos.getText()
        );

        boolean guardado = controlador.guardarMateria(
                nombreMateria,
                creditos
        );

        if (guardado) {

            JOptionPane.showMessageDialog(this,
                    "Materia guardada correctamente");

        } else {

            JOptionPane.showMessageDialog(this,
                    "Error al guardar materia");
        }
    }
}