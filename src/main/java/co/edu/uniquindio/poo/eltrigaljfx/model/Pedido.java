package co.edu.uniquindio.poo.eltrigaljfx.model;

public class Pedido {
    private String codigo;
    protected Cliente propietario;
    protected TiposPan tipoPan;
    protected int cant_Disponible;
    protected EstadoPedido estadoPedido;
    protected String codigoEmpleado;
    protected float minutosReservados;
    private ElTrigal ownedByElTrigal;

    public Pedido(String codigo, Cliente propietario, TiposPan tipoPan, int cant_Disponible,
                  EstadoPedido estadoPedido, String codigoEmpleado, float minutosReservados, ElTrigal ownedByElTrigal) {
        this.codigo = codigo;
        this.propietario = propietario;
        this.tipoPan = tipoPan;
        this.cant_Disponible = cant_Disponible;
        this.estadoPedido = estadoPedido;
        this.codigoEmpleado=codigoEmpleado;
        this.minutosReservados=minutosReservados;
        this.ownedByElTrigal = ownedByElTrigal;
    }
    //getters, setters
    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TiposPan getTipoPan() {
        return tipoPan;
    }

    public void setTipoPan(TiposPan tipoPan) {
        this.tipoPan = tipoPan;
    }

    public int getCant_Disponible() {
        return cant_Disponible;
    }

    public void setCant_Disponible(int cant_Disponible) {
        this.cant_Disponible = cant_Disponible;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public float getMinutosReservados() {
        return minutosReservados;
    }

    public void setMinutosReservados(float minutosReservados) {
        this.minutosReservados = minutosReservados;
    }

    public ElTrigal getOwnedByElTrigal() {
        return ownedByElTrigal;
    }

    public void setOwnedByElTrigal(ElTrigal ownedByElTrigal) {
        this.ownedByElTrigal = ownedByElTrigal;
    }
}

