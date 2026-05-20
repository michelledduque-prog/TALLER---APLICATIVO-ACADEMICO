package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDao {

    

    public boolean guardar(Estudiante estudiante) {

        String sql = "INSERT INTO estudiante " +
                "(nombre_completo, documento, carrera, semestre, correo, telefono, direccion) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, estudiante.getNombreCompleto());
            ps.setString(2, estudiante.getDocumento());
            ps.setString(3, estudiante.getCarrera());
            ps.setString(4, estudiante.getSemestre());
            ps.setString(5, estudiante.getCorreo());
            ps.setString(6, estudiante.getTelefono());
            ps.setString(7, estudiante.getDireccion());

            ps.executeUpdate();

            System.out.println("✅ Estudiante guardado correctamente");

            return true;

        } catch (Exception e) {

            System.out.println("❌ Error al guardar estudiante: " + e.getMessage());

            return false;
        }
    }

 

    public List<Estudiante> listar() {

        List<Estudiante> lista = new ArrayList<>();

        String sql = "SELECT * FROM estudiante";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Estudiante estudiante = new Estudiante();

                estudiante.setCodigoEstudiante(
                        rs.getInt("codigo_estudiante")
                );

                estudiante.setNombreCompleto(
                        rs.getString("nombre_completo")
                );

                estudiante.setDocumento(
                        rs.getString("documento")
                );

                estudiante.setCarrera(
                        rs.getString("carrera")
                );

                estudiante.setSemestre(
                        rs.getString("semestre")
                );

                estudiante.setCorreo(
                        rs.getString("correo")
                );

                estudiante.setTelefono(
                        rs.getString("telefono")
                );

                estudiante.setDireccion(
                        rs.getString("direccion")
                );

                lista.add(estudiante);
            }

        } catch (Exception e) {

            System.out.println("❌ Error listando estudiantes: " + e.getMessage());
        }

        return lista;
    }

   

    public boolean eliminar(int codigoEstudiante) {

        String sql = "DELETE FROM estudiante WHERE codigo_estudiante = ?";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, codigoEstudiante);

            ps.executeUpdate();

            System.out.println("✅ Estudiante eliminado");

            return true;

        } catch (Exception e) {

            System.out.println("❌ Error eliminando estudiante: " + e.getMessage());

            return false;
        }
    }

 

    public boolean actualizar(Estudiante estudiante) {

        String sql = "UPDATE estudiante SET " +
                "nombre_completo=?, documento=?, carrera=?, semestre=?, correo=?, telefono=?, direccion=? " +
                "WHERE codigo_estudiante=?";

        try (
                Connection con = ConexionPostgresDatabase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, estudiante.getNombreCompleto());
            ps.setString(2, estudiante.getDocumento());
            ps.setString(3, estudiante.getCarrera());
            ps.setString(4, estudiante.getSemestre());
            ps.setString(5, estudiante.getCorreo());
            ps.setString(6, estudiante.getTelefono());
            ps.setString(7, estudiante.getDireccion());

            ps.setInt(8, estudiante.getCodigoEstudiante());

            ps.executeUpdate();

            System.out.println("✅ Estudiante actualizado");

            return true;

        } catch (Exception e) {

            System.out.println("❌ Error actualizando estudiante: " + e.getMessage());

            return false;
        }
    }
}


