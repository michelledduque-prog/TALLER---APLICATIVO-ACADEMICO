package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Materia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MateriaDao {

    public boolean guardar(Materia materia) {

        String sql = "INSERT INTO materia " +
                "(nombre_materia, creditos) " +
                "VALUES (?, ?)";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, materia.getNombreMateria());
            ps.setInt(2, materia.getCreditos());

            ps.executeUpdate();

            System.out.println("✅ Materia guardada correctamente");

            return true;

        } catch (Exception e) {

            System.out.println("❌ Error al guardar materia: " + e.getMessage());

            return false;
        }
    }

    public List<Materia> listar() {

        List<Materia> lista = new ArrayList<>();

        String sql = "SELECT * FROM materia";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Materia materia = new Materia();

                materia.setIdMateria(
                        rs.getInt("id_materia")
                );

                materia.setNombreMateria(
                        rs.getString("nombre_materia")
                );

                materia.setCreditos(
                        rs.getInt("creditos")
                );

                lista.add(materia);
            }

        } catch (Exception e) {

            System.out.println("❌ Error listando materias: " + e.getMessage());
        }

        return lista;
    }

    public boolean eliminar(int idMateria) {

        String sql = "DELETE FROM materia WHERE id_materia = ?";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, idMateria);

            ps.executeUpdate();

            System.out.println("✅ Materia eliminada");

            return true;

        } catch (Exception e) {

            System.out.println("❌ Error eliminando materia: " + e.getMessage());

            return false;
        }
    }

    public boolean actualizar(Materia materia) {

        String sql = "UPDATE materia SET " +
                "nombre_materia=?, creditos=? " +
                "WHERE id_materia=?";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, materia.getNombreMateria());

            ps.setInt(2, materia.getCreditos());

            ps.setInt(3, materia.getIdMateria());

            ps.executeUpdate();

            System.out.println("✅ Materia actualizada");

            return true;

        } catch (Exception e) {

            System.out.println("❌ Error actualizando materia: " + e.getMessage());

            return false;
        }
    }
}