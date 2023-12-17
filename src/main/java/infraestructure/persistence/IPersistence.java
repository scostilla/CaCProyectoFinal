package infraestructure.persistence;

import java.util.ArrayList;

import models.Orador;

public interface IPersistence {

    void guardarOrador(Orador orador);

    Orador getOradorById(int id);

    ArrayList<Orador> getAll();

    void deleteOradorbyId(int id);
}
