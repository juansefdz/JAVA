import controller.CoderController;
import database.ConfigDB;
import model.CoderModel;

import javax.swing.*;

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
            case "3": //update coder
                //objCoderController.update();
                break;
            case "4"://delete coder
                objCoderController.delete();
                break;
            case "5"://get by name
                objCoderController.getByName();
                break;
        }


    }
}