import javax.swing.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("punto 1.");
        Scanner obScanner1= new Scanner(System.in);
        String option = JOptionPane.showInputDialog(null,"ingrese el valor. \"INGRESE: 1. SUMAR 2. RESTAR 3. MULTIPLICAR 4. DIVIDIR\"");

        String num1 = JOptionPane.showInputDialog(null,"ingrese el numero 1: ");
        String num2 = JOptionPane.showInputDialog(null,"ingrese el numero 2: ");
        double a = Double.parseDouble(num1);
        double b = Double.parseDouble(num2);
        switch (option){
            case "1": break;
            case "2": break;
            case "3": break;
            case "4": break;
            default:
        }
    }
}
