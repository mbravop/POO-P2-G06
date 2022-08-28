/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2;

import grupo6.proyectopoog6p2.modelo.Actividad;
import grupo6.proyectopoog6p2.modelo.Atencion;
import grupo6.proyectopoog6p2.modelo.Cita;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author mbravop
 */
public class MenuActividadController {
    @FXML
    private TableColumn<Actividad,String> colActividad;

    @FXML
    private TableColumn<Actividad,String> colCliente;

    @FXML
    private TableColumn<Actividad,String> colFallos;

    @FXML
    private TableColumn<Actividad,String> colFecha;

    @FXML
    private TableColumn<Actividad,String> colTiempo;
    
    @FXML
    private TableView<Actividad> tvActividades;
    
    public void initialize() {
        colActividad.setCellValueFactory(new PropertyValueFactory<>("actividad"));
        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colFallos.setCellValueFactory(new PropertyValueFactory<>("fallos"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempo"));
        llenarTabla();
        tvActividades.setColumnResizePolicy(tvActividades.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    public void llenarTabla() {
        ArrayList<Actividad> actividades = Actividad.cargarActividades(App.pathActividades);
        tvActividades.getItems().setAll(actividades);
        
    }

    @FXML
    void switchToMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuCitas.fxml"));
        fxmlLoader.setController(null);

        MenuCitaController msc = new MenuCitaController();
        fxmlLoader.setController(msc);
        Parent root = (Parent) fxmlLoader.load();

        App.changeRoot(root);
    }
}
