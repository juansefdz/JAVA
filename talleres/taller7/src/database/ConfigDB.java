package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection objConnection = null;

    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://b2m92oeartoxly5lbxbl-mysql.services.clever-cloud.com:3306/b2m92oeartoxly5lbxbl";
            String user = "u63fezacd9tvovsy";
            String password = "0FUZgls3SZoQIJ8VMpfU";
            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("conection successful!");

        } catch (ClassNotFoundException e) {//driver no instalado
            System.out.println("error: driver has not been installed");
        } catch (SQLException e) { //error propio de la base de datos
            System.out.println("error: can't been establish connection with the database! ");
        }
        return objConnection;
    }

    public static void closeConnection() {
        try {//si hay una conexion activa la cerramos
            if (objConnection != null) objConnection.close();
            ;

        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
    }
}
