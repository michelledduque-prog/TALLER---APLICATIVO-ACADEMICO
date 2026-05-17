package com.uniajc.vista;

import com.uniajc.controlador.ControladorEstudiante;

import javax.swing.*;
import java.awt.*;

public class VistaEstudiante extends JFrame {

    private JTextField txtNombreCompleto;
    private JTextField txtDocumento;
    private JTextField txtCarrera;
    private JTextField txtSemestre;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JTextField txtDireccion;

    private JButton btnGuardar;

    private ControladorEstudiante controlador;

    public VistaEstudiante() {

        controlador = new ControladorEstudiante();

        setTitle("Registro Estudiante");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));

        panel.add(new JLabel("Nombre completo:"));
        txtNombreCompleto = new JTextField();
        panel.add(txtNombreCompleto);

        panel.add(new JLabel("Documento:"));
        txtDocumento = new JTextField();
        panel.add(txtDocumento);

        panel.add(new JLabel("Carrera:"));
        txtCarrera = new JTextField();
        panel.add(txtCarrera);

        panel.add(new JLabel("Semestre:"));
        txtSemestre = new JTextField();
        panel.add(txtSemestre);

        panel.add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        panel.add(txtCorreo);

        panel.add(new JLabel("Telefono:"));
        txtTelefono = new JTextField();
        panel.add(txtTelefono);

        panel.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panel.add(txtDireccion);

        btnGuardar = new JButton("Guardar");
        panel.add(btnGuardar);
        panel.add(new JLabel());
 

        btnGuardar.addActionListener(e -> guardarEstudiante());
    }


    private void guardarEstudiante() {

        String nombreCompleto = txtNombreCompleto.getText();
        String documento = txtDocumento.getText();
        String carrera = txtCarrera.getText();
        String semestre = txtSemestre.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();

        boolean guardado = controlador.guardarEstudiante(
                nombreCompleto,
                documento,
                carrera,
                semestre,
                correo,
                telefono,
                direccion
        );

        if (guardado) {

            JOptionPane.showMessageDialog(this,
                    "Estudiante guardado");

            limpiarCampos();

        } else {

            JOptionPane.showMessageDialog(this,
                    "Error al guardar");
        }
    }

   

    private void limpiarCampos() {

        txtNombreCompleto.setText("");
        txtDocumento.setText("");
        txtCarrera.setText("");
        txtSemestre.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
    }
}



