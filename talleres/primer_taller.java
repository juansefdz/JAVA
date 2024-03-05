import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {



       /*Ejercicio 1: Calculadora Básica
        Escribe un programa que pida al usuario dos números y luego muestre el resultado de sumar, restar,
        multiplicar y dividir esos números. Utiliza tipos de datos primitivos para almacenar los números y
        los resultados.*/
        /*
        System.out.println("punto 1.");
        boolean validacion;
        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(null, "Ingrese el valor. \nINGRESE: \n1. SUMA \n2. RESTA \n3. MULTIPLICACION \n4. DIVISION");
            validacion = opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4");
            if (!validacion) {
                System.out.println("La información ingresada no es válida.");
            }
        } while (!validacion);

        String num1 = JOptionPane.showInputDialog(null, "Ingrese el numero 1: ");
        String num2 = JOptionPane.showInputDialog(null, "Ingrese el numero 2: ");
        double a = Double.parseDouble(num1);
        double b = Double.parseDouble(num2);

        switch (opcion) {
            case "1":
                System.out.println("La suma de " + a + " + " + b + " = " + (a + b));
                break;
            case "2":
                System.out.println("La resta de " + a + " - " + b + " = " + (a - b));
                break;
            case "3":
                System.out.println("La multiplicacion de " + a + " * " + b + " = " + (a * b));
                break;
            case "4":
                if (b != 0) {
                    System.out.println("La division de " + a + " / " + b + " = " + (a / b));
                } else {
                    System.out.println("No se puede dividir entre cero.");
                }
                break;
            default:
                System.out.println("Opción no válida.");
        }*/
        /*Ejercicio 2: Verificador de Edad
        Crea un programa que solicite la edad del usuario y determine si es mayor de edad (18 años o más).
        El programa debe imprimir un mensaje indicando si el usuario es mayor de edad o no.*/

        /*System.out.println("punto 2.");

        String edadStr = JOptionPane.showInputDialog(null, "Digite su edad");
        int edad = Integer.parseInt(edadStr);

        if (edad >= 18) {
            JOptionPane.showMessageDialog(null, "usted es mayor de edad");
        } else {
            JOptionPane.showMessageDialog(null, "usted es menor de edad");
        }
*/


    /*Ejercicio 3: Conversor de Unidades
    Desarrolla un programa que convierta kilómetros a millas. El programa debe solicitar al usuario que
    introduzca una distancia en kilómetros y luego debe mostrar la distancia equivalente en millas.
    Utiliza el hecho de que una milla es igual a 1.60934 kilómetros.


     */
        /*System.out.println("punto 3.");
        String kilometros = JOptionPane.showInputDialog(null,"ingrese los kilometros");
        double kms = Integer.parseInt(kilometros);

        double millas = (kms * 0.621371);
        JOptionPane.showMessageDialog(null,kms +" Kilometros son:"+ millas +" millas");*/

/*Ejercicio 4: Calculadora de Índice de Masa Corporal (IMC)
Escribe un programa que calcule el índice de masa corporal (IMC) de una persona. El programa
debe pedir al usuario su peso en kilogramos y su altura en metros, calcular el IMC y mostrar un
mensaje con el resultado. La fórmula para calcular el IMC es peso / (altura * altura).
*/
       /* System.out.println("punto 4");
        String peso = JOptionPane.showInputDialog(null,"ingrese su peso en kgs: ");
        String altura = JOptionPane.showInputDialog(null, "ingrese su altura en metros: ");

        double pesoconv = Double.parseDouble(peso);
        double alturaconv = Double.parseDouble(altura);

        double IMC =pesoconv/(alturaconv*alturaconv);

        JOptionPane.showMessageDialog(null,"su IMC ES " +IMC);*/

        /*Ejercicio 5: Clasificador de Números
Crea un programa que solicite al usuario un número y muestre un mensaje indicando si el número
es positivo, negativo o cero. Además, indica si el número es par o impar.*/

    }
}
