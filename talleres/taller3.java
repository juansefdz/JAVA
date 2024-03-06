import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


    /* 1. Calculadora de Promedios: Escribe un programa que utilice un array de tipo
    double para almacenar las calificaciones finales de 10 estudiantes en un curso. El
    programa debe calcular y mostrar el promedio de estas calificaciones.

     */
        //creamos nuestro objeto scanner.
        //el escanner toma los elementos digitados por consola.
        Scanner objScanner = new Scanner(System.in);

        //creamos el array
        double[] notas = new double[10];
        double sumatotal=0;


        for (int i = 0; i < 10; i++) {
            System.out.println("ingrese la nota del estudiante # " + (i + 1));
            try {
                notas[i] = objScanner.nextDouble();
                sumatotal+=notas[i];
            }catch(Exception e){
                System.out.println("nota no valida!");
                break;
            }

        }
        double promedio = sumatotal/notas.length;
        System.out.println("el promedio de notas del estudiante es " + promedio);

   /*3. Sistema de Reservas: Desarrolla un programa para un teatro para gestionar las
        reservas de asientos. El teatro tiene 5 filas con 10 asientos cada una. Utiliza un
        arreglo bidimensional de boolean donde true representa un asiento ocupado y false
        uno disponible. El sistema debe permitir:
             Reservar y cancelar asientos.
             Mostrar los asientos disponibles.
             Contabilizar el total de asientos ocupados y disponibles.*/

        //creamos la matriz para guardar el estado de los asientos
        boolean[][] listaAsientos = new boolean[5][10];

        //creamos objeto scanner obtener info
        Scanner objScanner = new Scanner(System.in);

        //variable opcion usuario
        int opcion = 0;
        int silla = 0;
        int fila = 0;

        do {
            objScanner.nextLine();
            System.out.println("enter para continuar...");
            objScanner.nextLine();
            System.out.println("menu reservas RIWICINE ");
            System.out.println("1. reservar asientos ");
            System.out.println("2. Cancelar asiento.");
            System.out.println("3. mostrar asientos");
            System.out.println("4. contabilizar asientos ocupados y disponibles");
            System.out.println("5. salir");
            System.out.println("ingrese una opción");
            opcion = objScanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("ingrese fila de 1 a 5");
                    fila = objScanner.nextInt() - 1;
                    System.out.println("ingrese el asiento de 1 a 10");
                    silla = objScanner.nextInt() - 1;

                    if (listaAsientos[fila][silla] == false) {
                        listaAsientos[fila][silla] = true;
                        System.out.println("la silla ha sido reservada con éxito!");
                    } else {
                        System.out.println("lo siento, esta silla no se encuentra disponible :(");
                    }

                    break;
                case 2:
                    System.out.println("ingrese fila de 1 a 5");
                    fila = objScanner.nextInt() - 1;
                    System.out.println("ingrese el asiento de 1 a 10");
                    silla = objScanner.nextInt() - 1;

                    if (listaAsientos[fila][silla] == true) {
                        listaAsientos[fila][silla] = false;
                        System.out.println("la silla ha sido eliminada con éxito! ");
                    } else {
                        System.out.println(" la silla ya se encontraba disponible, no hay reserva que eliminar! ;)");
                    }
                    break;
                case 3:
                    System.out.println("asientos disponibles");

                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 10; j++) {

                            if (!listaAsientos[i][j]) {
                                System.out.print("["+"[" + (i + 1) + "]" + "[" + (j + 1) + "]"+"]" + "\t");
                            }else {
                                System.out.print("["+"[" + "X" + "]" + "[" + "X" + "]"+"]" + "\t");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    int ocupados =0, disponibles = 0;

                    for (boolean[] filaAsiento: listaAsientos){
                        for (boolean asiendoOcupado: filaAsiento){
                            if (asiendoOcupado){
                                ocupados++;
                            }else {
                                disponibles++;
                            }
                        }
                    }

                    System.out.println("Total de asientos ocupados: "+ ocupados);
                    System.out.println("Total de asientos disponibles: "+ disponibles);
                    break;
            }
        } while (opcion != 5);



      

    }
}
