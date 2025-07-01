package org.example.dominio;

import java.util.Objects;

public class Carrera {
    private  int id_carrera;
    private  String nombre;

    public Carrera() {
    }

    public Carrera(int id_carrera, String nombre) {
        this.id_carrera = id_carrera;
        this.nombre = nombre;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id_carrera=" + id_carrera +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return id_carrera == carrera.id_carrera && Objects.equals(nombre, carrera.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_carrera, nombre);
    }
}

