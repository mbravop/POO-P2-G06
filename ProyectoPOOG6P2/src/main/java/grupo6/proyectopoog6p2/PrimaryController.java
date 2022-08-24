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
import javafx.application.Platform;
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
        aplicarEstilos(btnMenuCliente);
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
    private void iniciarServicios() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu.fxml"));//no tiene el controlador especificado
        fxmlLoader.setController(null);
        
        MenuServicioController msc = new MenuServicioController();
        fxmlLoader.setController(msc);
        Parent root = (Parent) fxmlLoader.load();
        
        //luego que el fxml ha sido cargado puedo utilizar el controlador para realizar cambios
        App.changeRoot(root);
    }

    @FXML
    private void iniciarCitas() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuCitas.fxml"));//no tiene el controlador especificado
        fxmlLoader.setController(null);
        
        MenuCitaController mcc = new MenuCitaController();
        fxmlLoader.setController(mcc);
        Parent root = (Parent) fxmlLoader.load();
        
        //luego que el fxml ha sido cargado puedo utilizar el controlador para realizar cambios
        App.changeRoot(root);
    }
    @FXML
    private void iniciarAtenciones() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuAtencion.fxml"));//no tiene el controlador especificado
        fxmlLoader.setController(null);
        
        MenuAtencionController mac = new MenuAtencionController();
        fxmlLoader.setController(mac);
        Parent root = (Parent) fxmlLoader.load();
        
        //luego que el fxml ha sido cargado puedo utilizar el controlador para realizar cambios
        App.changeRoot(root);
        
    }
    @FXML
    private void iniciarSalir(){
        Platform.exit();
    }
    
    public static void aplicarEstilos(Button btn){
        btn.getStyleClass().addAll("-fx-background-color:#3c7fb1;","linear-gradient(#fafdfe, #e8f5fc);",
                "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);",
                "-fx-background-insets: 0,1,2;",
                "-fx-background-radius: 3,2,1;",
                "-fx-padding: 3 30 3 30;",
                "-fx-text-fill: black;",
                "-fx-font-size: 14px);");
        
    }
}
