package model;

import database.CRUD;
import database.ConfigDB;
import entity.Author;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static database.ConfigDB.openConnection;

public class AuthorModel implements CRUD {

    AuthorModel objAuthorModel;

    public AuthorModel() {
        this.objAuthorModel = new AuthorModel();
    }

    @Override
    public Object insert(Object object) {
        Connection objConnection = ConfigDB.openConnection();
        Author objAuthor = (Author) object;
        try {
            String sql = "INSERT INTO author (name,nationality) VALUES(?,?);";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objAuthor.getAuthorName());
            objPrepare.setString(2, objAuthor.getNationality());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objAuthor.setId(objResult.getInt(1));
            }
            objPrepare.close();
            JOptionPane.showMessageDialog(null, "author has been create successful");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error adding author" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objAuthor;
    }

    @Override
    public boolean consult(Object object) {
        return false;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public Object findbyAuthor(Object object) {
        return null;
    }

    @Override
    public Object findbytitle(Object object) {
        return null;
    }

    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection(); //open connection
        List<Object> listAuthors = new ArrayList<>();
        try{
            String sql = "SELECT * FROM author ORDER BY author.id ASC;"; //SQL sentence
            PreparedStatement objPrepareStatement = (PreparedStatement) objConnection.prepareStatement(sql);//prepare statement
            ResultSet objResult = objPrepareStatement.executeQuery(); //Execute query or prepare

            while (objResult.next()) { //Get results
                Author objAuthor = new Author();
                objAuthor.setId(objResult.getInt("id"));
                objAuthor.setAuthorName(objResult.getString("author_name"));
                objAuthor.setNationality(objResult.getString("nationality"));

                listAuthors.add(objAuthor); //add elements to author list

            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data acquisition error");
        }
        ConfigDB.closeConnection(); //close connection
        return listAuthors;

    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {

        Author objAuthor = (Author) object; //convert obj entity

        boolean deleteFlag = false;

        Connection objConnection = ConfigDB.openConnection(); //open connection

        try {
            String sql = "DELETE FROM bookshop WHERE author.id=?;"; //SQL sentence

            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); //prepare statement

            objPrepare.setInt(1, objAuthor.getId()); //assign valor from SQL sentence

            int totalAffectedRows = objPrepare.executeUpdate();
            if (totalAffectedRows > 0) {
                deleteFlag = true;
                JOptionPane.showMessageDialog(null, "deleted successful the author");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    public void getAllAuthors() {
        String list = "LIST OF AUTHORS \n";

        for (Object authorTemp : this.objAuthorModel.findAll()) {

            AuthorModel objAuthor = (AuthorModel) authorTemp;
            list += objAuthor.toString() + "\n";

        }
        //print author list
        JOptionPane.showMessageDialog(null, list);

    }


}
