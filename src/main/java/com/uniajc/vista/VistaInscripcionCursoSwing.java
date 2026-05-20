package com.uniajc.vista;

import com.uniajc.controlador.ControladorInscripcionCurso;
import com.uniajc.modelo.InscripcionCurso;

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

public class VistaInscripcionCursoSwing extends JFrame {

    private JTextField txtIdEstudiante;
    private JTextField txtIdGrupo;
    private JTextField txtNotaFinal;
    private JTextField txtEstado;

    private JButton btnGuardar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnLimpiar;
    private JButton btnAtras;

    private JTable tabla;
    private DefaultTableModel modelo;

    private List<InscripcionCurso> inscripciones;
    private InscripcionCurso inscripcionSeleccionada;

    private ControladorInscripcionCurso controlador;

    public VistaInscripcionCursoSwing() {

        controlador = new ControladorInscripcionCurso();

        setTitle("Módulo Inscripciones");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 245));

        JLabel titulo = new JLabel("GESTIÓN INSCRIPCIONES");
        titulo.setBounds(180, 20, 450, 40);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));

        JLabel lblEstudiante = new JLabel("ID Estudiante:");
        lblEstudiante.setBounds(40, 90, 130, 25);

        txtIdEstudiante = new JTextField();
        txtIdEstudiante.setBounds(190, 90, 260, 30);

        JLabel lblGrupo = new JLabel("ID Grupo:");
        lblGrupo.setBounds(40, 150, 130, 25);

        txtIdGrupo = new JTextField();
        txtIdGrupo.setBounds(190, 150, 260, 30);

        JLabel lblNota = new JLabel("Nota Final:");
        lblNota.setBounds(40, 210, 130, 25);

        txtNotaFinal = new JTextField();
        txtNotaFinal.setBounds(190, 210, 260, 30);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(40, 270, 130, 25);

        txtEstado = new JTextField();
        txtEstado.setBounds(190, 270, 260, 30);

        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(40, 340, 120, 40);

        btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.setBounds(180, 340, 120, 40);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(320, 340, 120, 40);

        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(460, 340, 120, 40);

        btnAtras = new JButton("ATRÁS");
        btnAtras.setBounds(600, 340, 120, 40);

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
                "ID Estudiante",
                "ID Grupo",
                "Nota Final",
                "Estado"
        };

        modelo = new DefaultTableModel(columnas, 0);

        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 420, 720, 120);

        btnGuardar.addActionListener(e -> guardarInscripcion());

        btnActualizar.addActionListener(e -> actualizarInscripcion());

        btnEliminar.addActionListener(e -> eliminarInscripcion());

        btnLimpiar.addActionListener(e -> limpiarCampos());

        tabla.getSelectionModel().addListSelectionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila >= 0) {

                inscripcionSeleccionada = inscripciones.get(fila);

                txtIdEstudiante.setText(
                        String.valueOf(inscripcionSeleccionada.getIdEstudiante())
                );

                txtIdGrupo.setText(
                        String.valueOf(inscripcionSeleccionada.getIdGrupo())
                );

                txtNotaFinal.setText(
                        String.valueOf(inscripcionSeleccionada.getNotaFinal())
                );

                txtEstado.setText(
                        inscripcionSeleccionada.getEstado()
                );
            }
        });

        btnAtras.addActionListener(e -> {

            VistaPrincipalSwing vista = new VistaPrincipalSwing();
            vista.setVisible(true);

            dispose();
        });

        panel.add(titulo);

        panel.add(lblEstudiante);
        panel.add(txtIdEstudiante);

        panel.add(lblGrupo);
        panel.add(txtIdGrupo);

        panel.add(lblNota);
        panel.add(txtNotaFinal);

        panel.add(lblEstado);
        panel.add(txtEstado);

        panel.add(btnGuardar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnLimpiar);
        panel.add(btnAtras);

        panel.add(scroll);

        add(panel);

        cargarInscripciones();
    }

    private void guardarInscripcion() {

        boolean guardado = controlador.guardarInscripcion(
                Integer.parseInt(txtIdEstudiante.getText()),
                Integer.parseInt(txtIdGrupo.getText()),
                Double.parseDouble(txtNotaFinal.getText()),
                txtEstado.getText()
        );

        if (guardado) {

            cargarInscripciones();

            limpiarCampos();

            JOptionPane.showMessageDialog(this,
                    "Inscripción guardada correctamente");

        } else {

            JOptionPane.showMessageDialog(this,
                    "Error al guardar inscripción");
        }
    }

    private void actualizarInscripcion() {

        if (inscripcionSeleccionada != null) {

            inscripcionSeleccionada.setIdEstudiante(
                    Integer.parseInt(txtIdEstudiante.getText())
            );

            inscripcionSeleccionada.setIdGrupo(
                    Integer.parseInt(txtIdGrupo.getText())
            );

            inscripcionSeleccionada.setNotaFinal(
                    Double.parseDouble(txtNotaFinal.getText())
            );

            inscripcionSeleccionada.setEstado(
                    txtEstado.getText()
            );

            boolean actualizado = controlador.actualizarInscripcion(
                    inscripcionSeleccionada
            );

            if (actualizado) {

                cargarInscripciones();

                JOptionPane.showMessageDialog(this,
                        "Inscripción actualizada");
            }
        }
    }

    private void eliminarInscripcion() {

        if (inscripcionSeleccionada != null) {

            boolean eliminado = controlador.eliminarInscripcion(
                    inscripcionSeleccionada.getIdInscripcion()
            );

            if (eliminado) {

                cargarInscripciones();

                limpiarCampos();

                JOptionPane.showMessageDialog(this,
                        "Inscripción eliminada");
            }
        }
    }

    private void cargarInscripciones() {

        modelo.setRowCount(0);

        inscripciones = controlador.listarInscripciones();

        for (InscripcionCurso inscripcion : inscripciones) {

            modelo.addRow(new Object[]{
                    inscripcion.getIdEstudiante(),
                    inscripcion.getIdGrupo(),
                    inscripcion.getNotaFinal(),
                    inscripcion.getEstado()
            });
        }
    }

    private void limpiarCampos() {

        inscripcionSeleccionada = null;

        txtIdEstudiante.setText("");
        txtIdGrupo.setText("");
        txtNotaFinal.setText("");
        txtEstado.setText("");
    }
}