package co.edu.uniquindio.poo.eltrigaljfx.model;

public class Pedido {
    private String codigo;
    protected Cliente propietario;
    protected TiposPan tipoPan;
    protected int cant_Disponible;
    protected EstadoPedido estadoPedido;

    public Pedido(String codigo, Cliente propietario, TiposPan tipoPan, int cant_Disponible, EstadoPedido estadoPedido) {
        this.codigo = codigo;
        this.propietario = propietario;
        this.tipoPan = tipoPan;
        this.cant_Disponible = cant_Disponible;
        this.estadoPedido = estadoPedido;
    }

    //getters, setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
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
}
