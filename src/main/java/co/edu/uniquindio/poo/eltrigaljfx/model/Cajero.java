package co.edu.uniquindio.poo.eltrigaljfx.model;

public class Cajero extends Empleado {

    protected boolean cajaAsignada;

    public Cajero(String nombre, String documentoIdentidad, String codigoUnico, int minutosDisp,
                  ElTrigal ownedByElTrigal, Pedido pedido) {
        super(nombre, documentoIdentidad, codigoUnico, minutosDisp, ownedByElTrigal, pedido);
    }


    //getter, setter
    public boolean isCajaAsignada() {
        return cajaAsignada;
    }

    public void setCajaAsignada(boolean cajaAsignada) {
        this.cajaAsignada = cajaAsignada;
    }

    @Override
    public float calcularTiempo(TiposPan tipoPan, int cantidadPanes) {
        return -1; // Retorna -1 porque los cajeros no producen
    }
}
