package com.uniajc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPostgresDatabase {

    private static final String URL = "jdbc:postgresql://localhost:5433/universidad";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encontró el driver de PostgreSQL", e);
        }

        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("✅ Conectado a PostgreSQL");
        return con;
    }
}
