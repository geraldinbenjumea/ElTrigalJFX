package co.edu.uniquindio.poo.eltrigaljfx.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Trabajo Parcial 3 P1
 * author: Geraldin Benjumea/Area de programación
 * fecha: 6/11/2026
 * GNU GPL V3
 */

public class ElTrigal {

    protected String nombre;
    private String NIT;
    protected List<Cliente> listaClientes= new ArrayList<>();
    protected List<Empleado> listaEmpleados= new LinkedList<>();
    private List<Pedido> listaPedidos= new ArrayList<>();

    public ElTrigal(String nombre, String NIT, List<Cliente> listaClientes, List<Empleado> listaEmpleados, List<Pedido> listaPedidos) {
        this.nombre = nombre;
        this.NIT = NIT;
        this.listaClientes = listaClientes;
        this.listaEmpleados = listaEmpleados;
        this.listaPedidos = listaPedidos;
    }
    //getter, setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
}
