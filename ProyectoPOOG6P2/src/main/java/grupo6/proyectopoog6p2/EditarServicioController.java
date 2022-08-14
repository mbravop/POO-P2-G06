/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2;

import grupo6.proyectopoog6p2.modelo.Servicio;
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
public class EditarServicioController {
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
        lblAnadirPersona.setText("Editar Servicio");
        lblCedulaAnadir.setVisible(false);
        txtCedulaAnadir.setVisible(false);
        lblNombreAnadir.setText("Nombre del servicio");
        lblTelefonoAnadir.setText("Duracion en minutos");
        lblEmailAnadir.setText("Precio");
        lblDatosAnadir.setText("Activo? S/N");
    }
    
    public void llenarCampos(Servicio s){
        txtNombreAnadir.setEditable(false);
        txtNombreAnadir.setText(s.getNombreServicio());
        txtTelefonoAnadir.setText(String.valueOf(s.getDuracion()));
        txtEmailAnadir.setText(String.valueOf(s.getPrecio()));
        txtDatosAnadir.setEditable(false);
        txtDatosAnadir.setText(s.getEstado()); 
    }
    
    @FXML
    public void guardarAnadir() throws IOException{
        ArrayList<Servicio> servicios = Servicio.cargarServicios(App.pathServicios);
        boolean estado;
        if(txtDatosAnadir.getText().equals("S")){
            estado=true;
        }else{
            estado=false;
        }
        Servicio servicioNuevo = new Servicio(txtNombreAnadir.getText(),Integer.parseInt(txtTelefonoAnadir.getText()),Double.parseDouble(txtEmailAnadir.getText()),estado);
        for(Servicio s:servicios){
            if(s.getNombreServicio().equals(servicioNuevo.getNombreServicio())){
                s.setNombreServicio(txtNombreAnadir.getText());
                s.setDuracion(Integer.parseInt(txtTelefonoAnadir.getText()));
                s.setPrecio(Double.parseDouble(txtEmailAnadir.getText()));
                s.setEstado(txtDatosAnadir.getText());
            }
        }
        escribirArchivo(servicios);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText("Servicio editado exitosamente");
        alert.showAndWait();
        switchToMenu();
       
    }
    
    @FXML
    public void switchToMenu() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu.fxml"));//no tiene el controlador especificado
        fxmlLoader.setController(null);
        
        MenuServicioController msc = new MenuServicioController();
        fxmlLoader.setController(msc);
        Parent root = (Parent) fxmlLoader.load();
        
        //luego que el fxml ha sido cargado puedo utilizar el controlador para realizar cambios
        App.changeRoot(root);
    }
    
    public void escribirArchivo(ArrayList<Servicio> servicios){
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/resources/grupo6/proyectopoog6p2/files/listaServicios.csv",false));
            for(Servicio s:servicios){
                escritor.write(s.toString()+"\n");
            }
            escritor.close();
        }catch(IOException e){
            System.out.println("Error editando servicio");
        }
    }
}