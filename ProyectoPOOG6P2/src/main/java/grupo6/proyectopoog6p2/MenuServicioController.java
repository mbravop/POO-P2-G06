/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import grupo6.proyectopoog6p2.modelo.Servicio;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;



public class MenuServicioController {
    @FXML
    private TableView<Servicio> tvListado;
    @FXML
    private Label lblLista;
    @FXML
    private Button btnAnadir;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnEliminar;
    
    public void initialize(){
        lblLista.setText("L I S T A  D E  S E R V I C I O S");
        lblLista.autosize();
        
        TableColumn<Servicio, String> colCedula = new TableColumn<>("Nombre");
        colCedula.setCellValueFactory(new PropertyValueFactory<>("nombreServicio"));
        
        TableColumn<Servicio, Integer> colNombre = new TableColumn<>("Duracion");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        
        TableColumn<Servicio, Double> colTelefono = new TableColumn<>("Precio");
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("precio"));
        
        TableColumn<Servicio, Boolean> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        
        tvListado.getColumns().addAll(colCedula,colNombre,colTelefono,colEstado);
        llenarTabla();
    }
    
    public void llenarTabla(){
        tvListado.getItems().addAll(Servicio.cargarServicios("grupo6/proyectopoog6p2/files/listaServicios.csv"));
    }
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void anadirPersona() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("nuevo.fxml"));
        fxmlLoader.setController(null);
        NuevoServicioController nsc = new NuevoServicioController();
        fxmlLoader.setController(nsc);
        Parent root = (Parent) fxmlLoader.load();
        App.changeRoot(root);
    }
    
    @FXML
    private void editarPersona()throws IOException {
        Servicio s = (Servicio) tvListado.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("nuevo.fxml"));
        fxmlLoader.setController(null);
        EditarServicioController nsc = new EditarServicioController();
        fxmlLoader.setController(nsc);
        Parent root = (Parent) fxmlLoader.load();
        nsc.llenarCampos(s);
        App.changeRoot(root);
    }
    
    @FXML
    private void eliminarPersona()throws IOException {
        
    }
}
