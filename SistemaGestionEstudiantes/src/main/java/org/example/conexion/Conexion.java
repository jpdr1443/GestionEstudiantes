package org.example.conexion;

import javax.sound.midi.MidiFileFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLOutput;

public class Conexion {
    public  static Connection getConexion(){
        Connection conexcion = null;
        var baseDatos = "estudiantes_db";
        var url = "jdbc:mysql://localhost:3308/"+baseDatos;
        var user = "root";
        var password = "";

        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexcion = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            System.out.println("Error al conectarse en la base de datos" + e.getMessage());
        }


    return conexcion;
    }

    public static void main(String[] args) {
        var conexion =  Conexion.getConexion();
        if (conexion != null){
            System.out.println("Conexion exitosa");
        } else {
            System.out.println("La conexion fallo");
        }
    }
}
