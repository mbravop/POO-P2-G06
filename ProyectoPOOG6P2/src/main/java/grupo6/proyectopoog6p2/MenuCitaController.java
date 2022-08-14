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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    public void llenarTabla(){
        tvCitas.getItems().addAll(Cita.cargarCitas(App.pathCitas));
    }
    
    @FXML
    void buscarCitas(){
        
    }

    @FXML
    void consultarActividades(ActionEvent event) {

    }

    @FXML
    void crearCita() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("nuevaCita.fxml"));
        fxmlLoader.setController(null);
        NuevaCitaController ncc = new NuevaCitaController();
        fxmlLoader.setController(ncc);
        Parent root = (Parent) fxmlLoader.load();
        App.changeRoot(root);
    }

    @FXML
    void eliminarCita() throws IOException{
        ArrayList<Cita> citas = Cita.cargarCitas(App.pathCitas);
        Cita citaAEliminar = (Cita) tvCitas.getSelectionModel().getSelectedItem();
        Cita citaEliminada = null;
        
        for(Cita c:citas){
            Cliente cliente1 = c.obtenerCliente();
            Cliente cliente2 = citaAEliminar.obtenerCliente();
            if(cliente1.equals(cliente2)){ //&& c.obtenerEmpleado().equals(citaAEliminar.obtenerEmpleado()) && c.getFecha().equals(citaAEliminar.getFecha()) && c.getHora().equals(citaAEliminar.getHora()) && c.obtenerServicio().equals(citaAEliminar.obtenerServicio())){
                System.out.println("Iguales");
                //citaEliminada =c;
            }
        }
        //citas.remove(citaEliminada);
        
        
        
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/grupo6/proyectopoog6p2/files/listaCitas.ser",false))){
            out.writeObject(citas);
            out.flush();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMACION");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Cita eliminada exitosamente");
            alert.showAndWait();
            
        }catch(IOException e){
            System.out.println(e);
        }
        try{
        switchToMenu();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void registrarAtencion(ActionEvent event) {

    }

    @FXML
    void switchToMenu() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuCitas.fxml"));
        fxmlLoader.setController(null);
        MenuCitaController mcc = new MenuCitaController();
        fxmlLoader.setController(mcc);
        Parent root = (Parent) fxmlLoader.load();
        App.changeRoot(root);
    }
}
