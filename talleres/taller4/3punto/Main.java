public class Main {
    public static void main(String[] args) {
        Banco cuenta = new Banco("Juan", 1000.0);
        cuenta.depositarDinero();
        cuenta.retirarDinero();
        System.out.println(cuenta);
    }
}
