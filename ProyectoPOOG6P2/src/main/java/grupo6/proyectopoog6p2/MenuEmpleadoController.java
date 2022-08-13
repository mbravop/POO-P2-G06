/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2;

import grupo6.proyectopoog6p2.modelo.Cliente;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import grupo6.proyectopoog6p2.modelo.Empleado;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;

/**
 *
 * @author mbravop
 */
public class MenuEmpleadoController {
    @FXML
    private TableView<Empleado> tvListado;
    @FXML
    private Label lblLista;
    @FXML
    private Button btnAnadir;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnEliminar;
    
    public void initialize(){
        lblLista.setText("L I S T A  D E  E M P L E A D O S");
        lblLista.autosize();
        TableColumn<Empleado, String> colCedula = new TableColumn<>("Cédula");
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        
        TableColumn<Empleado, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        
        TableColumn<Empleado, String> colTelefono = new TableColumn<>("Teléfono");
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        
        TableColumn<Empleado, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        TableColumn<Empleado, Boolean> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tvListado.getColumns().addAll(colCedula,colNombre,colTelefono,colEmail,colEstado);
        llenarTabla();
    }
    
    public void llenarTabla(){
        tvListado.getItems().addAll(Empleado.cargarEmpleados("grupo6/proyectopoog6p2/files/listaEmpleados.csv"));
    }
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void anadirPersona() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("nuevo.fxml"));
        fxmlLoader.setController(null);
        NuevoEmpleadoController nec = new NuevoEmpleadoController();
        fxmlLoader.setController(nec);
        Parent root = (Parent) fxmlLoader.load();
        App.changeRoot(root);
    }
    
    @FXML
    private void editarPersona()throws IOException {
        Empleado e = (Empleado) tvListado.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("nuevo.fxml"));//no tiene el controlador especificado
        fxmlLoader.setController(null);
        EditarEmpleadoController eec = new EditarEmpleadoController();

        fxmlLoader.setController(eec);//se asigna el controlador

        Parent root = (Parent) fxmlLoader.load();
        eec.llenarCampos(e);
        App.changeRoot(root);
    }
    
    @FXML
    private void eliminarPersona()throws IOException {
        ArrayList<Empleado> empleados = Empleado.cargarEmpleados("grupo6/proyectopoog6p2/files/listaEmpleados.csv");
        Empleado empleadoSeleccionado = (Empleado) tvListado.getSelectionModel().getSelectedItem();
        for(Empleado e:empleados){
            if(e.getCedula().equals(empleadoSeleccionado.getCedula())){
                e.setEstado("N");
            }
        }
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter("/Users/mbravop03/Desktop/ESPOL/Segundo Semestre/POO/Proyecto POO - Grupo 6/POO-P2-G06/ProyectoPOOG6P2/src/main/resources/grupo6/proyectopoog6p2/files/listaEmpleados.csv",false));
            for(Empleado e:empleados){
                escritor.write(e.toString()+"\n");
            }
            escritor.close();
        }catch(IOException e){
            System.out.println("Error eliminando empleado");
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText("Empleado eliminado exitosamente");
        alert.showAndWait();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu.fxml"));//no tiene el controlador especificado
        fxmlLoader.setController(null);
        
        MenuEmpleadoController mec = new MenuEmpleadoController();
        fxmlLoader.setController(mec);
        Parent root = (Parent) fxmlLoader.load();
        
        //luego que el fxml ha sido cargado puedo utilizar el controlador para realizar cambios
        App.changeRoot(root);
    }
}
