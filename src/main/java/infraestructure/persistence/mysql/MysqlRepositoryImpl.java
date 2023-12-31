package infraestructure.persistence.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import infraestructure.persistence.IPersistence;
import models.Orador;

public class MysqlRepositoryImpl implements IPersistence {

    private Connection connection;

    public MysqlRepositoryImpl() {
        System.err.println("******************************MysqlRepositoryImpl******************************");
        this.connection = ConexionDB.getConnection();
    }

    @Override
    public void guardarOrador(Orador orador) {
        String query = "INSERT INTO oradores (nombre,apellido,tema) VALUES(?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, orador.getNombre());
            statement.setString(2, orador.getApellido());
            statement.setString(3, orador.getTema());

            statement.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Orador getOradorById(int id) {
        return null;
    }

    @Override
    public ArrayList<Orador> getAll() {

        ArrayList<Orador> oradores = new ArrayList<>();

        String query = "SELECT * FROM oradores";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String tema = result.getString("tema");

                Orador Orador = new Orador(nombre, apellido, tema);
                oradores.add(Orador);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return oradores;
    }

    @Override
    public Orador update(Orador datosParaActualizar) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteOradorbyId(int id) {
        // TODO Auto-generated method stub
    }

}
