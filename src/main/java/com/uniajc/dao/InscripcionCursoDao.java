package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.InscripcionCurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InscripcionCursoDao {

    public boolean guardar(InscripcionCurso inscripcion) {

        String sql = "INSERT INTO inscripcion_curso " +
                "(id_estudiante, id_grupo, nota_final, estado) " +
                "VALUES (?, ?, ?, ?)";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, inscripcion.getIdEstudiante());
            ps.setInt(2, inscripcion.getIdGrupo());
            ps.setDouble(3, inscripcion.getNotaFinal());
            ps.setString(4, inscripcion.getEstado());

            ps.executeUpdate();

            System.out.println("✅ Inscripción guardada correctamente");

            return true;

        } catch (Exception e) {

            System.out.println("❌ Error al guardar inscripción: " + e.getMessage());

            return false;
        }
    }

    public List<InscripcionCurso> listar() {

        List<InscripcionCurso> lista = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion_curso";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                InscripcionCurso inscripcion = new InscripcionCurso();

                inscripcion.setIdInscripcion(
                        rs.getInt("id_inscripcion")
                );

                inscripcion.setIdEstudiante(
                        rs.getInt("id_estudiante")
                );

                inscripcion.setIdGrupo(
                        rs.getInt("id_grupo")
                );

                inscripcion.setNotaFinal(
                        rs.getDouble("nota_final")
                );

                inscripcion.setEstado(
                        rs.getString("estado")
                );

                lista.add(inscripcion);
            }

        } catch (Exception e) {

            System.out.println("❌ Error listando inscripciones: " + e.getMessage());
        }

        return lista;
    }

    public boolean eliminar(int idInscripcion) {

        String sql = "DELETE FROM inscripcion_curso WHERE id_inscripcion = ?";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, idInscripcion);

            ps.executeUpdate();

            System.out.println("✅ Inscripción eliminada");

            return true;

        } catch (Exception e) {

            System.out.println("❌ Error eliminando inscripción: " + e.getMessage());

            return false;
        }
    }

    public boolean actualizar(InscripcionCurso inscripcion) {

        String sql = "UPDATE inscripcion_curso SET " +
                "id_estudiante=?, id_grupo=?, nota_final=?, estado=? " +
                "WHERE id_inscripcion=?";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, inscripcion.getIdEstudiante());

            ps.setInt(2, inscripcion.getIdGrupo());

            ps.setDouble(3, inscripcion.getNotaFinal());

            ps.setString(4, inscripcion.getEstado());

            ps.setInt(5, inscripcion.getIdInscripcion());

            ps.executeUpdate();

            System.out.println("✅ Inscripción actualizada");

            return true;

        } catch (Exception e) {

            System.out.println("❌ Error actualizando inscripción: " + e.getMessage());

            return false;
        }
    }
}