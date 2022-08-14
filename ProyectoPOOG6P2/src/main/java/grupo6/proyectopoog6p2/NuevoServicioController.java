/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import grupo6.proyectopoog6p2.modelo.Servicio;

/**
 *
 * @author mbravop
 */

public class NuevoServicioController {
    @FXML
    private Label lblAnadirPersona;
    @FXML
    private Label lblCedulaAnadir;
    @FXML
    private Label lblNombreAnadir;
    @FXML
    private Label lblTelefonoAnadir;
    @FXML
    private Label lblEmailAnadir;
    @FXML
    private Label lblDatosAnadir;
    @FXML
    private TextField txtCedulaAnadir;
    @FXML
    private TextField txtNombreAnadir;
    @FXML
    private TextField txtTelefonoAnadir;
    @FXML
    private TextField txtEmailAnadir;
    @FXML
    private TextField txtDatosAnadir;
    @FXML
    private Button btnCancelarAnadir;
    @FXML
    private Button btnGuardarAnadir;
    
    public void initialize() {
        lblAnadirPersona.setText("Anadir Servicio");
        lblCedulaAnadir.setVisible(false);
        txtCedulaAnadir.setVisible(false);
        lblNombreAnadir.setText("Nombre del servicio");
        lblTelefonoAnadir.setText("Duracion en minutos");
        lblEmailAnadir.setText("Precio");
        lblDatosAnadir.setText("Activo? S/N");
    }
    
    
    @FXML
    private void switchToMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu.fxml"));
        fxmlLoader.setController(null);
        
        MenuServicioController msc = new MenuServicioController();
        fxmlLoader.setController(msc);
        Parent root = (Parent) fxmlLoader.load();
       
        App.changeRoot(root);
    }

    @FXML
    private void guardarAnadir() throws IOException{
        boolean estado;
        if(txtDatosAnadir.getText().equals("S")){
            estado=true;
        }else{
            estado=false;
        }
        Servicio servicioNuevo = new Servicio(txtNombreAnadir.getText(),Integer.parseInt(txtTelefonoAnadir.getText()),Double.parseDouble(txtEmailAnadir.getText()),estado);
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/resources/grupo6/proyectopoog6p2/files/listaServicios.csv",true));
            escritor.write(servicioNuevo.toString()+"\n");
            escritor.flush();
            escritor.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nuevo servicio agregado exitosamente");
            alert.showAndWait();
            
        }catch (Exception e){
            e.printStackTrace();
        }
        switchToMenu();
    }
}
