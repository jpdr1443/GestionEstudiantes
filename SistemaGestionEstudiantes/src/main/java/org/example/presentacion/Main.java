package org.example.presentacion;

import org.example.datos.EstudianteDAO;
import org.example.datos.IEstudianteDAO;
import org.example.dominio.Estudiante;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Gestion de estudiantes");
        gestionEstudiantes();
    }

    private  static void gestionEstudiantes(){
        var salir = false;
        var consola = new Scanner(System.in);
        //Creamos un objecto de la clase estudianteDAO
        IEstudianteDAO estudianteDAO = new EstudianteDAO();
        while (!salir){
            try {
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(consola,opcion,estudianteDAO);

            }catch (Exception e){
                System.out.println("Error al ejecutar opciones: "+e.getMessage());
            }
            System.out.println();
        }
    }
    private  static int mostrarMenu(Scanner consola){
        System.out.print("""
                ***Gestion estudiantes**
                 1.Listar estudiantes
                 2.Buscar estudiante
                 3.Agregar Estudiante
                 4.Modificar Estudiante
                 5.Eliminar Estudiante
                 6.Salir
                 Elige una opcion: \s""");
        return Integer.parseInt(consola.nextLine());

    }
    private  static  boolean ejecutarOpciones(Scanner consola,int opcion,IEstudianteDAO estudianteDAO){
        var salir = false;
        switch (opcion){
            case 1 -> {
                System.out.println("--Listado de Estudiantes--");
                var estudiantes = estudianteDAO.listarEstudiantes();
                estudiantes.forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("--Buscar estudiante por id--");
                System.out.println("Ingrese el Id que desea buscar:");
                var idCliente = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idCliente);
                var buscarEstudiante = estudianteDAO.buscarEstudiantePorId(estudiante);
                if (buscarEstudiante){
                    System.out.println("El estudiante se encontro  "+ estudiante);
                }else {
                    System.out.println("No se encontro estudiante con este ID");
                }
            }
            case 3 ->{
                System.out.println("Ingresar un estudiante nuevo");
                System.out.println("Ingrese el numero del estudiante");
                var nombre = consola.nextLine();
                System.out.println("Ingrese el apellido");
                var apellido = consola.nextLine();
                System.out.println("Ingrese la edad");
                var edad = Integer.parseInt(consola.nextLine());
                System.out.println("Ingrese la carrera del estudiante");
                System.out.println("""
                        1. ciencias politicas
                        2. Fisica
                        3. Quimica
                        4. Ingenieria quimica
                        5. Ingenieria financiera""");
                var carrera = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(apellido,carrera,edad,nombre);
                var agregarEstdudiante = estudianteDAO.agregarEstudiante(estudiante);
                if (agregarEstdudiante){
                    System.out.println("El estudiante se agrego con exito "+ estudiante);
                }else {
                    System.out.println("no se pudo agregar un estudiante.");
                }

            }
            case 4 ->{
                System.out.println("Modificar estudiante");
                System.out.println("Ingrese el id del estudiante que desea modificar");
                var id = Integer.parseInt(consola.nextLine());
                System.out.println("Ingrese el nombre");
                var nombre = consola.nextLine();
                System.out.println("Ingrese el apellido");
                var apellido = consola.nextLine();
                System.out.println("Ingrese la edad");
                var edad = Integer.parseInt(consola.nextLine());
                System.out.println("Ingrese la carrera: ");
                System.out.println("""
                        1. ciencias politicas
                        2. Fisica
                        3. Quimica
                        4. Ingenieria quimica
                        5. Ingenieria financiera""");
                var carrera = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(id, apellido, carrera, edad, nombre);
                var actualizarEstudiante = estudianteDAO.modificarEstudiante(estudiante);
                if (actualizarEstudiante){
                    System.out.println("El estudiante fue actualizado:   "+ estudiante);
                }else {
                    System.out.println("No se pudo actualizar el estudiante "+estudiante);
                }



            }
            case 5 -> {
                System.out.println("Eliminar un estudiante: ");
                System.out.println("Ingrese el id del estudiante que se busca eliminar");
                var id = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(id);
                var eliminarEstudiante = estudianteDAO.eliminarEstudiante(estudiante);
                if (eliminarEstudiante){
                    System.out.println("Se elimino el estudiante exitosamente");
                }else {
                    System.out.println("No se pudo eliminar el estudiante.");
                }

            }
            case 6 -> {
                System.out.println("Hasta pronto");
                    salir = true;
            }

        }


        return salir;
    }
}