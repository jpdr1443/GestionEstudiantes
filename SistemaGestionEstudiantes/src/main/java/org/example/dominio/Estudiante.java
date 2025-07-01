package org.example.dominio;

import java.util.Objects;

public class Estudiante {
    private  int id_estudiante;
    private  String nombre;
    private  String apellido;
    private  int edad;
    private  int id_carrera;
    private  String carrera;

    public Estudiante() {
    }

    public Estudiante(String apellido, int id_carrera, int edad, String nombre) {
        this.apellido = apellido;
        this.id_carrera = id_carrera;
        this.edad = edad;
        this.nombre = nombre;
    }
    //contructor para Mostrar estudiante con su carrera asignada por el nombre de la carrera.
    public Estudiante(int id_estudiante,String apellido, String carrera, int edad, String nombre){
        this.apellido = apellido;
        this.edad = edad;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public Estudiante(int id_estudiante,String apellido, int id_carrera, int edad, String nombre) {
        this(apellido,id_carrera,edad,nombre);
        this.id_estudiante = id_estudiante;
    }

    public Estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdCarrera() {
        return id_carrera;
    }

    public void setIdCarrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "apellido='" + apellido + '\'' +
                ", id_estudiante=" + id_estudiante +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", carrera=" + carrera +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return id_estudiante == that.id_estudiante && edad == that.edad && carrera == that.carrera && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_estudiante, nombre, apellido, edad, carrera);
    }
}
