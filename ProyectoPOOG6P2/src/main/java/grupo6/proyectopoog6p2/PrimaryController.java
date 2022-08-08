/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo6.proyectopoog6p2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import grupo6.proyectopoog6p2.modelo.Persona;
import javafx.geometry.Pos;
import static javafx.scene.control.ContentDisplay.CENTER;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author mbravop
 */
public class PrimaryController {

    @FXML
    private Button btnClientes;
    @FXML
    private Button btnEmpleados;
    @FXML
    private Button btnServicios;
    @FXML
    private Button btnCitas;
    @FXML
    private Button btnAtenciones;
    @FXML
    private Button btnSalir;
    @FXML
    private FlowPane fpMenu;

    /**
     * Initializes the controller class.
     */
    
    public void initialize() {
        // TODO
    }
    
    @FXML
    private void iniciarClientes(){
        fpMenu.getChildren().clear();
        TableView<Persona> tabla = new TableView<>();
        VBox vCliente = new VBox();
        vCliente.setAlignment(Pos.CENTER);
        Button btnAgregarCliente = new Button("Agregar Cliente");
        
        TableColumn<Persona, String> colCedula = new TableColumn<>("Cédula");
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        
        TableColumn<Persona, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        
        TableColumn<Persona, String> colTelefono = new TableColumn<>("Telefono");
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        
        TableColumn<Persona, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        tabla.getColumns().addAll(colCedula,colNombre,colTelefono,colEmail);
        
        tabla.getItems().addAll(Persona.cargarPersonas(App.pathClientes));
        
        vCliente.getChildren().addAll(tabla,btnAgregarCliente);
        
        fpMenu.getChildren().add(vCliente);
    }
    
    @FXML
    private void iniciarEmpleados(){
        
    }
    
    @FXML
    private void iniciarServicios(){
        
    }
    
    @FXML
    private void iniciarCitas(){
        
    }
    @FXML
    private void iniciarAtenciones(){
        
    }
    @FXML
    private void iniciarSalir(){
        
    }
}
