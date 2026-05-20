package com.uniajc.vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginSwing extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnIngresar;

    public LoginSwing() {

        setTitle("Login Académico");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel lblTitulo = new JLabel("Sistema Académico");
        lblTitulo.setBounds(80, 20, 300, 40);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(50, 90, 100, 25);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(150, 90, 180, 30);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(50, 140, 100, 25);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 140, 180, 30);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(130, 200, 120, 35);

        // COLOR MORADO
        btnIngresar.setBackground(new Color(111, 66, 193));
        btnIngresar.setForeground(Color.WHITE);

        btnIngresar.addActionListener(e -> validarLogin());

        panel.add(lblTitulo);
        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnIngresar);

        add(panel);
    }

    private void validarLogin() {

        String usuario = txtUsuario.getText();
        String password = new String(txtPassword.getPassword());

        if(usuario.equals("admin") && password.equals("123")) {

            JOptionPane.showMessageDialog(this,
                    "Bienvenido al sistema");

            VistaPrincipalSwing vista = new VistaPrincipalSwing();
            vista.setVisible(true);

            dispose();

        } else {

            JOptionPane.showMessageDialog(this,
                    "Usuario o contraseña incorrectos");
        }
    }
}