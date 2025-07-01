package org.example.datos;

import org.example.conexion.Conexion;
import org.example.dominio.Carrera;
import org.example.dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class EstudianteDAO implements  IEstudianteDAO{

    @Override
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        var sql = "SELECT e.id_estudiante,e.nombre,e.apellido,e.edad,c.nombre as 'nombre_carrera' FROM estudiante as e INNER JOIN carrera as c on e.id_carrera = c.id_carrera ORDER BY id_estudiante";
        try {
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()){
                var estudiante = new Estudiante();

                estudiante.setId_estudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setEdad(rs.getInt("edad"));
                estudiante.setCarrera(rs.getString("nombre_carrera"));
                estudiantes.add(estudiante);

            }
        } catch (Exception e) {
            System.out.println("Error al listar clientes"+ e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e ){
                System.out.println("Error al cerrar conexion");
            }
        }
        return estudiantes;
    }

    @Override
    public boolean buscarEstudiantePorId(Estudiante estudiante) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        var sql = "SELECT es.id_estudiante, es.nombre, es.apellido, es.edad, ca.nombre as 'nombre_carrera' FROM estudiante as es INNER JOIN carrera as ca ON es.id_carrera = ca.id_carrera WHERE id_estudiante = ?";

        try {
            ps= con.prepareStatement(sql);
            ps.setInt(1,estudiante.getId_estudiante());
            rs = ps.executeQuery();
            if (rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setEdad(rs.getInt("edad"));
                estudiante.setCarrera(rs.getString("nombre_carrera"));
                return true;
            }
        }catch (Exception e){
            System.out.println("No se pudo  buscar  el estudiante "+ e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion"+ e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        String sql = "INSERT INTO estudiante(nombre, id_carrera, edad, apellido) VALUES(?,?,?,?)";
        try {
           ps = con.prepareStatement(sql);
            ps.setString(1,estudiante.getNombre());
            ps.setInt(2,estudiante.getIdCarrera());
            ps.setInt(3,estudiante.getEdad());
            ps.setString(4,estudiante.getApellido());


            ps.executeUpdate();
            return true;

        }catch (Exception e){
            System.out.println("Error al agregar estudiante"+e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion"+ e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        var sql = "UPDATE  estudiante  SEt apellido=?, id_carrera=?, edad=?, nombre=? WHERE id_estudiante=?";
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1,estudiante.getApellido());
            ps.setInt(2,estudiante.getIdCarrera());
            ps.setInt(3,estudiante.getEdad());
            ps.setString(4,estudiante.getNombre());
            ps.setInt(5,estudiante.getId_estudiante());
            ps.executeUpdate();
            return true;


        }catch (Exception e){
            System.out.println("Error al tratar de insertar datos"+ e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("error al cerrar conexion.");
            }

        }

        return false;
    }

    @Override
    public boolean eliminarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        String sql = "DELETE FROM estudiante WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,estudiante.getId_estudiante());
            ps.executeUpdate();

            return true;
        }catch (Exception e){
            System.out.println("Error al eliminar estudiante"+ e.getMessage());
        }

        finally {
            try {
                con.close();
            }catch (Exception e ){
                System.out.println("Error al cerrar la conexion");
            }

        }

        return false;
    }

    public static void main(String[] args) {
        //listar clientes
       /* System.out.println("Listar clientes");
        var estudianteDAO = new EstudianteDAO();
        var lista = estudianteDAO.listarEstudiantes();
        lista.forEach(System.out::println);
       */ /*
        var estudianteDAO = new EstudianteDAO();
        var estudiante = new Estudiante(1);
        System.out.println("estudinte antes de la busqueda "+ estudiante);
        var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
        if (encontrado){
            System.out.println("CLiente encontrado: "+estudiante);

        }else {
            System.out.println("No se encontro el  estudiante "+estudiante.getId_estudiante());
        }*/
        //Agregar estudiante
       /* var estudianteDAO = new EstudianteDAO();
        var nuevoEstudiante = new Estudiante("Martinez",2,26,"William");
        var agregar = estudianteDAO.agregarEstudiante(nuevoEstudiante);
        if (agregar){
            System.out.println("Estudiante agregado con exito");
        }else {
            System.out.println("Error al agregar el estuadiante");
        }*/
        //modificar cliente
//        var modificarEstudiante = new Estudiante(2,"Flores",27,1,"Esteban");
//        var modificadorDAO = new EstudianteDAO().modificarEstudiante(modificarEstudiante);
//        if (modificadorDAO){
//            System.out.println("el estudiante se modifico con exito");
//        } else{
//            System.out.println("Error al modificar cliente");
//        }
        //eliminar cliente
        var estudiante = new Estudiante(1);
        var eliminarEstudiante = new EstudianteDAO().eliminarEstudiante(estudiante);
        if (eliminarEstudiante){
            System.out.println("El estudiante se elimino con exito");
        } else {
            System.out.println("No se pudo eliminar el estudiante");

        }



    }
}
