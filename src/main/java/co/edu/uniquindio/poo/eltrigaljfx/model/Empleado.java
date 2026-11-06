package co.edu.uniquindio.poo.eltrigaljfx.model;

public abstract class Empleado {
    protected String nombre;
    protected String documentoIdentidad;
    protected String codigoUnico;
    protected int minutosDisp;

    public Empleado(String nombre, String documentoIdentidad, String codigoUnico, int minutosDisp) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.codigoUnico = codigoUnico;
        this.minutosDisp = minutosDisp;
    }
    //getter, setters

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

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public int getMinutosDisp() {
        return minutosDisp;
    }

    public void setMinutosDisp(int minutosDisp) {
        this.minutosDisp = minutosDisp;
    }

    //metodo abstracto
    public abstract String calcularTiempo();
}
