package co.edu.uniquindio.poo.eltrigaljfx.model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElTrigalTest {

    private ElTrigal elTrigal;

    @BeforeEach
    public void setUp() {
        elTrigal = new ElTrigal("El Trigal", "123456789", new java.util.ArrayList<>(), new java.util.LinkedList<>(),
                new java.util.ArrayList<>()
        );
    }
    // FUNCIONALIDAD 1: REGISTRAR UN PEDIDO
    @Test
    public void testRegistrarPedidoExitoso() {
        Cliente cliente = new Cliente("juan", "003", elTrigal);
        Pedido pedido = new Pedido("P01", cliente, TiposPan.TRADICIONAL, 25,
                EstadoPedido.PENDIENTE, null, 0, elTrigal);

        PanaderoArtesanal ana = new PanaderoArtesanal("ana", "1234",
                "101", 100, elTrigal, pedido);
        elTrigal.getListaEmpleados().add(ana);


        elTrigal.registrarPedido(pedido);

        Pedido pedidoRegistrado = elTrigal.getListaPedidos().get(0);
        assertEquals(EstadoPedido.PENDIENTE, pedidoRegistrado.getEstadoPedido());
        assertEquals(25, pedidoRegistrado.getCant_Disponible());
        assertEquals(100, ana.getMinutosDisp());
    }

    @Test
    public void testRegistrarPedidoCodigoDuplicadoDespuesDeCancelar() {
        Cliente cliente = new Cliente("juan", "003", elTrigal);
        Pedido pedido1 = new Pedido("P01", cliente, TiposPan.TRADICIONAL,
                25, EstadoPedido.PENDIENTE, null, 0, elTrigal);
        elTrigal.registrarPedido(pedido1);
        elTrigal.cancelarPedido(pedido1);

        Pedido pedido2 = new Pedido("P01", cliente, TiposPan.INTEGRAL,
                10, EstadoPedido.PENDIENTE, null, 0, elTrigal);

        assertThrows(IllegalArgumentException.class, () -> {
            elTrigal.registrarPedido(pedido2);
        });
        assertEquals(1, elTrigal.getListaPedidos().size());
        assertEquals(EstadoPedido.CANCELADO, elTrigal.getListaPedidos().get(0).getEstadoPedido());
    }

    @Test
    public void testRegistrarPedidoCantidadCeroHistorialVacio() {
        Cliente cliente = new Cliente("juan", "003", elTrigal);
        Pedido pedidoInvalido = new Pedido("P01", cliente, TiposPan.TRADICIONAL, 0,
                EstadoPedido.PENDIENTE, null, 0, elTrigal);

        assertThrows(IllegalArgumentException.class, () -> {
            elTrigal.registrarPedido(pedidoInvalido);
        });

        assertTrue(elTrigal.getListaPedidos().isEmpty());
    }
    // FUNCIONALIDAD 2: ASIGNAR UN PEDIDO
    @Test
    public void testAsignarPedidoSeleccionaMenorTiempo() {
        Cliente cliente = new Cliente("Cliente 1", "001", elTrigal);
        Pedido pedido = new Pedido("P01", cliente, TiposPan.TRADICIONAL,
                25, EstadoPedido.PENDIENTE, null, 0, elTrigal);
        PanaderoArtesanal ana = new PanaderoArtesanal("Ana", "101",
                "101", 100, elTrigal, pedido);
        PanaderoIndustrial carlos = new PanaderoIndustrial("Carlos", "102",
                "102", 45, elTrigal, pedido);

        elTrigal.getListaEmpleados().add(ana);
        elTrigal.getListaEmpleados().add(carlos);


        elTrigal.registrarPedido(pedido);

        elTrigal.asignarPedido(pedido);

        assertEquals(EstadoPedido.ASIGNADO, pedido.getEstadoPedido());
        assertEquals("102", pedido.getCodigoEmpleado());
        assertEquals(0, carlos.getMinutosDisp());
        assertEquals(100, ana.getMinutosDisp());
    }

    @Test
    public void testAsignarPedidoDesempatePorOrdenRegistro() {
        Cliente cliente = new Cliente("Cliente 1", "001", elTrigal);
        Pedido pedido = new Pedido("P01", cliente, TiposPan.INTEGRAL, 12, EstadoPedido.PENDIENTE,
                null, 0, elTrigal);
        PanaderoArtesanal ana = new PanaderoArtesanal("Ana", "101", "101",
                80, elTrigal, pedido);
        PanaderoArtesanal diana = new PanaderoArtesanal("Diana", "102", "102",
                80, elTrigal, pedido);
        PanaderoIndustrial carlos = new PanaderoIndustrial("Carlos", "103", "103",
                10, elTrigal, pedido);

        elTrigal.getListaEmpleados().add(ana);
        elTrigal.getListaEmpleados().add(diana);
        elTrigal.getListaEmpleados().add(carlos);

        elTrigal.registrarPedido(pedido);

        elTrigal.asignarPedido(pedido);

        assertEquals(EstadoPedido.ASIGNADO, pedido.getEstadoPedido());
        assertEquals("101", pedido.getCodigoEmpleado());
    }

    @Test
    public void testAsignarPedidoSinTiempoSuficiente() {
        Cliente cliente = new Cliente("Cliente 1", "001", elTrigal);

        Pedido pedido = new Pedido("P01", cliente, TiposPan.TRADICIONAL, 25,
                EstadoPedido.PENDIENTE, null, 0, elTrigal);
        PanaderoIndustrial carlos = new PanaderoIndustrial("Carlos", "101", "101", 44, elTrigal, null);
        Cajero lucia = new Cajero("Lucía", "102", "102", 120, elTrigal, pedido);

        elTrigal.getListaEmpleados().add(carlos);
        elTrigal.getListaEmpleados().add(lucia);

        elTrigal.registrarPedido(pedido);

        assertThrows(IllegalStateException.class, () -> {
            elTrigal.asignarPedido(pedido);
        });

        assertEquals(EstadoPedido.PENDIENTE, pedido.getEstadoPedido());
        assertEquals(44, carlos.getMinutosDisp());
        assertEquals(120, lucia.getMinutosDisp());
    }

    // FUNCIONALIDAD 3: CANCELAR UN PEDIDO
    @Test
    public void testCancelarPedidoAsignadoDevuelveMinutos() {
        PanaderoIndustrial carlos = new PanaderoIndustrial("Carlos", "101",
                "101", 120, elTrigal, null);
        elTrigal.getListaEmpleados().add(carlos);

        Cliente cliente = new Cliente("Cliente 1", "001", elTrigal);
        Pedido pedido1 = new Pedido("P01", cliente, TiposPan.TRADICIONAL, 25,
                EstadoPedido.PENDIENTE, null, 0, elTrigal);
        Pedido pedido2 = new Pedido("P02", cliente, TiposPan.TRADICIONAL, 25,
                EstadoPedido.PENDIENTE, null, 0, elTrigal);

        elTrigal.registrarPedido(pedido1);
        elTrigal.registrarPedido(pedido2);

        elTrigal.asignarPedido(pedido1);
        elTrigal.asignarPedido(pedido2);

        elTrigal.cancelarPedido(pedido1);

        assertEquals(75, carlos.getMinutosDisp());
        assertEquals(EstadoPedido.CANCELADO, pedido1.getEstadoPedido());
        assertEquals(EstadoPedido.ASIGNADO, pedido2.getEstadoPedido());
    }

    @Test
    public void testCancelarPedidoPendienteConservaMinutos() {
        Cliente cliente = new Cliente("Cliente 1", "001", elTrigal);
        Pedido pedido = new Pedido("P01", cliente, TiposPan.TRADICIONAL, 10, EstadoPedido.PENDIENTE, null, 0, elTrigal);
        PanaderoArtesanal panadero = new PanaderoArtesanal("Panadero", "101",
                "101", 100, elTrigal, pedido);
        elTrigal.getListaEmpleados().add(panadero);


        elTrigal.registrarPedido(pedido);

        elTrigal.cancelarPedido(pedido);

        assertEquals(EstadoPedido.CANCELADO, pedido.getEstadoPedido());
        assertEquals(100, panadero.getMinutosDisp());
        assertEquals(1, elTrigal.getListaPedidos().size());
    }

    @Test
    public void testCancelarPedidoYaCanceladoLanzaExcepcion() {
        Cliente cliente = new Cliente("Cliente 1", "001", elTrigal);
        Pedido pedido = new Pedido("P01", cliente, TiposPan.TRADICIONAL, 12, EstadoPedido.PENDIENTE, null, 0, elTrigal);
        PanaderoArtesanal panadero = new PanaderoArtesanal("Panadero",
                "101", "101", 100, elTrigal, pedido);
        elTrigal.getListaEmpleados().add(panadero);


        elTrigal.registrarPedido(pedido);

        elTrigal.asignarPedido(pedido);
        elTrigal.cancelarPedido(pedido);

        assertThrows(IllegalStateException.class, () -> {
            elTrigal.cancelarPedido(pedido);
        });
    }
}
