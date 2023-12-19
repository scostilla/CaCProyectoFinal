package mappers;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Orador;

public class OradorMapper {
    ObjectMapper mapper;

    public OradorMapper() {
        this.mapper = new ObjectMapper();
    }

    public OradorMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public String toJson(Orador orador) {
        try {
            return mapper.writeValueAsString(orador);
        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }
        return null;
    }

    public String toJson(ArrayList<Orador> listaOradores) {

        try {
            return mapper.writeValueAsString(listaOradores);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "[]";
        }
    }

}
