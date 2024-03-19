package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CoderModel implements CRUD {

    @Override
    public Object insert(Object object) {
        //open connection

        Connection objConnection = ConfigDB.openConnection();

        //casteamos el objeto

        Coder objCoder = (Coder) object;

        try {

            //3. Create sql
            String sql = "INSERT INTO coder (name,age,clan) VALUES(?,?,?);";
            //4. preparar el statement
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            //5. relacionar, -asignar los ?-
            objPrepare.setString(1, objCoder.getName());
            objPrepare.setInt(2, objCoder.getAge());
            objPrepare.setString(3, objCoder.getClan());

            //6. ejecutamos el Query
            objPrepare.execute();
            //7. obtener los resultados
            //trae lo que se ejecuto en el query pero con la keys.
            ResultSet obResult = objPrepare.getGeneratedKeys();
            while (obResult.next()) {
                objCoder.setId(obResult.getInt(1));
            }
            objPrepare.close();
            JOptionPane.showMessageDialog(null, "Coder insertion was successful");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error adding Coder" + e.getMessage());

        }

        ConfigDB.closeConnection();
        return objCoder;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public List<Object> findAll() {
        //1. open connection
        Connection objConnection = ConfigDB.openConnection();

        //2. initialize the list where the records returned by the DB will be saved
        List<Object> listCoders = new ArrayList<>();

        try {
            //3. write the SQL statement

            String sql = "SELECT * FROM coder ORDER BY coder.id ASC;";

            //4. prepare PrepareStatement
            PreparedStatement objPrepareStatement = (PreparedStatement) objConnection.prepareStatement(sql);

            //5. Execute query or prepare
            ResultSet objResult = objPrepareStatement.executeQuery();

            //6. Get results

            while (objResult.next()) {
                Coder objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));

                //add elements to list coders
                listCoders.add(objCoder);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data acquisition error");
        }
        //7. close connection
        ConfigDB.closeConnection();
        return listCoders;
    }

    @Override
    public Object findById(int id) {
        return null;
    }
}
