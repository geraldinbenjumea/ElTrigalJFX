package co.edu.uniquindio.poo.eltrigaljfx.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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

    //                            --------------CRUD Cliente----------
    public String registrarCliente(Cliente cliente){
        Optional<Cliente> encontrado = buscarCliente(cliente.getDocumentoIdentidad());
        if(encontrado.isPresent()){
            return "El cliente ya se encuentra registrado";
        }else{
            listaClientes.add(cliente);
            return "Registrado exitosamente";
        }
    }
    public Optional<Cliente>buscarCliente(String documentoIdentidad){
        return listaClientes.stream().
                filter(cliente -> cliente.getDocumentoIdentidad().equals(documentoIdentidad)).findFirst();
    }

    public String actualizarCliente (Cliente cliente, String documentoIdentidad, String nuevoNombre,
                                     String documentoIdentidadNuevo){
        if(cliente.getDocumentoIdentidad().equals(documentoIdentidad)){
        cliente.setDocumentoIdentidad(documentoIdentidadNuevo);
        cliente.setNombre(nuevoNombre);
        return "Cliente actualizado exitosamente";
        }
        return "Los datos no coinciden";
        }

    public String eliminarCliente(Cliente cliente){
        Optional<Cliente> encontrado = buscarCliente(cliente.getDocumentoIdentidad());
        if(encontrado.isPresent()){
            listaClientes.remove(encontrado);
            return "Cliente eliminado";
        }else{
            return "No se pudo eliminar, vuelvalo a intentar";
        }
    }

    //                                ----------------CRUD Pedido----------------

    public Optional<Pedido>buscarPedido(String codigo){
        return listaPedidos.stream().
                filter(pedido -> pedido.getCodigo().equals(codigo)).findFirst();
    }
    public String eliminarPedido(Pedido pedido){
        Optional<Pedido> encontrado = buscarPedido(pedido.getCodigo());
        if(encontrado.isPresent()){
            listaPedidos.remove(encontrado);
            return "pedido eliminado";
        }else{
            return "No se pudo eliminar, vuelvalo a intentar";
        }
    }

    //Metodos
    //1.registrar un pedido
    public String registrarPedido (Pedido pedido){     //Parte create del CRUD, más completa
        pedido.getEstadoPedido().equals(EstadoPedido.PENDIENTE);
        if(pedido.cant_Disponible<=0){
            throw new IllegalArgumentException("La cantidad de panes debe ser mayor a cero.");
        }
        if(buscarPedido(pedido.getCodigo()).isPresent()){
            throw new IllegalArgumentException("El código de pedido ya existe en el historial.");
        }
        listaPedidos.add(pedido);
        return "Pedido registrado";
    }

    //2. Asignar pedido a produccion
    public String asignarPedido (Pedido pedido) {  //actualizar pedido
        if (pedido.getEstadoPedido() != EstadoPedido.PENDIENTE) {
            throw new IllegalStateException("El pedido no está PENDIENTE. Estado actual: " + pedido.getEstadoPedido());
        }
        if (!buscarPedido(pedido.getCodigo()).isPresent()) {
            throw new IllegalArgumentException("El pedido no existe");
        }
        Empleado mejorPanadero = listaEmpleados.stream()
                .filter(e -> {
                    float tiempo = e.calcularTiempo(pedido.getTipoPan(), pedido.getCant_Disponible());
                    return tiempo > 0 && e.getMinutosDisp() >= tiempo;
                })
                .min((e1, e2) -> Float.compare(
                        e1.calcularTiempo(pedido.getTipoPan(), pedido.getCant_Disponible()),
                        e2.calcularTiempo(pedido.getTipoPan(), pedido.getCant_Disponible())
                ))
                .orElseThrow(() -> new IllegalStateException
                        ("Ningún panadero dispone de tiempo suficiente para atender el pedido."));
        float tiempoRequerido = mejorPanadero.calcularTiempo(pedido.getTipoPan(), pedido.getCant_Disponible());
        pedido.setMinutosReservados(tiempoRequerido);
        mejorPanadero.setMinutosDisp(mejorPanadero.getMinutosDisp() - tiempoRequerido);
        pedido.setCodigoEmpleado(mejorPanadero.getCodigoUnico());
        pedido.setEstadoPedido(EstadoPedido.ASIGNADO);
        return "Se ha asignado al panadero: "+mejorPanadero;
    }

    //3. cancelar un pedido
    public String cancelarPedido(Pedido pedido){
    if(pedido.getEstadoPedido().equals(EstadoPedido.PENDIENTE)){
        pedido.setEstadoPedido(EstadoPedido.CANCELADO);
        return "El pedido ha pasado de pendiente a cancelado";
    }
    if(pedido.getEstadoPedido().equals(EstadoPedido.ASIGNADO)){
        pedido.setEstadoPedido(EstadoPedido.CANCELADO);
        listaEmpleados.stream()
                .filter(e -> e.getCodigoUnico().equals(pedido.getCodigoEmpleado()))
                .findFirst()
                .ifPresent(e -> e.devolverMinutos(pedido.getMinutosReservados()));
        return "El pedido ha pasado de asignado a cancelado";
    }
    if(pedido.getEstadoPedido().equals(EstadoPedido.CANCELADO)){
            throw new IllegalStateException("El pedido ya se encuentra cancelado.");
        }
        Optional<Pedido> encontrado = buscarPedido(pedido.getCodigo());
    if(!encontrado.isPresent()){
        throw new IllegalArgumentException("El pedido no existe.");
    }
    return "Pedido cancelado con exito";
    }

}
