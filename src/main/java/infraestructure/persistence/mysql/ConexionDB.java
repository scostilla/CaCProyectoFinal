package infraestructure.persistence.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    public static Connection getConnection() {

        String host = "localhost";
        String port = "3306";
        String username = "root";
        String password = "root";
        String nombredb = "integrador_cac";

        String driverClassName = "com.mysql.cj.jdbc.Driver";

        Connection connection = null;

        try {
            Class.forName(driverClassName);
            System.err.println("******************************connection******************************");
            String url = "jdbc:mysql://" + host + ":" + port + "/" + nombredb;

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("CONEXION ESTABLECIDA ...");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return connection;

    }
}
