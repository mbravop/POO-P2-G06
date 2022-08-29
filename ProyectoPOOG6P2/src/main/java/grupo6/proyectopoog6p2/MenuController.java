/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import grupo6.proyectopoog6p2.modelo.Cliente;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author mbravop
 */
public class MenuController {
    
    
    @FXML
    private TableView<Cliente> tvListado;
    @FXML
    private Label lblLista;
    @FXML
    private Button btnAnadir;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnEliminar;
    
    @FXML
    private VBox vMenu;
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        btnEliminar.setDisable(true);
        TableColumn<Cliente, String> colCedula = new TableColumn<>("Cédula");
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        
        TableColumn<Cliente, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        
        TableColumn<Cliente, String> colTelefono = new TableColumn<>("Teléfono");
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        
        TableColumn<Cliente, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tvListado.getColumns().addAll(colCedula,colNombre,colTelefono,colEmail);
        tvListado.setColumnResizePolicy(tvListado.CONSTRAINED_RESIZE_POLICY);
        llenarTabla();
     
    }
    
    public void llenarTabla() {
        tvListado.getItems().addAll(Cliente.cargarClientes(App.pathClientes));
    }
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void anadirPersona() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("nuevo.fxml"));
        fxmlLoader.setController(null);
        NuevoController nc = new NuevoController();
        fxmlLoader.setController(nc);
        Parent root = (Parent) fxmlLoader.load();
        App.changeRoot(root);
    }

    @FXML
    private void editarPersona()throws IOException {
        Cliente c = (Cliente) tvListado.getSelectionModel().getSelectedItem();
        if(c==null){
            Alert alerta= new Alert(Alert.AlertType.WARNING);
            alerta.setContentText("Por favor seleccione un cliente ");
            alerta.showAndWait();
        }else{
           FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("nuevo.fxml"));//no tiene el controlador especificado
            fxmlLoader.setController(null);
            EditarController ec = new EditarController();

            fxmlLoader.setController(ec);//se asigna el controlador

            VBox root = (VBox) fxmlLoader.load();
            ec.llenarCampos(c);
            App.changeRoot(root); 
        }
        
    }
    @FXML
    private void eliminarPersona(){
        
    }
}
