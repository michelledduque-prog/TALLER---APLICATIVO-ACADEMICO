package com.uniajc.vista;

import com.uniajc.controlador.ControladorEstudiante;
import com.uniajc.modelo.Estudiante;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VistaEstudianteSwing extends JFrame {

    private JTextField txtNombreCompleto;
    private JTextField txtDocumento;
    private JTextField txtCarrera;
    private JTextField txtSemestre;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JTextField txtDireccion;

    private JButton btnGuardar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnLimpiar;
    private JButton btnAtras;

    private JTable tabla;
    private DefaultTableModel modelo;

    private List<Estudiante> estudiantes;
    private Estudiante estudianteSeleccionado;

    private ControladorEstudiante controlador;

    public VistaEstudianteSwing() {

        controlador = new ControladorEstudiante();

        setTitle("Módulo Estudiantes");
        setSize(900, 620);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 245));

        JLabel titulo = new JLabel("GESTIÓN ESTUDIANTES");
        titulo.setBounds(40, 20, 380, 40);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titulo.setForeground(new Color(50, 50, 50));

        JLabel lblNombre = new JLabel("Nombre completo:");
        lblNombre.setBounds(40, 90, 140, 25);

        txtNombreCompleto = new JTextField();
        txtNombreCompleto.setBounds(190, 90, 260, 30);

        JLabel lblDocumento = new JLabel("Documento:");
        lblDocumento.setBounds(40, 140, 140, 25);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(190, 140, 260, 30);

        JLabel lblCarrera = new JLabel("Carrera:");
        lblCarrera.setBounds(40, 190, 140, 25);

        txtCarrera = new JTextField();
        txtCarrera.setBounds(190, 190, 260, 30);

        JLabel lblSemestre = new JLabel("Semestre:");
        lblSemestre.setBounds(40, 240, 140, 25);

        txtSemestre = new JTextField();
        txtSemestre.setBounds(190, 240, 260, 30);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(480, 90, 120, 25);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(580, 90, 260, 30);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(480, 140, 120, 25);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(580, 140, 260, 30);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(480, 190, 120, 25);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(580, 190, 260, 30);

        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(40, 290, 130, 40);

        btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.setBounds(190, 290, 130, 40);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(340, 290, 130, 40);

        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(490, 290, 130, 40);

        btnAtras = new JButton("ATRÁS");
        btnAtras.setBounds(640, 290, 130, 40);

        Color morado = new Color(111, 66, 193);
        btnGuardar.setBackground(morado);
        btnGuardar.setForeground(Color.WHITE);
        btnActualizar.setBackground(morado);
        btnActualizar.setForeground(Color.WHITE);
        btnEliminar.setBackground(morado);
        btnEliminar.setForeground(Color.WHITE);
        btnLimpiar.setBackground(morado);
        btnLimpiar.setForeground(Color.WHITE);
        btnAtras.setBackground(Color.DARK_GRAY);
        btnAtras.setForeground(Color.WHITE);

        String[] columnas = {
                "Documento",
                "Nombre completo",
                "Carrera",
                "Semestre",
                "Correo",
                "Teléfono",
                "Dirección"
        };

        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 360, 820, 180);

        btnGuardar.addActionListener(e -> guardarEstudiante());

        btnLimpiar.addActionListener(e -> limpiarCampos());

        btnEliminar.addActionListener(e -> {
            if (estudianteSeleccionado != null) {
                boolean eliminado = controlador.eliminarEstudiante(estudianteSeleccionado.getCodigoEstudiante());
                if (eliminado) {
                    cargarEstudiantes();
                    limpiarCampos();
                    JOptionPane.showMessageDialog(this, "Estudiante eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar estudiante");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un estudiante para eliminar");
            }
        });

        btnActualizar.addActionListener(e -> {
            if (estudianteSeleccionado != null) {
                estudianteSeleccionado.setDocumento(txtDocumento.getText());
                estudianteSeleccionado.setNombreCompleto(txtNombreCompleto.getText());
                estudianteSeleccionado.setCarrera(txtCarrera.getText());
                estudianteSeleccionado.setSemestre(txtSemestre.getText());
                estudianteSeleccionado.setCorreo(txtCorreo.getText());
                estudianteSeleccionado.setTelefono(txtTelefono.getText());
                estudianteSeleccionado.setDireccion(txtDireccion.getText());

                boolean actualizado = controlador.actualizarEstudiante(estudianteSeleccionado);
                if (actualizado) {
                    cargarEstudiantes();
                    JOptionPane.showMessageDialog(this, "Estudiante actualizado correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar estudiante");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un estudiante para actualizar");
            }
        });

        tabla.getSelectionModel().addListSelectionListener((ListSelectionListener) e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0 && estudiantes != null && fila < estudiantes.size()) {
                estudianteSeleccionado = estudiantes.get(fila);
                txtDocumento.setText(estudianteSeleccionado.getDocumento());
                txtNombreCompleto.setText(estudianteSeleccionado.getNombreCompleto());
                txtCarrera.setText(estudianteSeleccionado.getCarrera());
                txtSemestre.setText(estudianteSeleccionado.getSemestre());
                txtCorreo.setText(estudianteSeleccionado.getCorreo());
                txtTelefono.setText(estudianteSeleccionado.getTelefono());
                txtDireccion.setText(estudianteSeleccionado.getDireccion());
            }
        });

        btnAtras.addActionListener(e -> {
            VistaPrincipalSwing vista = new VistaPrincipalSwing();
            vista.setVisible(true);
            dispose();
        });

        panel.add(titulo);
        panel.add(lblNombre);
        panel.add(txtNombreCompleto);
        panel.add(lblDocumento);
        panel.add(txtDocumento);
        panel.add(lblCarrera);
        panel.add(txtCarrera);
        panel.add(lblSemestre);
        panel.add(txtSemestre);
        panel.add(lblCorreo);
        panel.add(txtCorreo);
        panel.add(lblTelefono);
        panel.add(txtTelefono);
        panel.add(lblDireccion);
        panel.add(txtDireccion);
        panel.add(btnGuardar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnLimpiar);
        panel.add(btnAtras);
        panel.add(scroll);

        add(panel);

        cargarEstudiantes();
    }

    private void cargarEstudiantes() {
        modelo.setRowCount(0);
        estudiantes = controlador.listarEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            modelo.addRow(new Object[]{
                    estudiante.getDocumento(),
                    estudiante.getNombreCompleto(),
                    estudiante.getCarrera(),
                    estudiante.getSemestre(),
                    estudiante.getCorreo(),
                    estudiante.getTelefono(),
                    estudiante.getDireccion()
            });
        }
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
            cargarEstudiantes();
            JOptionPane.showMessageDialog(this,
                    "Estudiante guardado correctamente");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar estudiante");
        }
    }

    private void limpiarCampos() {
        estudianteSeleccionado = null;
        txtNombreCompleto.setText("");
        txtDocumento.setText("");
        txtCarrera.setText("");
        txtSemestre.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
    }
}


