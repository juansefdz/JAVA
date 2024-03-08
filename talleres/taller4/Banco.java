import java.util.Scanner;

public class Banco {

    private String titular;
    private double balance;

//constructor

    public Banco(String titular, double balance) {
        this.titular = titular;
        this.balance = balance;
    }

//método
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

    //métodos solicitados
    public void depositarDinero {
        Scanner objScanner = new Scanner(System.in);
        double dineroDepositado = 0;
        do {
            try {
                System.out.println("ingrese la cantidad de dinero que desee depositar:  ");
                dineroDepositado=objScanner.nextDouble();

            }catch (Exception e){
                System.out.println("ingrese una cifra valida!");
            }

        }while (dineroDepositado<0);

    }

    public void retirarDinero{
        Scanner objScanner = new Scanner(System.in);
        double dineroRetirado = 0;
        do {
            try {
                System.out.println("ingrese la cantidad de dinero que desee retirar:  ");

                dineroRetirado=objScanner.nextDouble();
                if (dineroRetirado<getBalance()){
                    double nuevoBalance=getBalance()-dineroRetirado;
                    setBalance(nuevoBalance);
                    System.out.println("su nuevo balance es "+getBalance());

                }else{
                    System.out.println("la cantidad de dinero que se desea retirar excede su balance");
                }


            }catch (Exception e){
                System.out.println("ingrese una cifra valida!");
            }

        }while (dineroDepositado<0);

    }

    @Override
    public java.lang.String toString() {
        return "Banco{" +
                "String=" + titular +
                ", balance=" + balance +
                '}';
    }
}

