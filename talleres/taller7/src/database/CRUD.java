package database;


import java.util.List;

public interface CRUD {
    //insert
    public Object insert(Object object);

    public boolean consult(Object object);

    //consult

    public Object findById(int id);

    public Object findbyAuthor(String author_name);

    public Object findbytitle(Object object);

    //showall
    public List<Object> findAll();

    //update
    public boolean update(Object object);

    //delete
    public boolean delete(Object object);


}
