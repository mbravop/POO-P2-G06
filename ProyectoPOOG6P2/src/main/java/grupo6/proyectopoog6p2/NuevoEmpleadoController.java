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
import grupo6.proyectopoog6p2.modelo.Empleado;

/**
 *
 * @author mbravop
 */

public class NuevoEmpleadoController {
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
        lblAnadirPersona.setText("Anadir Empleado");
        lblDatosAnadir.setText("Activo? S/N");
    }
    
    
    @FXML
    private void switchToMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu.fxml"));
        fxmlLoader.setController(null);
        
        MenuEmpleadoController mec = new MenuEmpleadoController();
        fxmlLoader.setController(mec);
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
        Empleado empleadoNuevo = new Empleado(txtCedulaAnadir.getText(),txtNombreAnadir.getText(),txtTelefonoAnadir.getText(),txtEmailAnadir.getText(),estado);
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter("/Users/mbravop03/Desktop/ESPOL/Segundo Semestre/POO/Proyecto POO - Grupo 6/POO-P2-G06/ProyectoPOOG6P2/src/main/resources/grupo6/proyectopoog6p2/files/listaEmpleados.csv",true));
            escritor.write(empleadoNuevo.toString()+"\n");
            escritor.flush();
            escritor.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nuevo empleado agregado exitosamente");
            alert.showAndWait();
            
        }catch (Exception e){
            e.printStackTrace();
        }
        switchToMenu();
    }
}
