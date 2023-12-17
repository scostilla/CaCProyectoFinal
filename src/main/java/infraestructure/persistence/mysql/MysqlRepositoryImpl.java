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
        this.connection = connection;
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
            e.printStackTrace();
        }
    }

    @Override
    public Orador getOradorById(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'getOradorById'");
    }

    @Override
    public ArrayList<Orador> getAll() {

        ArrayList<Orador> oradores = new ArrayList<>();

        String query = "SELECT * FROM Oradores";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String tema = result.getString("tema");

                Orador Orador = new Orador(nombre, apellido, tema);
                oradores.add(Orador);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return oradores;
    }

    @Override
    public void deleteOradorbyId(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteOradorbyId'");
    }

}
