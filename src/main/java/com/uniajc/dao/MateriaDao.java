package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Materia;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MateriaDao {

    public void guardar(Materia m) {
        String sql = "INSERT INTO materia(nombre_materia, creditos) VALUES (?, ?)";

        try (Connection con = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getNombre_materia());
            ps.setInt(2, m.getCreditos());

            ps.executeUpdate();
            System.out.println("Materia guardada correctamente");

        } catch (Exception e) {
            System.out.println("Error Materia DAO: " + e.getMessage());
        }
    }
}