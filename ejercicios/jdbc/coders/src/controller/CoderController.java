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


    public void getAll() {

        String list = this.getAll(this.objCoderModel.findAll());
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List ListObject) {

        String list = "LIST CODERS \n";

        for (Object obj : ListObject) {

            Coder objCoder = (Coder) obj;

            list += objCoder.toString() + "\n";

        }
        //imprimimos lista coders
        JOptionPane.showMessageDialog(null, list);
        return list;
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
        String listCoderString = this.getAll(this.objCoderModel.findAll());

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

    public void update() {

        String listCoders = this.getAll(this.objCoderModel.findAll());

        int idUpdate=Integer.parseInt((JOptionPane.showInputDialog(listCoders +"\n Enter the ID of the coder to edit")));

        Coder objCoder = (Coder)this.objCoderModel.findById(idUpdate);

        if (objCoder==null){
            JOptionPane.showMessageDialog(null,"Coder not found!");
        }else {
            String newName = JOptionPane.showInputDialog(null,"Digit the new name: ",objCoder.getName());
            int newAge = Integer.parseInt(JOptionPane.showInputDialog(null,"Digit the new age: ",objCoder.getAge()));
            String newClan = JOptionPane.showInputDialog(null,"Digit the new Clan: ",String.valueOf(objCoder.getClan()));

            //asignamos los nuevos valores
            objCoder.setName(newName);
            objCoder.setAge(newAge);
            objCoder.setClan(newClan);

            this.objCoderModel.update(objCoder);
        }


    }

    public void getByName() {

        String coderName = JOptionPane.showInputDialog(null, " insert the name of the encoder you want to search ");


        List<Coder> coders = this.objCoderModel.findByName(coderName);

        if (coders.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Coder not found");
        } else {


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