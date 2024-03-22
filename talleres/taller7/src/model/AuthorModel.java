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

public class AuthorModel implements CRUD {

    AuthorModel objAuthorModel;

    public AuthorModel() {
    }

    @Override
    public Object insert(Object object) {
        Connection objConnection = ConfigDB.openConnection();  //open Connection
        System.out.println("PASO");
        Author objAuthor = (Author) object;
        try {
            String sql = "INSERT INTO author (author_name,nationality) VALUES(?,?);"; //SQL sentence

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); //prepare statement

            objPrepare.setString(1, objAuthor.getAuthorName()); //values to  query parameters
            objPrepare.setString(2, objAuthor.getNationality());//values to  query parameters

            objPrepare.execute(); //execute the query

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objAuthor.setId(objResult.getInt(1));
            }
            objPrepare.close();
            JOptionPane.showMessageDialog(null, "author has been create successful");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error adding author" + e.getMessage());
        }

        ConfigDB.closeConnection(); //close connection
        return objAuthor;
    }

    @Override
    public boolean consult(Object object) {
        return false;
    }

    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection(); //open connection
        List<Object> listAuthors = new ArrayList<>();
        try {
            String sql = "SELECT * FROM author ORDER BY author.id ASC;"; //SQL sentence
            PreparedStatement objPrepareStatement = (PreparedStatement) objConnection.prepareStatement(sql);//prepare statement
            ResultSet objResult = objPrepareStatement.executeQuery(); //Execute query or prepare

            while (objResult.next()) { //Get results
                Author objAuthor = new Author();
                objAuthor.setId(objResult.getInt("id"));
                objAuthor.setAuthorName(objResult.getString("author_name")); //values to  query parameters
                objAuthor.setNationality(objResult.getString("nationality"));//values to  query parameters

                listAuthors.add(objAuthor); //add elements to author list

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data acquisition error");
        }
        ConfigDB.closeConnection(); //close connection
        return listAuthors;

    }


    public Object findById(int id) {

        Connection objConnection = ConfigDB.openConnection();
        Author objAuthor = null;
        try {
            String sql = "SELECT * FROM author WHERE id =?;"; //SQL sentence
            PreparedStatement objPrepare = objConnection.prepareStatement(sql); //prepareStatment
            objPrepare.setInt(1, id); //Preparestatment value
            ResultSet objResult = objPrepare.executeQuery(); //execute query

            while (objResult.next()) {

                objAuthor = new Author();
                objAuthor.setId(objResult.getInt("id"));
                objAuthor.setAuthorName(objResult.getString("author_name")); //values to  query parameters
                objAuthor.setNationality(objResult.getString("nationality"));//values to  query parameters
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return objAuthor;
    }


    public Object findbyAuthor(String author_name) {

        Connection objConnection = ConfigDB.openConnection(); //open connection
        List<Author> authorByName = new ArrayList<>();
        String sql = "SELECT * FROM coder WHERE author.name LIKE ?;"; //SQL sentence

        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql); //prepareStatment
            objPrepare.setString(1, "%" + author_name + "%"); //Preparestatment value

            ResultSet objResult = objPrepare.executeQuery(); //execute query
            while (objResult.next()) {
                Author objAuthor = new Author();
                objAuthor.setId(objResult.getInt("id"));
                objAuthor.setAuthorName(objResult.getString("author_name")); //values to  query parameters
                objAuthor.setNationality(objResult.getString("nationality")); //values to  query parameters
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        ConfigDB.closeConnection(); //close connection
        return authorByName;
    }

    @Override
    public Object findbytitle(Object object) {

        return null;
    }
    @Override
    public boolean update(Object object) {

        Connection objConnection = ConfigDB.openConnection(); //open connection

        Author objAuthor = (Author) object; //convert object
        boolean isUpdated = false;

        try {

            String sql = "UPDATE coder SET name_author = ?, nationality = ? WHERE id = ?;"; //SQL sentence
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); //prepare statemente

            objPrepare.setString(1, objAuthor.getAuthorName());  //values to  query parameters
            objPrepare.setString(2, objAuthor.getNationality()); //values to  query parameters
            objPrepare.setInt(3, objAuthor.getId());             //values to  query parameters

            int rowAffected = objPrepare.executeUpdate(); //execute the query
            if (rowAffected > 0) { //validate if there is affected (modified data)
                isUpdated = true;
                JOptionPane.showMessageDialog(null, "The update was successful.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();  //Close connection

        return isUpdated;
    }

    @Override
    public boolean delete(Object object) {

        Author objAuthor = (Author) object; //convert obj entity

        boolean deleteFlag = false;

        Connection objConnection = ConfigDB.openConnection(); //open connection

        try {
            String sql = "DELETE FROM author WHERE author.id=?;"; //SQL sentence

            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); //prepare statement

            objPrepare.setInt(1, objAuthor.getId()); //assign valor from SQL sentence

            int totalAffectedRows = objPrepare.executeUpdate(); //execute the query
            if (totalAffectedRows > 0) {  //validate if there are affected rows (deleted data)
                deleteFlag = true;
                JOptionPane.showMessageDialog(null, "deleted successful the author");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection(); //close connection
        return false;
    }

    public void getAllAuthors() {
        String list = "LIST OF AUTHORS \n";

        for (Object authorTemp : this.objAuthorModel.findAll()) {

            AuthorModel objAuthor = (AuthorModel) authorTemp;
            list += objAuthor.toString() + "\n";

        }
        JOptionPane.showMessageDialog(null, list); //print author list

    }


}
