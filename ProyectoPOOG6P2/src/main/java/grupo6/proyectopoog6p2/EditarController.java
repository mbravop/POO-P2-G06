/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2;

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
import javafx.scene.layout.VBox;
import grupo6.proyectopoog6p2.modelo.Cliente;

/**
 *
 * @author mbravop
 */
public class EditarController {
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
    
    public void llenarCampos(Cliente c){
        lblAnadirPersona.setText("Editar Cliente");
        txtCedulaAnadir.setEditable(false);
        txtCedulaAnadir.setText(c.getCedula());
        txtNombreAnadir.setText(c.getNombre());
        txtTelefonoAnadir.setText(c.getTelefono());
        txtEmailAnadir.setText(c.getEmail());
        txtDatosAnadir.setText(c.getDatosRepresentante());
        
    }
    
    @FXML
    public void guardarAnadir() throws IOException{
        ArrayList<Cliente> clientes = Cliente.cargarClientes(App.pathClientes);
        Cliente clienteNuevo = new Cliente(txtDatosAnadir.getText(),txtCedulaAnadir.getText(),txtNombreAnadir.getText(),txtTelefonoAnadir.getText(),txtEmailAnadir.getText());
        for(Cliente c:clientes){
            if(c.getCedula().equals(clienteNuevo.getCedula())){
                c.setNombre(txtNombreAnadir.getText());
                c.setTelefono(txtTelefonoAnadir.getText());
                c.setEmail(txtEmailAnadir.getText());
                c.setDatosRepresentante(txtDatosAnadir.getText());
            }
        }
        escribirArchivo(clientes);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText("Persona editada exitosamente");
        alert.showAndWait();
        switchToMenu();
       
    }
    
    @FXML
    public void switchToMenu() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu.fxml"));//no tiene el controlador especificado
        fxmlLoader.setController(null);
        
        MenuController mc = new MenuController();
        fxmlLoader.setController(mc);
        Parent root = (Parent) fxmlLoader.load();
        
        //luego que el fxml ha sido cargado puedo utilizar el controlador para realizar cambios
        App.changeRoot(root);
    }
    
    public void escribirArchivo(ArrayList<Cliente> clientes){
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/resources/grupo6/proyectopoog6p2/files/listaClientes.csv",false));
            for(Cliente c:clientes){
                escritor.write(c.toString()+"\n");
            }
            escritor.close();
        }catch(IOException e){
            System.out.println("Error editando cliente");
        }
    }
    
    
}
