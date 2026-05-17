package com.uniajc.vista;

import com.uniajc.controlador.ControladorDocente;

import javax.swing.*;
import java.awt.*;

public class VistaDocente extends JFrame {

    private JTextField txtNombreCompleto;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JTextField txtEspecialidad;
    private JTextField txtMateriasAsignadas;

    private JButton btnGuardar;

    private ControladorDocente controlador;

    public VistaDocente() {

        controlador = new ControladorDocente();

        setTitle("Registro Docente");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        panel.add(new JLabel("Nombre completo:"));
        txtNombreCompleto = new JTextField();
        panel.add(txtNombreCompleto);

        panel.add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        panel.add(txtCorreo);

        panel.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panel.add(txtTelefono);

        panel.add(new JLabel("Especialidad:"));
        txtEspecialidad = new JTextField();
        panel.add(txtEspecialidad);

        panel.add(new JLabel("Materias asignadas:"));
        txtMateriasAsignadas = new JTextField();
        panel.add(txtMateriasAsignadas);

        btnGuardar = new JButton("Guardar");
        panel.add(btnGuardar);
        panel.add(new JLabel());

        add(panel);

    

        btnGuardar.addActionListener(e -> guardarDocente());
    }

 

    private void guardarDocente() {

        String nombreCompleto = txtNombreCompleto.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        String especialidad = txtEspecialidad.getText();
        String materiasAsignadas = txtMateriasAsignadas.getText();

        boolean guardado = controlador.guardarDocente(
                nombreCompleto,
                correo,
                telefono,
                especialidad,
                materiasAsignadas
        );

        if (guardado) {

            JOptionPane.showMessageDialog(this,
                    "Docente guardado correctamente");

        } else {

            JOptionPane.showMessageDialog(this,
                    "Error al guardar docente");
        }
    }
}




