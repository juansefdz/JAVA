package controller;

import entity.Coder;
import model.CoderModel;

import javax.swing.*;
import java.util.List;


public class CoderController {

    CoderModel objCoderModel;

    public CoderController() {
        //crear una instancia del model
        this.objCoderModel = new CoderModel();
    }

    //method to list all coders
    public void getAll() {

        String list = "LIST CODERS \n";
        //iteramos sobre la lista que devuelve el metodo find all
        for (Object obj : this.objCoderModel.findAll()) {
            //convertimos o casteamos el obj tipo Object a un tipo Coder;
            //se castea para convertir a toString al metodo tipo Coder.
            Coder objCoder = (Coder) obj;
            //concatenamos la información
            list += objCoder.toString() + "\n";

        }
        //imprimimos lista coders
        JOptionPane.showMessageDialog(null, list);

    }

    public void create() {
        Coder objCoder = new Coder();
        String name = JOptionPane.showInputDialog(null, "insert name: ");
        int age = Integer.parseInt(JOptionPane.showInputDialog(null, "insert age"));
        String clan = JOptionPane.showInputDialog(null, "insert clan: ");

        objCoder.setName(name);
        objCoder.setAge(age);
        objCoder.setClan(clan);

        objCoder = (Coder) this.objCoderModel.insert(objCoder);
        JOptionPane.showMessageDialog(null, objCoder.toString());


    }

    public void delete() {
        String listCoderString = "CODER LIST \n";

        for (Object obj : this.objCoderModel.findAll()) {
            Coder objCoder = (Coder) obj;
            listCoderString += objCoder.toString() + "\n";
        }
        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listCoderString + " Enter the ID of the coder to delete"));

        Coder objCoder = (Coder) this.objCoderModel.findById(idDelete);

        if (objCoder == null) {
            JOptionPane.showMessageDialog(null, "Coder not found");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to delete the coder: \n " + objCoder.toString());
            if (confirm == 0) {
                this.objCoderModel.delete(objCoder);

            } else {
                JOptionPane.showMessageDialog(null, "operation cancelled");
            }

        }

    }

    public void getByName() {

        String coderName = JOptionPane.showInputDialog(null, " insert the name of the encoder you want to search ");


        List<Coder> coders = this.objCoderModel.findByName(coderName);

        if (coders.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Coder not found");
        } else {


            for (Coder coderTemp : coders) {
                JOptionPane.showMessageDialog(null, "DEVS FOUND BY NAME  " +"\n => "+ coderTemp.getName().toUpperCase() +  "\nId: "+coderTemp.getId() + " Name: " + coderTemp.getName() + "Clan: " + coderTemp.getClan() + " Age : " + coderTemp.getAge()+"\n");
            }

            /*OPCIÓN PRO*/
            
            StringBuilder showCoders = new StringBuilder ("DEVS FOUND BY NAME"+"\n => "+ coderName.toUpperCase() +"\n");
            for (Coder coderTemp : coders) {
                showCoders.append("ID: ").append(coderTemp.getId()).append("\n");
                showCoders.append("Name: ").append(coderTemp.getName()).append("\n");
                showCoders.append("Age: ").append(coderTemp.getAge()).append("\n");
                showCoders.append("Clan: ").append(coderTemp.getClan()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, showCoders.toString());
        }
    }


}
