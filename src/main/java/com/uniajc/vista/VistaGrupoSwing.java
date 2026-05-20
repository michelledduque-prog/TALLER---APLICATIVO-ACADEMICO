package com.uniajc.vista;

import com.uniajc.controlador.ControladorGrupo;
import com.uniajc.modelo.Grupo;

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

public class VistaGrupoSwing extends JFrame {

    private JTextField txtIdMateria;
    private JTextField txtIdDocente;
    private JTextField txtAula;
    private JTextField txtHorario;

    private JButton btnGuardar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnLimpiar;
    private JButton btnAtras;

    private JTable tabla;
    private DefaultTableModel modelo;

    private List<Grupo> grupos;
    private Grupo grupoSeleccionado;

    private ControladorGrupo controlador;

    public VistaGrupoSwing() {

        controlador = new ControladorGrupo();

        setTitle("Módulo Grupos");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 245));

        JLabel titulo = new JLabel("GESTIÓN GRUPOS");
        titulo.setBounds(240, 20, 400, 40);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));

        JLabel lblMateria = new JLabel("ID Materia:");
        lblMateria.setBounds(40, 90, 120, 25);

        txtIdMateria = new JTextField();
        txtIdMateria.setBounds(190, 90, 260, 30);

        JLabel lblDocente = new JLabel("ID Docente:");
        lblDocente.setBounds(40, 150, 120, 25);

        txtIdDocente = new JTextField();
        txtIdDocente.setBounds(190, 150, 260, 30);

        JLabel lblAula = new JLabel("Aula:");
        lblAula.setBounds(40, 210, 120, 25);

        txtAula = new JTextField();
        txtAula.setBounds(190, 210, 260, 30);

        JLabel lblHorario = new JLabel("Horario:");
        lblHorario.setBounds(40, 270, 120, 25);

        txtHorario = new JTextField();
        txtHorario.setBounds(190, 270, 260, 30);

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
                "ID Materia",
                "ID Docente",
                "Aula",
                "Horario"
        };

        modelo = new DefaultTableModel(columnas, 0);

        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 420, 720, 120);

        btnGuardar.addActionListener(e -> guardarGrupo());

        btnActualizar.addActionListener(e -> actualizarGrupo());

        btnEliminar.addActionListener(e -> eliminarGrupo());

        btnLimpiar.addActionListener(e -> limpiarCampos());

        tabla.getSelectionModel().addListSelectionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila >= 0) {

                grupoSeleccionado = grupos.get(fila);

                txtIdMateria.setText(
                        String.valueOf(grupoSeleccionado.getIdMateria())
                );

                txtIdDocente.setText(
                        String.valueOf(grupoSeleccionado.getIdDocente())
                );

                txtAula.setText(
                        grupoSeleccionado.getAula()
                );

                txtHorario.setText(
                        grupoSeleccionado.getHorario()
                );
            }
        });

        btnAtras.addActionListener(e -> {

            VistaPrincipalSwing vista = new VistaPrincipalSwing();
            vista.setVisible(true);

            dispose();
        });

        panel.add(titulo);

        panel.add(lblMateria);
        panel.add(txtIdMateria);

        panel.add(lblDocente);
        panel.add(txtIdDocente);

        panel.add(lblAula);
        panel.add(txtAula);

        panel.add(lblHorario);
        panel.add(txtHorario);

        panel.add(btnGuardar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnLimpiar);
        panel.add(btnAtras);

        panel.add(scroll);

        add(panel);

        cargarGrupos();
    }

    private void guardarGrupo() {

        boolean guardado = controlador.guardarGrupo(
                Integer.parseInt(txtIdMateria.getText()),
                Integer.parseInt(txtIdDocente.getText()),
                txtAula.getText(),
                txtHorario.getText()
        );

        if (guardado) {

            cargarGrupos();

            limpiarCampos();

            JOptionPane.showMessageDialog(this,
                    "Grupo guardado correctamente");

        } else {

            JOptionPane.showMessageDialog(this,
                    "Error al guardar grupo");
        }
    }

    private void actualizarGrupo() {

        if (grupoSeleccionado != null) {

            grupoSeleccionado.setIdMateria(
                    Integer.parseInt(txtIdMateria.getText())
            );

            grupoSeleccionado.setIdDocente(
                    Integer.parseInt(txtIdDocente.getText())
            );

            grupoSeleccionado.setAula(
                    txtAula.getText()
            );

            grupoSeleccionado.setHorario(
                    txtHorario.getText()
            );

            boolean actualizado = controlador.actualizarGrupo(
                    grupoSeleccionado
            );

            if (actualizado) {

                cargarGrupos();

                JOptionPane.showMessageDialog(this,
                        "Grupo actualizado");
            }
        }
    }

    private void eliminarGrupo() {

        if (grupoSeleccionado != null) {

            boolean eliminado = controlador.eliminarGrupo(
                    grupoSeleccionado.getIdGrupo()
            );

            if (eliminado) {

                cargarGrupos();

                limpiarCampos();

                JOptionPane.showMessageDialog(this,
                        "Grupo eliminado");
            }
        }
    }

    private void cargarGrupos() {

        modelo.setRowCount(0);

        grupos = controlador.listarGrupos();

        for (Grupo grupo : grupos) {

            modelo.addRow(new Object[]{
                    grupo.getIdMateria(),
                    grupo.getIdDocente(),
                    grupo.getAula(),
                    grupo.getHorario()
            });
        }
    }

    private void limpiarCampos() {

        grupoSeleccionado = null;

        txtIdMateria.setText("");
        txtIdDocente.setText("");
        txtAula.setText("");
        txtHorario.setText("");
    }
}