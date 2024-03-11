

/*Cuenta Bancaria: Implementa una clase CuentaBancaria con los atributos
titular y balance. Añade métodos para depositar dinero, retirar dinero (no
permitas que el balance se vuelva negativo) y mostrar el balance actual.*/
import java.util.Scanner;

public class Banco {

    private String titular;
    private double balance;

    // Constructor
    public Banco(String titular, double balance) {
        this.titular = titular;
        this.balance = balance;
    }

    // Métodos
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Método para operaciones en el cajero
    public void cajero() {
        Scanner objScanner = new Scanner(System.in);
        int opcionCajero;
        do {
            System.out.println("Bienvenido al cajero automático.");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opción: ");
            opcionCajero = objScanner.nextInt();
            switch (opcionCajero) {
                case 1:
                    depositarDinero();
                    break;
                case 2:
                    retirarDinero();
                    break;
                case 3:
                    System.out.println("¡Gracias por utilizar nuestros servicios!");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        } while (opcionCajero != 3);
        objScanner.close(); // Cerrar el Scanner
    }

    // Método para depositar dinero
    public void depositarDinero() {
        Scanner objScanner = new Scanner(System.in);
        double dineroDepositado;
        do {
            System.out.println("Ingrese la cantidad de dinero que desee depositar: ");
            dineroDepositado = leerDoubleValidado(objScanner);
            if (dineroDepositado > 0) {
                double nuevoBalance = getBalance() + dineroDepositado;
                setBalance(nuevoBalance);
                System.out.println("Se han depositado $" + dineroDepositado + " con éxito.");
                System.out.println("Su nuevo balance es $" + getBalance());
            } else {
                System.out.println("Por favor, ingrese una cantidad válida mayor que 0.");
            }
        } while (dineroDepositado <= 0);
        objScanner.close(); // Cerrar el Scanner
    }

    // Método para retirar dinero
    public void retirarDinero() {
        Scanner objScanner = new Scanner(System.in);
        double dineroRetirado;
        do {
            System.out.println("Ingrese la cantidad de dinero que desee retirar: ");
            dineroRetirado = leerDoubleValidado(objScanner);
            if (dineroRetirado > 0 && dineroRetirado <= getBalance()) {
                double nuevoBalance = getBalance() - dineroRetirado;
                setBalance(nuevoBalance);
                System.out.println("Se han retirado $" + dineroRetirado + " con éxito.");
                System.out.println("Su nuevo balance es $" + getBalance());
            } else if (dineroRetirado > getBalance()) {
                System.out.println("La cantidad de dinero que se desea retirar excede su balance.");
            } else {
                System.out.println("Por favor, ingrese una cantidad válida mayor que 0.");
            }
        } while (dineroRetirado <= 0 || dineroRetirado > getBalance());
        objScanner.close();
    }

    // Método auxiliar para leer un double validado
    private double leerDoubleValidado(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, ingrese un número válido: ");
            scanner.next(); // Limpiar el buffer del scanner
        }
        return scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "Banco{" +
                "titular='" + titular + '\'' +
                ", balance=" + balance +
                '}';
    }
}



