import javax.swing.*;

public class Menu {
    public void menu() {
        int option = 0;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    EMPLOYEE MANAGEMENT MENU
                                    
                    1. Add employee.
                    2. Delete employee.
                    3. Show Employees list.
                                    
                    4. exit. 
                                    
                    enter the desired option"""));
        } while (option != 3);
        switch (option) {
            case 1:
                String name = JOptionPane.showInputDialog(null, "name");
                int age = Integer.parseInt(JOptionPane.showInputDialog(null, "age"));

                break;


        }
    }


}
