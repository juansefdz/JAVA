import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        /*1. Contador Simple: Escribe un programa que utilice un bucle for para contar del 1 al 10 e
imprimir cada número en la consola.*/
       /* System.out.println("ejercicio 1");
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }
*/
        /*2. Suma de Números: Utiliza un bucle while para sumar los números del 1 al 100 e imprimir
el resultado.*/
        /* System.out.println("ejercicio 2");

       int contador = 1;
        int suma = 0;

        while (contador<=100){
            suma+=contador;
            contador++;
        }
        System.out.println(suma);*/

    /*3. Tabla de Multiplicar: Utiliza un bucle for anidado para imprimir la tabla de multiplicar
del 1 al 10.*/

      /*  System.out.println("ejercicio 3");
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.println("tabla de "+i+" x "+j+" = "+(i*j));
            }

        }*/

        /*Suma de Números Pares: Escribe un programa que sume solo los números pares del 1 al
100 usando un bucle for y luego imprime el resultado.*/

/*

        System.out.println("ejercicio 4");
        int suma =0;
        for (int i = 1; i < 101; i++) {
            if (i%2 == 0) {
                suma+=i;
            }
        }
        System.out.println("la suma de los numeros pares es" + suma);
*/


        /*Validación de Entrada de Usuario: Escribe un programa que solicite al usuario que
ingrese su edad. Si el usuario ingresa un valor que no es un número válido o está fuera de
un rango razonable (por ejemplo, 0-120), el programa debe pedirle al usuario que intente de
nuevo. Utiliza un bucle para seguir solicitando la entrada hasta que sea válida.
*/

       /* System.out.println("ejercicio 5");
        boolean flag= true;

        do {
            String edadstring = JOptionPane.showInputDialog(null, "ingrese la edad");
            try {
                int edad = Integer.parseInt (edadstring);
                if (edad <= 0) {
                    JOptionPane.showMessageDialog(null, "no has nacido aún, eres una computadora o que?");
                } else if (edad > 120) {
                    JOptionPane.showMessageDialog(null, "tienes más años que matusalen, aún respiras?");
                } else {
                    JOptionPane.showMessageDialog(null, "tu edad es " + edad);
                    flag = false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "la edad ingresada no es valida");
            }
        } while (flag);*/


        /*verificar un número primo: escribe un programa que utilice en bucle para verificar si un número dado es primo o no*/
        /*System.out.println("punto 5.");
        boolean flag = false;
        try {
            int primo = Integer.parseInt(JOptionPane.showInputDialog(null, "digite un número para saber si es primo o no"));

            for (int i = 2; i < primo; i++) {
                if (primo % i == 0) {
                    flag = true;
                }
            }
            if (flag) {
                JOptionPane.showMessageDialog(null, "no es primo");
            } else {
                JOptionPane.showMessageDialog(null, " es primo");
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "el numero ingresado no es valido");
        }
*/

        /*Sistema de Menú Interactivo: Desarrolla un sistema de menú interactivo que muestre
diferentes opciones al usuario (por ejemplo, 1. Ver saldo 2. Depositar dinero 3. Retirar
dinero 4. Salir). Utiliza un bucle para permitir al usuario interactuar con el menú hasta que
elija salir.*/

        /*System.out.println("ejercicio 9.");
        String option;
        double saldo = 0;

        do {
            option = JOptionPane.showInputDialog(null, "BANCO \n 1.Ver saldo \n 2.Depositar dinero \n 3.Retirar dinero \n 4. Salir \n\n Ingrese una opción: ");

            switch (option) {
                case "1":
                    JOptionPane.showMessageDialog(null, "tu saldo es: " + saldo);
                    break;
                case "2":
                    String valorsting = JOptionPane.showInputDialog(null, "cuanto dinero desea ingresar: ");
                    try {
                        double valor = Double.parseDouble(valorsting);
                        saldo += valor;
                        JOptionPane.showMessageDialog(null, "dinero ingresado correctamente");

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "valor ingresado no es valido");
                    }
                    break;
                case "3":
                    try {
                        double valorRetirar = Double.parseDouble(JOptionPane.showInputDialog(null,"cuanto dinero desea retirar"));
                        if (valorRetirar<=saldo){
                            saldo-=valorRetirar;
                            JOptionPane.showMessageDialog(null,"retiro de dinero exitoso, \n tu nuevo saldo es:  "+ saldo );
                        } else {
                            JOptionPane.showMessageDialog(null,"saldo no disponible :(");
                        }
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,"valor ingresado no es valido");
                    }


                    break;

            }
        } while (!option.equals("4"));
*/
    }
}
