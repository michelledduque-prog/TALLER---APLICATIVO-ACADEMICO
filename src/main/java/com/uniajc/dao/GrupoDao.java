package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Grupo;
import java.sql.*;

public class GrupoDao {

    public void guardar(Grupo g) {
        String sql = "INSERT INTO grupo(id_materia, id_docente, aula, horario) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, g.getId_materia());
            ps.setInt(2, g.getId_docente());
            ps.setString(3, g.getAula());
            ps.setString(4, g.getHorario());

            ps.executeUpdate();
            System.out.println("Grupo guardado");

        } catch (Exception e) {
            System.out.println("Error Grupo DAO: " + e.getMessage());
        }
    }
}