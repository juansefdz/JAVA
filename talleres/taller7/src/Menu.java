import javax.swing.*;

public class Menu {
    public void menu() {

        int option = 0;
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
                    } while (!"Back".equals(optionAuthor));

                    break;

                case 1:
                    String optionBook;
                    do {
                        String[] optionsBooks = {"Insert new book by author", "Show all books", "Show books by ID", "Show books by title", "Show books by author", "Update specific book ", "Delete book by ID", "Back"};
                        optionBook = (String) JOptionPane.showInputDialog(null, "Select an option: ", "Book section", JOptionPane.QUESTION_MESSAGE, null, optionsBooks, optionsBooks[0]);
                    } while (!"Back".equals(optionBook));

                    break;

                case 2:

                    break;
            }
        } while (option != 2);
    }
}
