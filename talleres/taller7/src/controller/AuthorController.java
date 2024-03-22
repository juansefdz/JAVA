package controller;

import entity.Author;
import model.AuthorModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AuthorController {

    AuthorModel objAuthorModel;

    public AuthorController() {
        this.objAuthorModel = new AuthorModel();
    }

    public void getAll() {
        String list = this.getAll(this.objAuthorModel.findAll());
        JOptionPane.showInputDialog(null, list);
    }

    public String getAll(List ListObject) {

        String list = "LIST CODERS \n";
        for (Object objTemp : ListObject) {
            Author objCoder = (Author) objTemp;
            list += objCoder.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, list);
        return list;
    }

    public void create() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        JTextField AuthorName = new JTextField();
        JTextField AuthorNationality = new JTextField();

        panel.add(new JLabel("Author Name:"));
        panel.add(AuthorName);

        panel.add(new JLabel("Author Nationality"));
        panel.add(AuthorNationality);

        int result = JOptionPane.showConfirmDialog(null, panel, "Author information: ", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String authorName = AuthorName.getText();
            String authorNationality = AuthorNationality.getText();

            Author objAuthor = new Author();
            objAuthor.setAuthorName(authorName);
            objAuthor.setNationality(authorNationality);
            objAuthor = (Author) this.objAuthorModel.insert(objAuthor);
            JOptionPane.showMessageDialog(null, objAuthor.toString());
        }




    }

    public void delete() {
        String listAuthorString = this.getAll(this.objAuthorModel.findAll());

        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listAuthorString + " Enter the ID of the author to delete"));

        Author objAuthor = (Author) this.objAuthorModel.findById(idDelete);

        if (objAuthor == null) {
            JOptionPane.showMessageDialog(null, "Author not found");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to delete the author: \n " + objAuthor.toString());
            if (confirm == 0) {
                this.objAuthorModel.delete(objAuthor);

            } else {
                JOptionPane.showMessageDialog(null, "operation cancelled");
            }

        }

    }

    public void update() {

        String listAuthors = this.getAll(this.objAuthorModel.findAll());

        int idUpdate = Integer.parseInt((JOptionPane.showInputDialog(listAuthors + "\n Enter the ID of the author to edit")));

        Author objAuthor = (Author) this.objAuthorModel.findById(idUpdate);

        if (objAuthor == null) {
            JOptionPane.showMessageDialog(null, "Author not found!");
        } else {
            String newAuthorName = JOptionPane.showInputDialog(null, "Enter the new author name:  ", objAuthor.getAuthorName());
            String newAuthorNationality = JOptionPane.showInputDialog(null, "enter the new nationality: ", String.valueOf(objAuthor.getNationality()));

            //asignamos los nuevos valores
            objAuthor.setAuthorName(newAuthorName);

            objAuthor.setNationality(newAuthorNationality);

            this.objAuthorModel.update(objAuthor);
        }

    }

    public void getByName() {

        String authorName = JOptionPane.showInputDialog(null, " insert the name of the author you want to search ");


        List<Author> author = (List<Author>) this.objAuthorModel.findbyAuthor(authorName);

        if (author.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Author not found");
        } else {


            StringBuilder showAuthors = new StringBuilder("AUTHORS FOUND BY NAME" + "\n => " + authorName.toUpperCase() + "\n");
            for (Author authorTemp : author) {
                showAuthors.append("ID: ").append(authorTemp.getId()).append("\n");
                showAuthors.append("Name: ").append(authorTemp.getAuthorName()).append("\n");
                showAuthors.append("Nationality: ").append(authorTemp.getNationality()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, showAuthors.toString());
        }
    }


}
