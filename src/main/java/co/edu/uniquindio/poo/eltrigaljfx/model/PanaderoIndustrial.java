package co.edu.uniquindio.poo.eltrigaljfx.model;

public class PanaderoIndustrial extends Empleado {

    protected float lote;
    protected float preparacion;

    public PanaderoIndustrial(String nombre, String documentoIdentidad, String codigoUnico, int minutosDisp) {
        super(nombre, documentoIdentidad, codigoUnico, minutosDisp);
    }

    //getter, setter
    public float getLote() {
        return lote;
    }

    public void setLote(float lote) {
        this.lote = lote;
    }

    public float getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(float preparacion) {
        this.preparacion = preparacion;
    }

    @Override
    public String calcularTiempo() {
        return "";
    }
}
