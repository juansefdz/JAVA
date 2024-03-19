package entity;

import java.util.Date;

public class Author {
    private int id;
    private String title;
    private Date publication_year;
    private double price;
    private int id_author;


    //constructor
    public Author() {
    }

    public Author(int id, String title, Date publication_year, double price, int id_author) {
        this.id = id;
        this.title = title;
        this.publication_year = publication_year;
        this.price = price;
        this.id_author = id_author;
    }

    //get&set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(Date publication_year) {
        this.publication_year = publication_year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    //toString

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publication_year=" + publication_year +
                ", price=" + price +
                ", id_author=" + id_author +
                '}';
    }
}
