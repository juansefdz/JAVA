package entity;

public class book {
    private int id;
    private String title;
    private String year_publication;
    private double price;
    private int fk_id_author;


    //constructor
    public book() {
    }

    public book(int id, String title, String year_publication, double price, int fk_id_author) {
        this.id = id;
        this.title = title;
        this.year_publication = year_publication;
        this.price = price;
        this.fk_id_author = fk_id_author;
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

    public String getYear_publication() {
        return year_publication;
    }

    public void setYear_publication(String year_publication) {
        this.year_publication = year_publication;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFk_id_author() {
        return fk_id_author;
    }

    public void setFk_id_author(int fk_id_author) {
        this.fk_id_author = fk_id_author;
    }

    //toString

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year_publication='" + year_publication + '\'' +
                ", price=" + price +
                ", fk_id_author=" + fk_id_author +
                '}';
    }
}
