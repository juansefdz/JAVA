package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection objConnection = null;

    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bookshop";
            String user = "root";
            String password = "";
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
