/*Ejercicio 3: Sistema de Gestión de Cursos
Objetivo: Implementar un sistema para gestionar cursos y estudiantes, aplicando
abstracción y polimorfismo, y utilizando ArrayList para manejar las inscripciones.

Principios de POO aplicados: Abstracción, Polimorfismo.

Requisitos:

Clase Curso: Con propiedades como código, nombre, y listaEstudiantes, donde
listaEstudiantes es un ArrayList de objetos Estudiante.
Clase Estudiante: Con propiedades como id, nombre, y email.

Clase GestionCursos: Encargada de administrar los cursos, incluyendo métodos para
agregar cursos, inscribir estudiantes en cursos y listar estudiantes inscritos en un curso
específico.*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //instancias
        Scanner objScanner = new Scanner(System.in);
        GestionCurso objGestion = new GestionCurso();

        int option = 0;
        do {
            System.out.println("""
                    -------------------------------
                    |        MENU OPCIONES        |
                    |-----------------------------|
                    | 1. Administrar cursos.      |
                    | 2. Administrar estudiantes. |
                    |-----------------------------|
                    | 3. Salir.                   |
                    -------------------------------                 
                                        
                    """);
            option = objScanner.nextInt();
            switch (option) {

                case 1:
                    int option2 = 0;
                    do {
                        System.out.println("""
                                ----------------------------------
                                |           MENU CURSOS          |
                                |--------------------------------|
                                | 1. Crear un curso.             |
                                | 2. Buscar un código por código.|
                                | 3. Listar cursos.              |
                                |--------------------------------|
                                | 4. Volver al Menu.             |
                                ---------------------------------
                                                                
                                """);
                        option2 = objScanner.nextInt();
                        switch (option2) {
                            case 1:
                                objGestion.guardarCursos(objScanner);
                                break;
                            case 2:
                                System.out.println("ingresa el codigo del curso");
                                String codigo = objScanner.next();
                                objGestion.buscarPorCodigo(codigo);
                                break;
                            case 3:
                                objGestion.listarCurso();
                                break;
                        }
                    } while (option2 != 4);

                    break;
                case 2:
                    int option3 = 0;
                    do {
                        System.out.println("""
                                ------------------------------
                                |  MENU GESTIÓN ESTUDIANTES  |
                                |----------------------------|
                                | 1. Agregar estudiante.     |
                                | 2. Eliminar estudiante.    |
                                | 3. Listar estudiante.      |
                                | 4. volver al menú anterior |
                                ------------------------------
                                                                
                                """);
                        option3 = objScanner.nextInt();
                        switch (option3) {
                            case 1:
                                objGestion.listarCurso();
                                System.out.println("ingrese el codigo del curso donde deseas inscribir el estudiante");
                                String codigo = objScanner.next();
                                Curso curso =objGestion.buscarPorCodigo(codigo);
                                if (curso==null){
                                    System.out.println("curso no encontrado");
                                }else {
                                    curso.guardarEstudiante(objScanner);
                                }
                                break;
                            case 3:
                                objGestion.listarCurso();
                                System.out.println("ingrese el codigo del curso donde deseas inscribir el estudiante");
                                 codigo = objScanner.next();
                                 curso =objGestion.buscarPorCodigo(codigo);
                                if (curso==null){
                                    System.out.println("curso no encontrado");
                                }else {
                                    curso.listarEstudiante();
                                }
                                break;
                        }
                    } while (option3 != 4);
                    break;
            }
        } while (option != 3);


    }
}
