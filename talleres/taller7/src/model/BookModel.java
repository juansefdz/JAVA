package model;

import database.CRUD;
import database.ConfigDB;
import entity.Author;
import entity.Book;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookModel implements CRUD {


    @Override
    public Object insert(Object object) {
        Connection objConnection = null;
        Book objBook = (Book) object;
        try {
            objConnection = ConfigDB.openConnection();
            String sql = "INSERT INTO book (title, year_publication, price, id_author) VALUES (?, ?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objBook.getTitle());
            objPrepare.setDate(2, Date.valueOf(objBook.getYear_publication()));
            objPrepare.setDouble(3, objBook.getPrice());
            objPrepare.setInt(4, objBook.getFk_id_author());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            if (objResult.next()) {
                objBook.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Book has been created successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding book: " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return objBook;
    }
    @Override
    public boolean consult(Object object) {
        return false;
    }

    public Object findById(int id) {

        Connection objConnection = ConfigDB.openConnection();
        Book objBook = null;
        try {
            String sql = "SELECT * FROM book WHERE id =?;"; //SQL sentence
            PreparedStatement objPrepare = objConnection.prepareStatement(sql); //prepareStatment
            objPrepare.setInt(1, id); //Preparestatment value
            ResultSet objResult = objPrepare.executeQuery(); //execute query

            while (objResult.next()) {

                objBook = new Book();
                objBook.setId(objResult.getInt("id"));
                objBook.setTitle(objResult.getString("title")); //values to  query parameters
                objBook.setYear_publication(String.valueOf(objResult.getDate("year_publication")));//values to  query parameters
                objBook.setPrice(objResult.getDouble("price"));
                objBook.setFk_id_author(objResult.getInt("id_author"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return objBook;
    }

    @Override
    public Object findbyAuthor(String author_name) {
        return null;
    }


    public List<Object> findBookByAuthor(int id){

        Connection objConnection = ConfigDB.openConnection();
        List<Object> listBooksByAuthor = new ArrayList<>();

        try {

            String sql ="SELECT * FROM book INNER JOIN authors ON authors.id= books.idAuthor WHERE authors.id = ?; ";

            PreparedStatement objPrepared = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepared.setInt(1,id);

            ResultSet objResultset = (ResultSet) objPrepared.executeQuery();

            while (objResultset.next()){
                Book objBook = new Book();

            }


        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"data error"+e.getMessage());
        }

        ConfigDB.closeConnection();
        return listBooksByAuthor;
    }


    @Override
    public Object findbytitle(Object object) {
        return null;
    }

    @Override
    public List<Object> findAll() {

        Connection objConnection = ConfigDB.openConnection(); //open connection
        List<Object> listBooks = new ArrayList<>();
        try {
            String sql = "SELECT * FROM book ORDER BY book.id ASC;"; //SQL sentence
            PreparedStatement objPrepareStatement = (PreparedStatement) objConnection.prepareStatement(sql);//prepare statement
            ResultSet objResult = objPrepareStatement.executeQuery(); //Execute query or prepare

            while (objResult.next()) { //Get results
                Book objBook = new Book();
                objBook.setId(objResult.getInt("id"));
                objBook.setTitle(objResult.getString("title")); //values to  query parameters
                objBook.setYear_publication(String.valueOf(objResult.getDate("year_publication")));//values to  query parameters
                objBook.setPrice(objResult.getDouble("price")); //values to  query parameters


                listBooks.add(objBook); //add elements to author list

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data acquisition error");
        }
        ConfigDB.closeConnection(); //close connection
        return listBooks;

    }

    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.openConnection(); //open connection

        Book objBook = (Book) object; //convert object
        boolean isUpdated = false;

        try {

            String sql = "UPDATE book SET title = ?, year_publication = ?, price = ? WHERE id = ?;"; //SQL sentence
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); //prepare statemente

            objPrepare.setString(1, objBook.getTitle());  //values to  query parameters
            objPrepare.setDate(2, Date.valueOf(objBook.getYear_publication())); //values to  query parameters
            objPrepare.setDouble(3, objBook.getPrice());//values to  query parameters
            objPrepare.setInt(3, objBook.getId());

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
        Book objBook = (Book) object;
        boolean deleteFlag = false;
        Connection objConnection = null;
        try {
            objConnection = ConfigDB.openConnection();
            String sql = "DELETE FROM book WHERE id=?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, objBook.getId());
            int totalAffectedRows = objPrepare.executeUpdate();
            if (totalAffectedRows > 0) {
                deleteFlag = true;
                JOptionPane.showMessageDialog(null, "Book deleted successfully.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting book: " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return deleteFlag;
    }
}