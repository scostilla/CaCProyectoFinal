package infraestructure.persistence.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    public static Connection getConnection() {
        String host = "localhost";
        String port = "3306";
        String username = "root";
        String password = "Sa123456.";
        String nombredb = "integrador_cac";

        String driverClassName = "com.mysql.cj.jdbc.Driver";

        Connection connection = null;

        try {
            Class.forName(driverClassName);
            String url = "jdbc:mysql://" + host + ":" + port + "/" + nombredb;

            connection = DriverManager.getConnection(url, username, password);
            System.err.println("Conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
