package com.uniajc.vista;

import com.uniajc.controlador.ControladorMateria;
import com.uniajc.modelo.Materia;

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

public class VistaMateriaSwing extends JFrame {

    private JTextField txtNombreMateria;
    private JTextField txtCreditos;

    private JButton btnGuardar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnLimpiar;
    private JButton btnAtras;

    private JTable tabla;
    private DefaultTableModel modelo;

    private List<Materia> materias;
    private Materia materiaSeleccionada;

    private ControladorMateria controlador;

    public VistaMateriaSwing() {

        controlador = new ControladorMateria();

        setTitle("Módulo Materias");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 245));

        JLabel titulo = new JLabel("GESTIÓN MATERIAS");
        titulo.setBounds(240, 20, 400, 40);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));

        JLabel lblNombre = new JLabel("Nombre materia:");
        lblNombre.setBounds(40, 100, 140, 25);

        txtNombreMateria = new JTextField();
        txtNombreMateria.setBounds(190, 100, 260, 30);

        JLabel lblCreditos = new JLabel("Créditos:");
        lblCreditos.setBounds(40, 160, 140, 25);

        txtCreditos = new JTextField();
        txtCreditos.setBounds(190, 160, 260, 30);

        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(40, 250, 120, 40);

        btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.setBounds(180, 250, 120, 40);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(320, 250, 120, 40);

        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(460, 250, 120, 40);

        btnAtras = new JButton("ATRÁS");
        btnAtras.setBounds(600, 250, 120, 40);

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
                "Nombre Materia",
                "Créditos"
        };

        modelo = new DefaultTableModel(columnas, 0);

        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 340, 720, 170);

        btnGuardar.addActionListener(e -> guardarMateria());

        btnActualizar.addActionListener(e -> actualizarMateria());

        btnEliminar.addActionListener(e -> eliminarMateria());

        btnLimpiar.addActionListener(e -> limpiarCampos());

        tabla.getSelectionModel().addListSelectionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila >= 0) {

                materiaSeleccionada = materias.get(fila);

                txtNombreMateria.setText(
                        materiaSeleccionada.getNombreMateria()
                );

                txtCreditos.setText(
                        String.valueOf(
                                materiaSeleccionada.getCreditos()
                        )
                );
            }
        });

        btnAtras.addActionListener(e -> {

            VistaPrincipalSwing vista = new VistaPrincipalSwing();
            vista.setVisible(true);

            dispose();
        });

        panel.add(titulo);

        panel.add(lblNombre);
        panel.add(txtNombreMateria);

        panel.add(lblCreditos);
        panel.add(txtCreditos);

        panel.add(btnGuardar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnLimpiar);
        panel.add(btnAtras);

        panel.add(scroll);

        add(panel);

        cargarMaterias();
    }

    private void guardarMateria() {

        boolean guardado = controlador.guardarMateria(
                txtNombreMateria.getText(),
                Integer.parseInt(txtCreditos.getText())
        );

        if (guardado) {

            cargarMaterias();

            limpiarCampos();

            JOptionPane.showMessageDialog(this,
                    "Materia guardada correctamente");

        } else {

            JOptionPane.showMessageDialog(this,
                    "Error al guardar materia");
        }
    }

    private void actualizarMateria() {

        if (materiaSeleccionada != null) {

            materiaSeleccionada.setNombreMateria(
                    txtNombreMateria.getText()
            );

            materiaSeleccionada.setCreditos(
                    Integer.parseInt(txtCreditos.getText())
            );

            boolean actualizado = controlador.actualizarMateria(
                    materiaSeleccionada
            );

            if (actualizado) {

                cargarMaterias();

                JOptionPane.showMessageDialog(this,
                        "Materia actualizada");
            }
        }
    }

    private void eliminarMateria() {

        if (materiaSeleccionada != null) {

            boolean eliminado = controlador.eliminarMateria(
                    materiaSeleccionada.getIdMateria()
            );

            if (eliminado) {

                cargarMaterias();

                limpiarCampos();

                JOptionPane.showMessageDialog(this,
                        "Materia eliminada");
            }
        }
    }

    private void cargarMaterias() {

        modelo.setRowCount(0);

        materias = controlador.listarMaterias();

        for (Materia materia : materias) {

            modelo.addRow(new Object[]{
                    materia.getNombreMateria(),
                    materia.getCreditos()
            });
        }
    }

    private void limpiarCampos() {

        materiaSeleccionada = null;

        txtNombreMateria.setText("");
        txtCreditos.setText("");
    }
}