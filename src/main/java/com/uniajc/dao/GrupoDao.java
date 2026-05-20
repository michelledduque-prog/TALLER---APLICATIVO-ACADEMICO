package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Grupo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GrupoDao {

    public boolean guardar(Grupo grupo) {

        String sql = "INSERT INTO grupo " +
                "(id_materia, id_docente, aula, horario) " +
                "VALUES (?, ?, ?, ?)";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, grupo.getIdMateria());
            ps.setInt(2, grupo.getIdDocente());
            ps.setString(3, grupo.getAula());
            ps.setString(4, grupo.getHorario());

            ps.executeUpdate();

            System.out.println("✅ Grupo guardado correctamente");

            return true;

        } catch (Exception e) {

            System.out.println("❌ Error al guardar grupo: " + e.getMessage());

            return false;
        }
    }

    public List<Grupo> listar() {

        List<Grupo> lista = new ArrayList<>();

        String sql = "SELECT * FROM grupo";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Grupo grupo = new Grupo();

                grupo.setIdGrupo(
                        rs.getInt("id_grupo")
                );

                grupo.setIdMateria(
                        rs.getInt("id_materia")
                );

                grupo.setIdDocente(
                        rs.getInt("id_docente")
                );

                grupo.setAula(
                        rs.getString("aula")
                );

                grupo.setHorario(
                        rs.getString("horario")
                );

                lista.add(grupo);
            }

        } catch (Exception e) {

            System.out.println("❌ Error listando grupos: " + e.getMessage());
        }

        return lista;
    }

    public boolean eliminar(int idGrupo) {

        String sql = "DELETE FROM grupo WHERE id_grupo = ?";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, idGrupo);

            ps.executeUpdate();

            System.out.println("✅ Grupo eliminado");

            return true;

        } catch (Exception e) {

            System.out.println("❌ Error eliminando grupo: " + e.getMessage());

            return false;
        }
    }

    public boolean actualizar(Grupo grupo) {

        String sql = "UPDATE grupo SET " +
                "id_materia=?, id_docente=?, aula=?, horario=? " +
                "WHERE id_grupo=?";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, grupo.getIdMateria());

            ps.setInt(2, grupo.getIdDocente());

            ps.setString(3, grupo.getAula());

            ps.setString(4, grupo.getHorario());

            ps.setInt(5, grupo.getIdGrupo());

            ps.executeUpdate();

            System.out.println("✅ Grupo actualizado");

            return true;

        } catch (Exception e) {

            System.out.println("❌ Error actualizando grupo: " + e.getMessage());

            return false;
        }
    }
}
