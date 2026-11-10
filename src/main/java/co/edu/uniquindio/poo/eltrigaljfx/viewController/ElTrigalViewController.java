package co.edu.uniquindio.poo.eltrigaljfx.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import co.edu.uniquindio.poo.eltrigaljfx.model.*;

import java.util.ArrayList;

public class ElTrigalViewController {

    @FXML private TextField txtCodigo;
    @FXML private ComboBox<TiposPan> cbTipoPan;
    @FXML private TextField txtCantidad;

    @FXML private TableView<Pedido> tblPedidos;
    @FXML private TableColumn<Pedido, String> colCodigo;
    @FXML private TableColumn<Pedido, TiposPan> colTipoPan;
    @FXML private TableColumn<Pedido, Integer> colCantidad;
    @FXML private TableColumn<Pedido, EstadoPedido> colEstado;
    @FXML private TableColumn<Pedido, String> colPanadero;

    private ElTrigal elTrigal;
    private ObservableList<Pedido> listaPedidosObservable;

    @FXML
    public void initialize() {

        elTrigal = new ElTrigal("El trigal", "10039", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        cbTipoPan.setItems(FXCollections.observableArrayList(TiposPan.values()));

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colTipoPan.setCellValueFactory(new PropertyValueFactory<>("tipoPan"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cant_Disponible"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoPedido"));
        colPanadero.setCellValueFactory(new PropertyValueFactory<>("codigoEmpleado"));

        refrescarTabla();
    }

    @FXML
    private void handleRegistrarPedido() {
        try {
            String codigo = txtCodigo.getText();
            TiposPan tipo = cbTipoPan.getValue();
            int cantidad = Integer.parseInt(txtCantidad.getText());

            Cliente cliente = new Cliente("Cliente 1", "001", elTrigal);
            Pedido nuevoPedido = new Pedido(codigo, cliente, tipo, cantidad, EstadoPedido.PENDIENTE, null, 0, elTrigal);

            elTrigal.registrarPedido(nuevoPedido);
            refrescarTabla();
            limpiarCampos();
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Pedido registrado exitosamente.");
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de Registro", e.getMessage());
        }
    }

    @FXML
    private void handleAsignarPedido() {
        Pedido seleccionado = tblPedidos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Atención", "Seleccione un pedido de la tabla.");
            return;
        }

        try {
            String mensaje = elTrigal.asignarPedido(seleccionado);
            refrescarTabla();
            mostrarAlerta(Alert.AlertType.INFORMATION, "Pedido Asignado", mensaje);
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de Asignación", e.getMessage());
        }
    }

    @FXML
    private void handleCancelarPedido() {
        Pedido seleccionado = tblPedidos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Atención", "Seleccione un pedido de la tabla.");
            return;
        }

        try {
            String mensaje = elTrigal.cancelarPedido(seleccionado);
            refrescarTabla();
            mostrarAlerta(Alert.AlertType.INFORMATION, "Pedido Cancelado", mensaje);
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de Cancelación", e.getMessage());
        }
    }

    private void refrescarTabla() {
        listaPedidosObservable = FXCollections.observableArrayList(elTrigal.getListaPedidos());
        tblPedidos.setItems(listaPedidosObservable);
        tblPedidos.refresh();
    }

    private void limpiarCampos() {
        txtCodigo.clear();
        txtCantidad.clear();
        cbTipoPan.setValue(null);
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}