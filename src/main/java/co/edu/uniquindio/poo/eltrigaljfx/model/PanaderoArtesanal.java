package co.edu.uniquindio.poo.eltrigaljfx.model;

public class PanaderoArtesanal extends Empleado {

    protected float bandejas;
    protected float duracion;

    public PanaderoArtesanal(String nombre, String documentoIdentidad, String codigoUnico, int minutosDisp) {
        super(nombre, documentoIdentidad, codigoUnico, minutosDisp);
    }

    //getter, setter

    public float getBandejas() {
        return bandejas;
    }

    public void setBandejas(float bandejas) {
        this.bandejas = bandejas;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    @Override
    public String calcularTiempo() {
        return "";
    }
}
