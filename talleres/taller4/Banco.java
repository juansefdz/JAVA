import java.util.Scanner;

/*Cuenta Bancaria: Implementa una clase CuentaBancaria con los atributos
titular y balance. Añade métodos para depositar dinero, retirar dinero (no
permitas que el balance se vuelva negativo) y mostrar el balance actual.*/
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

    // Método para depositar dinero
    public void depositarDinero() {
        Scanner objScanner = new Scanner(System.in);
        double dineroDepositado = 0;
        do {
            try {
                System.out.println("Ingrese la cantidad de dinero que desee depositar: ");
                dineroDepositado = objScanner.nextDouble();
                if (dineroDepositado > 0) {
                    double nuevoBalance = getBalance() + dineroDepositado;
                    setBalance(nuevoBalance);
                    System.out.println("Se han depositado $" + dineroDepositado + " con éxito.");
                    System.out.println("Su nuevo balance es $" + getBalance());
                } else {
                    System.out.println("Por favor, ingrese una cantidad válida mayor que 0.");
                }
            } catch (Exception e) {
                System.out.println("Por favor, ingrese una cifra válida.");
                objScanner.nextLine(); // Limpiar el buffer del scanner
            }
        } while (dineroDepositado <= 0);
    }

    // Método para retirar dinero
    public void retirarDinero() {
        Scanner objScanner = new Scanner(System.in);
        double dineroRetirado = 0;
        do {
            try {
                System.out.println("Ingrese la cantidad de dinero que desee retirar: ");
                dineroRetirado = objScanner.nextDouble();
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
            } catch (Exception e) {
                System.out.println("Por favor, ingrese una cifra válida.");
                objScanner.nextLine(); // Limpiar el buffer del scanner
            }
        } while (dineroRetirado <= 0 || dineroRetirado > getBalance());
    }

    @Override
    public String toString() {
        return "Banco{" +
                "titular='" + titular + '\'' +
                ", balance=" + balance +
                '}';
    }


}


public class Main {
    public static void main(String[] args) {
        Banco cuenta = new Banco("Juan", 1000.0);
        cuenta.depositarDinero();
        cuenta.retirarDinero();
        System.out.println(cuenta);
    }
}
