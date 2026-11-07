package co.edu.uniquindio.poo.eltrigaljfx.model;

public class PanaderoArtesanal extends Empleado {

    protected float bandejas;
    protected float duracion;

    public PanaderoArtesanal(String nombre, String documentoIdentidad, String codigoUnico, int minutosDisp,
                             ElTrigal ownedByElTrigal, Pedido pedido) {
        super(nombre, documentoIdentidad, codigoUnico, minutosDisp, ownedByElTrigal, pedido);
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
    public float calcularTiempo(TiposPan tiposPan, int cantidadPanes) {
        bandejas = (float) Math.ceil((double) cantidadPanes / 12.0);
        duracion=0;
        if (tiposPan.equals(TiposPan.TRADICIONAL)) {
            duracion = duracion + bandejas * 30;
        } else if (tiposPan.equals(TiposPan.INTEGRAL)) {
            duracion = duracion + bandejas * 40;
        }
        return duracion;
    }
}
