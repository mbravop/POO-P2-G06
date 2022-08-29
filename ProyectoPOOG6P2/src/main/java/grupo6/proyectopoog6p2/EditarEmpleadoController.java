/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2;

import grupo6.proyectopoog6p2.modelo.Empleado;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 *
 * @author mbravop
 */
public class EditarEmpleadoController {
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
        lblDatosAnadir.setText("Activo? S/N");
    }
    
    public void llenarCampos(Empleado e){
        lblAnadirPersona.setText("Editar Empleado");
        txtCedulaAnadir.setEditable(false);
        txtCedulaAnadir.setText(e.getCedula());
        txtNombreAnadir.setText(e.getNombre());
        txtTelefonoAnadir.setText(e.getTelefono());
        txtEmailAnadir.setText(e.getEmail());
        txtDatosAnadir.setEditable(false);
        txtDatosAnadir.setText(e.getEstado()); 
        
    }
    
    @FXML
    public void guardarAnadir() throws IOException{
        ArrayList<Empleado> empleados = Empleado.cargarEmpleados(App.pathEmpleados);
        boolean estado = txtDatosAnadir.getText().equals("S");
        Empleado empleadoNuevo = new Empleado(txtCedulaAnadir.getText(),txtNombreAnadir.getText(),txtTelefonoAnadir.getText(),txtEmailAnadir.getText(),estado);
        for(Empleado e:empleados){
            if(e.getCedula().equals(empleadoNuevo.getCedula())){
                e.setNombre(txtNombreAnadir.getText());
                e.setTelefono(txtTelefonoAnadir.getText());
                e.setEmail(txtEmailAnadir.getText());
                e.setEstado(txtDatosAnadir.getText());
            }
        }
        escribirArchivo(empleados);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText("Empleado editado exitosamente");
        alert.showAndWait();
        switchToMenu();
       
    }
    
    @FXML
    public void switchToMenu() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu.fxml"));//no tiene el controlador especificado
        fxmlLoader.setController(null);
        
        MenuEmpleadoController mec = new MenuEmpleadoController();
        fxmlLoader.setController(mec);
        Parent root = (Parent) fxmlLoader.load();
        
        //luego que el fxml ha sido cargado puedo utilizar el controlador para realizar cambios
        App.changeRoot(root);
    }
    
    public void escribirArchivo(ArrayList<Empleado> empleados){
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/resources/grupo6/proyectopoog6p2/files/listaEmpleados.csv",false));
            for(Empleado e:empleados){
                escritor.write(e.toString()+"\n");
            }
            escritor.close();
        }catch(IOException e){
            System.out.println("Error editando empleado");
        }
    }
}
