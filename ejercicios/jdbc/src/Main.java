import controller.CoderController;
import database.ConfigDB;
import model.CoderModel;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CoderController objCoderController = new CoderController();
        String option ="";
        do {
            option = JOptionPane.showInputDialog(null, """
                    
                    MENU.            
                  
                    1. List Coders.  
                    2. Insert Coders.
                    3. Update Coder. 
                    4. Delete Coder. 
                    5. Get by name.
                    6. Exit.
                    
                    
                    Choose an option:
                    """);
        }while (option.equals("6"));

        switch (option){
            case "1": //List all coders
                objCoderController.getAll();
                break;
            case "2": //List all coders
                objCoderController.create();
                break;
        }


    }
}