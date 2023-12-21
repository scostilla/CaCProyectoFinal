package models;

public class Orador {
    private int id_orador;
    private String nombre;
    private String apellido;
    private String tema;

    public Orador() {
    }

    public Orador(String nombre, String apellido, String tema) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tema = tema;
    }

    public int getId() {
        return id_orador;
    }

    public void setId(int id_orador) {
        this.id_orador = id_orador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

}
