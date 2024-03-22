package controller;

import entity.Book;
import model.BookModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BookController {

    BookModel objBookModel;

    public BookController() {
        this.objBookModel = new BookModel();
    }

    public void getAll() {
        String list = this.getAll(this.objBookModel.findAll());
        //JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List ListObject) {

        String list = "LIST BOOK \n";
        for (Object objTemp : ListObject) {
            Book objBook = (Book) objTemp;
            list += objBook.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, list);


        return list;
    }

    public void create() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        JTextField titleBook = new JTextField();
        JTextField yearPublication = new JTextField();
        JTextField priceBook = new JTextField();
        JTextField idAuthorBook = new JTextField();


        panel.add(new JLabel("Book name:"));
        panel.add(titleBook);
        panel.add(new JLabel("Year publication:"));
        panel.add(yearPublication);
        panel.add(new JLabel("Book price:"));
        panel.add(priceBook);
        panel.add(new JLabel("Id author:"));
        panel.add(idAuthorBook);


        int result = JOptionPane.showConfirmDialog(null, panel, "Book information: ", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {

            String authorNameString = titleBook.getText();
            String yearPublicationString = yearPublication.getText();
            String priceBookString = priceBook.getText();
            String idAuthorBookString = idAuthorBook.getText();


            Book objBook = new Book();
            objBook.setTitle(authorNameString);
            objBook.setYear_publication(yearPublicationString);
            objBook.setPrice(Double.parseDouble(priceBookString));
            objBook.setId(Integer.parseInt(idAuthorBookString));

            objBook = (Book) this.objBookModel.insert(objBook);
            JOptionPane.showMessageDialog(null, objBook.toString());
        }


    }

    public void delete() {
        String listBookString = this.getAll(this.objBookModel.findAll());

        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listBookString + " Enter the ID of the book to delete"));

        Book objBook = (Book) this.objBookModel.findById(idDelete);

        if (objBook == null) {
            JOptionPane.showMessageDialog(null, "Book not found");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to delete that book: \n " + objBook.toString());
            if (confirm == 0) {
                this.objBookModel.delete(objBook);

            } else {
                JOptionPane.showMessageDialog(null, "operation cancelled");
            }

        }

    }
    public void update() {

        String listBook = this.getAll(this.objBookModel.findAll());

        int idUpdate = Integer.parseInt((JOptionPane.showInputDialog(listBook + "\n Enter the ID of the Book to edit")));

        Book objBook = (Book) this.objBookModel.findById(idUpdate);

        if (objBook == null) {
            JOptionPane.showMessageDialog(null, "Book not found!");
        } else {

            JPanel panel = new JPanel(new GridLayout(2, 1));
            JTextField titleBook = new JTextField(objBook.getTitle());
            JTextField yearBook = new JTextField(objBook.getYear_publication());
            JTextField priceBook = new JTextField(String.valueOf(objBook.getPrice()));
            JTextField idAuthorBook = new JTextField(objBook.getFk_id_author());

            panel.add(new JLabel("Title name: "));
            panel.add(titleBook);
            panel.add(new JLabel("Year publication:  "));
            panel.add(yearBook);
            panel.add(new JLabel("price book: "));
            panel.add(priceBook);
            panel.add(new JLabel("ID Author Book"));
            panel.add(idAuthorBook);




            int result = JOptionPane.showConfirmDialog(null, panel, "Ingrese los datos del libro", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {

            }


            this.objBookModel.update(objBook);
        }

    }

    public void findById() {

        int bookId = Integer.parseInt(JOptionPane.showInputDialog(null, " insert the ID of the author you want to search "));


        Object bookID = this.objBookModel.findById(bookId);
        Book castBook = (Book) bookID;
        if (bookID == null) {
            JOptionPane.showMessageDialog(null, "BOOK ID not found");
        } else {


            StringBuilder ShowBooks = new StringBuilder("BOOKS FOUND BY ID => " + bookId + "\n");

            ShowBooks.append("Title: ").append(castBook.getTitle()).append("\n");
            ShowBooks.append("Year publication: ").append(castBook.getYear_publication()).append("\n");
            ShowBooks.append("Price: ").append(castBook.getPrice()).append("\n");
            ShowBooks.append("Id Author: ").append(castBook.getId()).append("\n\n");

            JOptionPane.showMessageDialog(null, ShowBooks.toString());
        }
    }

    public void getByName() {
    }
    public void getByTitle() {
    }

    public void findBookByAuthor() {
    }
}

