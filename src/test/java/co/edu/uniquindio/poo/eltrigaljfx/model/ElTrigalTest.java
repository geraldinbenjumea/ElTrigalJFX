package co.edu.uniquindio.poo.eltrigaljfx.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElTrigalTest {

    private ElTrigal elTrigal;
    @BeforeEach
    public void setUp() {
        elTrigal= new ElTrigal("El Trigal", "123456789",
                new java.util.ArrayList<>(), new java.util.LinkedList<>(), new java.util.ArrayList<>());
    }
    //------PRUEBAS DE REGISTRAR------
    @Test
    public void testRegistrarPedidoExitoso() {

        PanaderoArtesanal ana = new PanaderoArtesanal("ana", "1234",
                "101", 100, elTrigal, null);
        elTrigal.getListaEmpleados().add(ana);

        Cliente cliente = new Cliente("juan","003", elTrigal);

        Pedido nuevoPedido= new Pedido("P01", cliente,
                TiposPan.TRADICIONAL, 25, EstadoPedido.PENDIENTE, "#01", 120, elTrigal);

        elTrigal.registrarPedido(nuevoPedido);

        Pedido pedido = elTrigal.getListaPedidos().get(0);
        assertEquals(EstadoPedido.PENDIENTE, pedido.getEstadoPedido());
        assertEquals(25, pedido.getCant_Disponible());
        assertEquals(100, ana.getMinutosDisp());
    }

}