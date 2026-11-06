package co.edu.uniquindio.poo.eltrigaljfx.model;

public class Cliente {
    protected String nombre;
    private String documentoIdentidad;
    private ElTrigal ownedByElTrigal;

    public Cliente(String nombre, String documentoIdentidad, ElTrigal ownedByElTrigal) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.ownedByElTrigal = ownedByElTrigal;
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

    public ElTrigal getOwnedByElTrigal() {
        return ownedByElTrigal;
    }

    public void setOwnedByElTrigal(ElTrigal ownedByElTrigal) {
        this.ownedByElTrigal = ownedByElTrigal;
    }
}