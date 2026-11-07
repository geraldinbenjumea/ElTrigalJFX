package co.edu.uniquindio.poo.eltrigaljfx.model;

public class PanaderoIndustrial extends Empleado {

    protected float lote;
    protected float preparacion =20;
    protected float duracionTotal;

    public PanaderoIndustrial(String nombre, String documentoIdentidad, String codigoUnico,
                              int minutosDisp, ElTrigal ownedByElTrigal, Pedido pedido) {
        super(nombre, documentoIdentidad, codigoUnico, minutosDisp, ownedByElTrigal, pedido);
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

    public float getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(float duracionTotal) {
        this.duracionTotal = duracionTotal;
    }

    @Override
    public float calcularTiempo(TiposPan tiposPan, int cantidadPanes) {
        lote = (float) Math.ceil((double) cantidadPanes / 30.0);
        if (tiposPan.equals(TiposPan.TRADICIONAL)) {
            duracionTotal = preparacion + lote * 25;
        } else if (tiposPan.equals(TiposPan.INTEGRAL)) {
            duracionTotal = preparacion + lote * 35;
        }
        return duracionTotal;
    }
    }