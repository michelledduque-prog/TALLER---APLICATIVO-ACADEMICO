package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.InscripcionCurso;
import java.sql.*;

public class InscripcionDao {

    public void guardar(InscripcionCurso i) {

        String sql = "INSERT INTO inscripcion(id_estudiante, id_grupo) VALUES (?, ?)";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, i.getId_estudiante());
            ps.setInt(2, i.getId_grupo());

            ps.executeUpdate();

            System.out.println("Inscripción guardada");

        } catch (Exception ex) {

            System.out.println("Error Inscripcion DAO: " + ex.getMessage());
        }
    }
}