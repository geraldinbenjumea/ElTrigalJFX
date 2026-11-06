package co.edu.uniquindio.poo.eltrigaljfx.model;

public class Cajero extends Empleado {

    protected boolean cajaAsignada;

    public Cajero(String nombre, String documentoIdentidad, String codigoUnico, int minutosDisp) {
        super(nombre, documentoIdentidad, codigoUnico, minutosDisp);
    }

    //getter, setter
    public boolean isCajaAsignada() {
        return cajaAsignada;
    }

    public void setCajaAsignada(boolean cajaAsignada) {
        this.cajaAsignada = cajaAsignada;
    }

    @Override
    public String calcularTiempo() {
        return "";
    }
}
