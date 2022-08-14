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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableView<Atencion> tvAtenciones;

    @FXML
    void switchToPrimary() throws IOException{
        App.setRoot("primary");
    }
    
    public void initialize(){
        colCliente.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        colTerapeuta.setCellValueFactory(new PropertyValueFactory<>("nombreEmpleado"));
        colServicio.setCellValueFactory(new PropertyValueFactory<>("nombreServicio"));
        colDuracion.setCellValueFactory(new PropertyValueFactory<>("tiempoAtencion"));
        llenarTabla();
    }
    
    public void llenarTabla(){
        ArrayList<Atencion> atenciones = Atencion.cargarAtenciones(App.pathAtenciones);
        tvAtenciones.getItems().setAll(atenciones);
    }

}
