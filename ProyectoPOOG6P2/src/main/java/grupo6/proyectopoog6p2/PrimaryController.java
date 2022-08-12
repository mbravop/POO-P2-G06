/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo6.proyectopoog6p2;

import grupo6.proyectopoog6p2.modelo.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import grupo6.proyectopoog6p2.modelo.Persona;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import static javafx.scene.control.ContentDisplay.CENTER;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author mbravop
 */
public class PrimaryController {

    @FXML
    private Button btnMenuCliente;
    @FXML
    private Button btnMenuEmpleados;
    @FXML
    private Button btnMenuServicios;
    @FXML
    private Button btnMenuCitas;
    @FXML
    private Button btnMenuAtenciones;
    @FXML
    private Button btnMenuSalir;
    @FXML
    private FlowPane fpInicial;

    /**
     * Initializes the controller class.
     */
    
    public void initialize() {
        // TODO
    }
    
    @FXML
    private void iniciarClientes() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu.fxml"));
        fxmlLoader.setController(null);
        
        MenuController mc = new MenuController();
        fxmlLoader.setController(mc);
        
        Parent root = (Parent) fxmlLoader.load();
        
        App.changeRoot(root);
    }
    
    @FXML
    private void iniciarEmpleados() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu.fxml"));
        fxmlLoader.setController(null);
        
        MenuEmpleadoController mec = new MenuEmpleadoController();
        fxmlLoader.setController(mec);
        
        Parent root = (Parent) fxmlLoader.load();
        
        App.changeRoot(root);
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
