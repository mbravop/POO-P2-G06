/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2;

import grupo6.proyectopoog6p2.modelo.Atencion;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MenuAtencionController {

    @FXML
    private TableColumn<Atencion, String> colCliente;

    @FXML
    private TableColumn<Atencion, Integer> colDuracion;

    @FXML
    private TableColumn<Atencion, String> colTerapeuta;
    @FXML
    private TableColumn<Atencion, String> colServicio;

    @FXML
    private TableColumn<Atencion, String> colFecha;

    @FXML
    private TextField txtFiltroBusqueda;

    @FXML
    private TableView<Atencion> tvAtenciones;

    @FXML
    void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    public void initialize() {
        colCliente.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        colTerapeuta.setCellValueFactory(new PropertyValueFactory<>("nombreEmpleado"));
        colServicio.setCellValueFactory(new PropertyValueFactory<>("nombreServicio"));
        colDuracion.setCellValueFactory(new PropertyValueFactory<>("tiempoAtencion"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaAtencion"));
        llenarTabla();
    }

    public void llenarTabla() {
        ArrayList<Atencion> atenciones = Atencion.cargarAtenciones(App.pathAtenciones);
        tvAtenciones.getItems().setAll(atenciones);
    }

    @FXML
    void buscarFiltro() {
        String filtro = txtFiltroBusqueda.getText();
        if (!filtro.isEmpty()) {
            ArrayList<Atencion> atencionFiltro = new ArrayList<>();
            for (Atencion a : Atencion.cargarAtenciones(App.pathAtenciones)) {
                if (a.getCita().obtenerCliente().getCedula().equals(txtFiltroBusqueda.getText()) || a.getCita().getFecha().equals(txtFiltroBusqueda.getText())) {
                    atencionFiltro.add(a);
                }
            }
            tvAtenciones.getItems().setAll(atencionFiltro);
        }
    }

    @FXML
    void cargarNuevo() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuAtencion.fxml"));
        fxmlLoader.setController(null);
        MenuAtencionController mac = new MenuAtencionController();
        fxmlLoader.setController(mac);
        Parent root = (Parent) fxmlLoader.load();
        App.changeRoot(root);
    }

}
