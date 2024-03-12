import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Curso {

    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> listaEstudiantes;

    private static int idEstudiante = 1;

    //constructor
    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaEstudiantes = new ArrayList<>();
    }

    //métodos
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }


    //métodos

    public void guardarEstudiante(Scanner objScanner) {
        //String nombre =JOptionPane.showInputDialog(null,"AGREGAR NUEVO ESTUDIANTE \n INGRESA EL NOMBRE DEL ESTUDIANTE: ")
        System.out.println("Agregar nuevo Estudiante ");
        System.out.println("ingrese el nombre del estudiante");
        String nombre = objScanner.next();
        //String correo =JOptionPane.showInputDialog(null,"AGREGAR NUEVO ESTUDIANTE \n INGRESA EL CORREO DEL ESTUDIANTE: ")
        System.out.println("ingrese el correo del estudiante");
        String correo = objScanner.next();

        Estudiante objEstudiante = new Estudiante(idEstudiante, nombre, correo);
        idEstudiante++;
        if (listaEstudiantes.add(objEstudiante)) {
            System.out.println("estudiante agregado correctamente");
        } else {
            System.out.println("no se pudo agregar el estudiante");
        }

    }

    public void listarEstudiante() {
        if (this.listaEstudiantes.isEmpty()) {
            System.out.println("la lista de estudiantes está vacía");

        } else {
            System.out.println("LISTA ESTUDIANTES CURSO\n");

            for (Estudiante estudianteTemporal:this.listaEstudiantes ){
                System.out.println(estudianteTemporal.toString());
            }

        }
    }

    public void eliminarEstudiante(Scanner idScanner){
        this.listarEstudiante();
        System.out.println("Digite la id del estudiante que desea Eliminar: ");
        int idEliminar = idScanner.nextInt ();
        if (listaEstudiantes.removeIf(Estudiante -> Estudiante.getId()==idEliminar)){
            System.out.println("estudiante eliminado correctamente");
        } else {
            System.out.println("no se pudo eliminar el estudiante");
        };

    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';
    }
}



