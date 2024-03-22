import controller.AuthorController;
import controller.BookCrontroller;

import javax.swing.*;


public class Menu {
    public void menu() {

        int option = 0;
        AuthorController objAuthorController = new AuthorController();
        BookCrontroller objBookController = new BookCrontroller();
        do {
            String[] mainOptions = {"AUTHORS SECTION", "BOOKS SECTION", "EXIT"};
            option = JOptionPane.showOptionDialog(null, "Choose one option: ", "MENU BOOKSHOP", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, mainOptions, mainOptions[0]);
            switch (option) {
                case 0:
                    String optionAuthor;
                    do {
                        String[] optionsAuthors = {"Insert New Author", "Show all Authors", "Show author by ID", "Update specific author", "Delete author by ID", "Back"};
                        optionAuthor = (String) JOptionPane.showInputDialog(null, "Select an option: ", "Authors section", JOptionPane.QUESTION_MESSAGE, null, optionsAuthors, optionsAuthors[0]);

                        switch (optionAuthor) {
                            case "Insert New Author":
                                objAuthorController.create();
                                break;
                            case "Show all Authors":
                                objAuthorController.getAll();
                                break;
                            case "Show author by ID":
                                objAuthorController.findById();
                                break;
                            case "Update specific author":
                                objAuthorController.update();
                                break;
                            case "Delete author by ID":
                                objAuthorController.delete();
                                break;
                            case "back":
                                break;
                        }
                    } while (!"Back".equals(optionAuthor));

                    break;

                case 1:
                    String optionBook;
                    do {
                        String[] optionsBooks = {"Insert new book by author", "Show all books", "Show books by ID", "Show books by title", "Show books by author", "Update specific book ", "Delete book by ID", "Back"};
                        optionBook = (String) JOptionPane.showInputDialog(null, "Select an option: ", "Book section", JOptionPane.QUESTION_MESSAGE, null, optionsBooks, optionsBooks[0]);

                        switch (optionBook) {
                            case "Insert new book by author":
                                objBookController.create();

                                break;
                            case "Show all books":
                                objBookController.getAll();

                                break;
                            case "Show books by ID":
                                objBookController.findById();

                                break;
                            case "Show books by title":
                                objBookController.getByTitle();

                                break;
                            case "Show books by author":
                                objBookController.findBookByAuthor();

                                break;
                            case "Update specific book ":
                                objBookController.update();
                                break;

                            case "back":
                                break;
                        }

                    } while (!"Back".equals(optionBook));

                    break;

                case 2:
                    break;
            }
        } while (option != 2);
    }
}
