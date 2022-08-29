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
        lblDatosAnadir.setText("Activo?");
        txtDatosAnadir.setPromptText("S/N");
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
        String cedulaAnadir= txtCedulaAnadir.getText();
        String nombreAnadir= txtNombreAnadir.getText();
        String telefonoAnadir= txtTelefonoAnadir.getText();
        String emailAnadir= txtEmailAnadir.getText();
        if((txtCedulaAnadir.getText().isEmpty() || txtNombreAnadir.getText().isEmpty() || txtTelefonoAnadir.getText().isEmpty() || txtEmailAnadir.getText().isEmpty())){
            Alert alerta= new Alert(Alert.AlertType.WARNING);
            alerta.setContentText("Por favor llene todos los campos ");
            alerta.showAndWait();
        }else{
            boolean estado = txtDatosAnadir.getText().equals("S");
            Empleado empleadoNuevo = new Empleado(cedulaAnadir,nombreAnadir,telefonoAnadir,emailAnadir,estado);
            try{
                BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/resources/grupo6/proyectopoog6p2/files/listaEmpleados.csv",true));
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
}
