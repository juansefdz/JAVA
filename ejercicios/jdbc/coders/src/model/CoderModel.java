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
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            //5. relacionar
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

        //1. convert to object entity
        Coder objCoder = (Coder) object;
        //2. variable booleana para medir el estado de la eliminación
        boolean isDeleted = false;
        //3.Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();
        try {

            //4 escribir la sentencia SQL
            String sql = "DELETE FROM coder WHERE coder.id=?;";

            //5. preparar el statetment
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //6. asignamos el valor ?
            objPrepare.setInt(1, objCoder.getId());

            //7. executeUpdate devuelve la cantidad de filas afectadas por la sentencia SQL ejecutada.

            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows > 0) {
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "the delete was successful");
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        //8. cerrar conexión
        ConfigDB.closeConnection();

        return isDeleted;

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

        //1. abrir la conexión
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = null;
        try{
            //2. sentencia sql
            String sql = "SELECT * FROM coder WHERE id =?;";

            //3. preparar el statement
            PreparedStatement objPrepare =objConnection.prepareStatement(sql);

            //4. definimos el valor del preparestatement
            objPrepare.setInt(1,id);

            //5. ejecutamos el query
            ResultSet objResult = objPrepare.executeQuery();

            // mientras haya un registro siguiente entonces
            while (objResult.next()){
                objCoder= new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setClan(objResult.getString("clan"));
                objCoder.setAge(objResult.getInt("age"));


            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        //7. cerrar la conexion
        ConfigDB.closeConnection();

        return objCoder;
    }


    public List<Coder> findByName(String name) {
        Connection objConnection = ConfigDB.openConnection();
        List<Coder> coderByName = new ArrayList<>();
        String sql = "SELECT * FROM coder WHERE coder.name = ?;";

        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, name);

            ResultSet objResult = objPrepare.executeQuery();

            // Mientras haya un registro siguiente
            while (objResult.next()) {
                Coder objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setClan(objResult.getString("clan"));
                objCoder.setAge(objResult.getInt("age"));
                coderByName.add(objCoder);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return coderByName;
    }



}
