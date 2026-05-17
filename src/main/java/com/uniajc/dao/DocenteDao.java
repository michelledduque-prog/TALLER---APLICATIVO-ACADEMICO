package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Docente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DocenteDao {

    public boolean guardar(Docente docente) {

        String sql = "INSERT INTO docente(nombre_completo, correo, telefono, especialidad, materias_asignadas) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, docente.getNombreCompleto());
            ps.setString(2, docente.getCorreo());
            ps.setString(3, docente.getTelefono());
            ps.setString(4, docente.getEspecialidad());
            ps.setString(5, docente.getMateriasAsignadas());

            ps.executeUpdate();

            System.out.println("✅ Docente guardado");
            return true;

        } catch (Exception e) {
            System.out.println("❌ Error guardando docente: " + e.getMessage());
            return false;
        }
    }

    public List<Docente> listar() {
        List<Docente> lista = new ArrayList<>();
        String sql = "SELECT * FROM docente";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Docente docente = new Docente();
                docente.setIdDocente(rs.getInt("id_docente"));
                docente.setNombreCompleto(rs.getString("nombre_completo"));
                docente.setCorreo(rs.getString("correo"));
                docente.setTelefono(rs.getString("telefono"));
                docente.setEspecialidad(rs.getString("especialidad"));
                docente.setMateriasAsignadas(rs.getString("materias_asignadas"));
                lista.add(docente);
            }
        } catch (Exception e) {
            System.out.println("❌ Error listando docentes: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizar(Docente docente) {
        String sql = "UPDATE docente SET nombre_completo=?, correo=?, telefono=?, especialidad=?, materias_asignadas=? WHERE id_docente=?";

        try (Connection con = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, docente.getNombreCompleto());
            ps.setString(2, docente.getCorreo());
            ps.setString(3, docente.getTelefono());
            ps.setString(4, docente.getEspecialidad());
            ps.setString(5, docente.getMateriasAsignadas());
            ps.setInt(6, docente.getIdDocente());

            ps.executeUpdate();
            System.out.println("✅ Docente actualizado");
            return true;

        } catch (Exception e) {
            System.out.println("❌ Error actualizando docente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idDocente) {
        String sql = "DELETE FROM docente WHERE id_docente = ?";

        try (Connection con = ConexionPostgresDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idDocente);
            ps.executeUpdate();
            System.out.println("✅ Docente eliminado");
            return true;

        } catch (Exception e) {
            System.out.println("❌ Error eliminando docente: " + e.getMessage());
            return false;
        }
    }
}