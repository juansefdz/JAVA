package entity;


public class Author {

    private int id;
    private String authorName;
    private String Nationality;

    //constructors
    public Author() {
    }

    public Author(int id, String authorName, String nationality) {
        this.id = id;
        this.authorName = authorName;
        Nationality = nationality;
    }

    //get&set


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    //ToString
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", Nationality='" + Nationality + '\'' +
                '}';
    }


}
