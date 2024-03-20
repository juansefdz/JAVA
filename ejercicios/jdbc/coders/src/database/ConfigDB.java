package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


    public class ConfigDB {
        //variable que va a contener el estado de la conexion
        static Connection objConnection = null;

        //metodo para establecer la conexión entre JAVA Y BASEDATOS


        public static Connection openConnection() {
            try {
                //clas forname permite implementar el driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                //se crean las variables para las credenciales a la db
                String url = "jdbc:mysql://localhost:3306/_01_jdbc";
                String user = "root";
                String password = "Rlwl2023.";
                //establece la conexion
                objConnection = (Connection) DriverManager.getConnection(url, user, password);
                System.out.println("conection successful!");


            } catch (ClassNotFoundException e) {//driver no instalado
                System.out.println("error: driver has not been installed");
            } catch (SQLException e) { //error propio de la base de datos
                System.out.println("error: can't been establish connection with the database! ");
            }
            return objConnection;
        }


        public static void closeConnection(){
            try {
                //si hay una conexion activa la cerramos
                if (objConnection !=null) objConnection.close();;

            }catch (SQLException e){
                System.out.println("error"+e.getMessage());
            }
        }
    }

