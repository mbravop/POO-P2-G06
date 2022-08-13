/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2;

import grupo6.proyectopoog6p2.modelo.Cita;
import grupo6.proyectopoog6p2.modelo.Cliente;
import grupo6.proyectopoog6p2.modelo.Empleado;
import grupo6.proyectopoog6p2.modelo.Servicio;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MenuCitaController {

    @FXML
    private Button btnBuscarCliente;

    @FXML
    private TableView<Cita> tvCitas;
    
    @FXML
    private TableColumn<Cita, String> colFecha;

    @FXML
    private TableColumn<Cita, String> colHora;

    @FXML
    private TableColumn<Cita, String> colNombre;

    @FXML
    private TableColumn<Cita, String> colServicio;

    @FXML
    private TableColumn<Cita, String> colTerapista;
   
    @FXML
    private TextField txtFiltroCliente;
    
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colTerapista.setCellValueFactory(new PropertyValueFactory<>("empleado"));
        colServicio.setCellValueFactory(new PropertyValueFactory<>("servicio"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        llenarTabla();
    } 
    
    public void llenarTabla(){
        tvCitas.getItems().addAll(Cita.cargarCitas("/Users/mbravop03/Desktop/ESPOL/Segundo Semestre/POO/Proyecto POO - Grupo 6/POO-P2-G06/ProyectoPOOG6P2/src/main/resources/grupo6/proyectopoog6p2/files/listaCitas.ser"));
    }
    
    @FXML
    void buscarCitas(){
        
    }

    @FXML
    void consultarActividades(ActionEvent event) {

    }

    @FXML
    void crearCita(ActionEvent event) {

    }

    @FXML
    void eliminarCita(ActionEvent event) {

    }

    @FXML
    void registrarAtencion(ActionEvent event) {

    }

    @FXML
    void switchToMenu(ActionEvent event) {

    }

    @FXML
    void switchToPrimary(ActionEvent event) {

    }

}
