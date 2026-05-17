package com.uniajc.vista;

import com.uniajc.controlador.ControladorDocente;
import com.uniajc.modelo.Docente;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VistaDocenteSwing extends JFrame {

    private JTextField txtNombreCompleto;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JTextField txtEspecialidad;
    private JTextField txtMateriasAsignadas;

    private JButton btnGuardar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnLimpiar;
    private JButton btnAtras;

    private JTable tabla;
    private DefaultTableModel modelo;

    private java.util.List<Docente> docentes;
    private Docente docenteSeleccionado;

    private ControladorDocente controlador;

    public VistaDocenteSwing() {

        controlador = new ControladorDocente();

        setTitle("Módulo Docentes");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 245));

        JLabel titulo = new JLabel("GESTIÓN DOCENTES");
        titulo.setBounds(240, 20, 400, 40);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titulo.setForeground(new Color(50, 50, 50));

        JLabel lblNombre = new JLabel("Nombre completo:");
        lblNombre.setBounds(40, 90, 130, 25);

        txtNombreCompleto = new JTextField();
        txtNombreCompleto.setBounds(190, 90, 260, 30);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(40, 140, 130, 25);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(190, 140, 260, 30);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(40, 190, 130, 25);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(190, 190, 260, 30);

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(40, 240, 130, 25);

        txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(190, 240, 260, 30);

        JLabel lblMaterias = new JLabel("Materias asignadas:");
        lblMaterias.setBounds(40, 290, 130, 25);

        txtMateriasAsignadas = new JTextField();
        txtMateriasAsignadas.setBounds(190, 290, 260, 30);

        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(40, 350, 120, 40);

        btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.setBounds(180, 350, 120, 40);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(320, 350, 120, 40);

        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(460, 350, 120, 40);

        btnAtras = new JButton("ATRÁS");
        btnAtras.setBounds(600, 350, 120, 40);

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
                "Nombre completo",
                "Correo",
                "Teléfono",
                "Especialidad",
                "Materias asignadas"
        };

        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 420, 720, 120);

        btnGuardar.addActionListener(e -> {
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
                cargarDocentes();
                JOptionPane.showMessageDialog(this, "Docente guardado correctamente");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar docente en la base de datos");
            }
        });

        btnLimpiar.addActionListener(e -> limpiarCampos());

        btnEliminar.addActionListener(e -> {
            if (docenteSeleccionado != null) {
                boolean eliminado = controlador.eliminarDocente(docenteSeleccionado.getIdDocente());
                if (eliminado) {
                    cargarDocentes();
                    limpiarCampos();
                    JOptionPane.showMessageDialog(this, "Docente eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar docente");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un docente para eliminar");
            }
        });

        btnActualizar.addActionListener(e -> {
            if (docenteSeleccionado != null) {
                docenteSeleccionado.setNombreCompleto(txtNombreCompleto.getText());
                docenteSeleccionado.setCorreo(txtCorreo.getText());
                docenteSeleccionado.setTelefono(txtTelefono.getText());
                docenteSeleccionado.setEspecialidad(txtEspecialidad.getText());
                docenteSeleccionado.setMateriasAsignadas(txtMateriasAsignadas.getText());

                boolean actualizado = controlador.actualizarDocente(docenteSeleccionado);
                if (actualizado) {
                    cargarDocentes();
                    JOptionPane.showMessageDialog(this, "Docente actualizado correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar docente");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un docente para actualizar");
            }
        });

        tabla.getSelectionModel().addListSelectionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0 && docentes != null && fila < docentes.size()) {
                docenteSeleccionado = docentes.get(fila);
                txtNombreCompleto.setText(docenteSeleccionado.getNombreCompleto());
                txtCorreo.setText(docenteSeleccionado.getCorreo());
                txtTelefono.setText(docenteSeleccionado.getTelefono());
                txtEspecialidad.setText(docenteSeleccionado.getEspecialidad());
                txtMateriasAsignadas.setText(docenteSeleccionado.getMateriasAsignadas());
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
        panel.add(lblCorreo);
        panel.add(txtCorreo);
        panel.add(lblTelefono);
        panel.add(txtTelefono);
        panel.add(lblEspecialidad);
        panel.add(txtEspecialidad);
        panel.add(lblMaterias);
        panel.add(txtMateriasAsignadas);
        panel.add(btnGuardar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnLimpiar);
        panel.add(btnAtras);
        panel.add(scroll);

        add(panel);

        cargarDocentes();
    }

    private void cargarDocentes() {
        modelo.setRowCount(0);
        docentes = controlador.listarDocentes();
        for (Docente docente : docentes) {
            modelo.addRow(new Object[]{
                    docente.getNombreCompleto(),
                    docente.getCorreo(),
                    docente.getTelefono(),
                    docente.getEspecialidad(),
                    docente.getMateriasAsignadas()
            });
        }
    }

    private void limpiarCampos() {
        docenteSeleccionado = null;
        txtNombreCompleto.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtEspecialidad.setText("");
        txtMateriasAsignadas.setText("");
    }
}
