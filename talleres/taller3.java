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
    /*2. Buscador de Número Mayor y Menor: Utiliza un array de int para almacenar 5
        números enteros ingresados por el usuario (puedes usar la clase Scanner para la
        entrada de datos). El programa debe encontrar y mostrar el número mayor y el
        menor de la lista.*/

        Scanner objScanner = new Scanner(System.in);

        int numeros[] = new int[5];

        for (int i = 0; i <= 4; i++) {
            System.out.println("ingrese el numero" + (i + 1));
            try {
                numeros[i] = objScanner.nextInt();
            } catch (Exception e) {
                System.out.println("número no valido!");
                break;
            }
        }

        int mayor = numeros[0];
        int menor = numeros[0];

        for (int i = 0; i <= 4; i++) {

            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
            System.out.println("el numero mayor es " + mayor);
            System.out.println("el numero menor es " + menor);
        }


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

          /*Planificador de Viajes: Escribe un programa para ayudar a planificar viajes por
        carretera. Los usuarios pueden ingresar varias ciudades que planean visitar en
        orden. Utiliza un arreglo de String para almacenar las ciudades. El programa debe
        ser capaz de:
             Añadir y remover ciudades del itinerario.
             Mostrar la lista completa de ciudades a visitar.
             (Opcional) Calcular la distancia total del viaje asumiendo distancias ficticias entre
        ciudades consecutivas.*/

        int option =0;
        ArrayList<String> viajes = new ArrayList<>();



        do{
            try {
                JOptionPane.showMessageDialog(null,"PLANIFICADOR DE VIAJES \n\n 1. Agregar ciudad al intinerario. \n 2. eliminar ciudad del intinerario \n 3. mostrar la lista completa de las ciudades a visitar \n 4. calcular la distancia total del viaje - según distancias ingresadas - \n 5. salir. \n \n Digite una opción ");

                switch (option){

                    case 1:
                        String nuevaCiudad =JOptionPane.showInputDialog("Digite la ciudad que desea ingresar para planificar el viaje");
                        viajes.add(nuevaCiudad.toLowerCase());
                        JOptionPane.showMessageDialog(null,"ciudad agregada correctamente!");
                        break;
                }

            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "opción ingresada no valida");
            }
        }while (option !=4);

        System.out.println("PLANIFICADOR DE VIAJES");



    /*4. Lista de Reproducción Musical: Imagina que estás creando una aplicación para
        gestionar listas de reproducción musicales. Cada canción es representada
        simplemente por su nombre. El programa debe permitir:
         Añadir y remover canciones de la lista de reproducción.
         Mostrar la canción actual y las siguientes en la lista.
         Saltar a la siguiente canción.*/


        //los <> se denominan como "genericos", donde se ingresan parámetros
        //creación de la lista de canciones.
        ArrayList<String> playlist = new ArrayList<>();

        int option =0;
        int cancionActual =0;

        do {
            try {

                option = Integer.parseInt(JOptionPane.showInputDialog("PLAYLIST \n .1 Agregar canción \n 2. Eliminar canción \n 3. mostrar canción actual y siguientes \n 4.saltar a la siguiente canción \n 5. salir. \n\n INGRESE UNA OPCIÓN: "));

                switch (option){
                    case 1: //añadir una canción
                        String nuevaCancion = JOptionPane.showInputDialog("ingrese el nombre de la canción ");
                        //agregamos la nueva canción
                        playlist.add(nuevaCancion.toLowerCase());
                        JOptionPane.showMessageDialog(null, "canción agregada correctamente! ;)");
                        break;
                    case 2: //eliminar canción.
                        String cancionEliminar = JOptionPane.showInputDialog("ingrese la canción que desee eliminar");

                        if(playlist.remove(cancionEliminar.toLowerCase())){
                            JOptionPane.showMessageDialog(null,cancionEliminar + " eliminada correctamente");
                        }else {
                            JOptionPane.showMessageDialog(null, cancionEliminar +" no se encuentra en la playlist");

                        }
                    case 3://mostrar canción actual y la siguiente en la lista
                        //preguntar si la playlist esta vacía
                        if(playlist.isEmpty()){
                            JOptionPane.showMessageDialog(null, "la playlist está vacía!");
                        }else {
                            //creamos una variable para guardar texto en todas las canciones
                            String listaTotal="";

                            //agregamos la canción actual
                            listaTotal+="canción actual \n" + playlist.get(cancionActual)+"\n \n \n ";
                            //recorrer el array

                            for (int i = cancionActual; i < playlist.size()-1; i++) {
                                //recorrer el array
                                //por cada canción que se recorra agrega en el string
                                listaTotal += "siguiente canción \n" + playlist.get(i+1)+"\n";

                            }
                            JOptionPane.showMessageDialog(null,listaTotal);
                        }
                        break;
                    case 4://saltar a la canción siguiente
                        //validar que exista una siguiente canción
                        if (cancionActual+1<playlist.size()){
                            cancionActual++;
                            JOptionPane.showMessageDialog(null,playlist.get(cancionActual)+" Reproducida correctamente!");
                        } else {
                            JOptionPane.showMessageDialog(null, "playlist finalizada");
                            cancionActual=0;
                        }

                        break;
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "caracteres no validos!");
            }

        }while (option != 5);

      

    }
}
