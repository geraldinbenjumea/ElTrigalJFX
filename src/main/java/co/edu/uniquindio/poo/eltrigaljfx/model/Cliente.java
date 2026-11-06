package co.edu.uniquindio.poo.eltrigaljfx.model;

public class Cliente {
    protected String nombre;
    private String documentoIdentidad;

    public Cliente(String nombre, String documentoIdentidad) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
    }

    //getter, setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }
}
