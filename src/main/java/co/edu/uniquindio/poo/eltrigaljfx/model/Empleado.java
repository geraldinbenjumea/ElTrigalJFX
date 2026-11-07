package co.edu.uniquindio.poo.eltrigaljfx.model;

public abstract class Empleado {
    protected String nombre;
    protected String documentoIdentidad;
    protected String codigoUnico;
    protected int minutosDisp;
    private ElTrigal ownedByElTrigal;
    protected Pedido pedido;

    public Empleado(String nombre, String documentoIdentidad, String codigoUnico,
                    int minutosDisp, ElTrigal ownedByElTrigal, Pedido pedido) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.codigoUnico = codigoUnico;
        this.minutosDisp = minutosDisp;
        this.ownedByElTrigal = ownedByElTrigal;
        this.pedido = pedido;
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

    public ElTrigal getOwnedByElTrigal() {
        return ownedByElTrigal;
    }

    public void setOwnedByElTrigal(ElTrigal ownedByElTrigal) {
        this.ownedByElTrigal = ownedByElTrigal;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    //metodo abstracto
    public abstract float calcularTiempo(TiposPan tiposPan, int cantidadPanes);
    public void devolverMinutos(float minutos) {
        this.minutosDisp += minutos;
    }

}
