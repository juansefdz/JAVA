/*Sistema de Gestión de Empleados: Diseña un sistema donde puedas
gestionar empleados utilizando la POO. Crea una clase Empleado con
atributos como nombre, posición, salario y id. Implementa métodos para
obtener y modificar estos atributos, además de un método para aumentar el
salario por un porcentaje dado.*/

import java.util.Scanner;

public class Empleado {
    private String Nombre;
    private String Posicion;
    private  double Salario;
    private  int id;

    //constructor

    public Empleado(String nombre, String posicion, double salario, int id) {
        Nombre = nombre;
        Posicion = posicion;
        Salario = salario;
        this.id = id;
    }

    //metodos
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPosicion() {
        return Posicion;
    }

    public void setPosicion(String posicion) {
        Posicion = posicion;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double salario) {
        Salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void aumentarSalario (){
        Scanner objScanner = new Scanner(System.in);
        double porcentaje = 0;
        double aumento =0;
        System.out.println("en cuanto desea aumentar el salario en porcentaje: ");
        porcentaje=objScanner.nextDouble();
        aumento=(getSalario()*porcentaje/100)+getSalario();
        System.out.println("el salario con el aumento es " + aumento);

    }

    @Override
    public String toString() {
        return "Empleados{" +
                "Nombre='" + Nombre + '\'' +
                ", Posicion='" + Posicion + '\'' +
                ", Salario=" + Salario +
                ", id=" + id +
                '}';
    }
}
