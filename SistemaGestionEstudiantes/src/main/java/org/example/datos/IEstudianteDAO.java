package org.example.datos;

import org.example.dominio.Estudiante;

import java.util.List;

public interface IEstudianteDAO {
List<Estudiante> listarEstudiantes();
boolean buscarEstudiantePorId(Estudiante estudiante);
boolean agregarEstudiante(Estudiante estudiante);
boolean modificarEstudiante(Estudiante estudiante);
boolean eliminarEstudiante(Estudiante estudiante);

}

