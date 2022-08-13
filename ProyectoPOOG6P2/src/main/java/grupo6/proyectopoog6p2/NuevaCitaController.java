/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo6.proyectopoog6p2;

import grupo6.proyectopoog6p2.modelo.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NuevaCitaController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnGuardar;

    @FXML
    private ComboBox<String> cmbEmpleados;

    @FXML
    private ComboBox<String> cmbServicios;

    @FXML
    private Label lblCedulaCliente;

    @FXML
    private Label lblEmpleado;

    @FXML
    private Label lblFecha;

    @FXML
    private Label lblHora;

    @FXML
    private Label lblServicio;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtFecha;

    @FXML
    private TextField txtHora;
    
    @FXML
    private void buscarEmpleados(){
        ArrayList<Cita> citas= Cita.cargarCitas("");
        ArrayList<Empleado> empleados= Empleado.cargarEmpleados("");
        String fecha= txtFecha.getText();
        String hora= txtHora.getText();
        ArrayList<Empleado> empleadosDisponibles= Empleado.mostrarEmpleadosDisponibles(citas, empleados, fecha, hora);       
        for(Empleado e: empleadosDisponibles){
             cmbEmpleados.getItems().add(e.getNombre());
        }      
    }
    
    public void initialize(){
        ArrayList<Servicio> servicios= Servicio.cargarServicios("");
        ArrayList<Servicio> serviciosDisponibles= Servicio.serviciosDisponibles(servicios);
        for(Servicio s: serviciosDisponibles){
            cmbServicios.getItems().add(s.getNombreServicio());
        }
      
    }
    
    @FXML
    private void switchToMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuCitas.fxml"));
        fxmlLoader.setController(null);
        
        MenuCitaController msc = new MenuCitaController();
        fxmlLoader.setController(msc);
        Parent root = (Parent) fxmlLoader.load();
       
        App.changeRoot(root);
    }
    
    @FXML
    void guardarCita() throws IOException {
        ArrayList<Cita> citas= Cita.cargarCitas("");
        ArrayList<Cliente> clientes= Cliente.cargarClientes("");
        ArrayList<Empleado> empleados= Empleado.cargarEmpleados("");
        ArrayList<Servicio> servicios= Servicio.cargarServicios("");
        String nombreEmpleadoEscogido= cmbEmpleados.getValue();
        String cedulaClienteEscogido= txtCedula.getText();
        String servicioEscogido= cmbServicios.getValue();
        
        Cliente clienteCita=null;
        Empleado empleadoCita=null;
        Servicio servicioCita=null;
        
        for(Cliente c: clientes){
            if(cedulaClienteEscogido.equals(c.getCedula())){
                clienteCita=c;
            }
        }
        for(Empleado e: empleados){
            if(nombreEmpleadoEscogido.equals(e.getNombre())){
                empleadoCita=e;
            }
        }
        for(Servicio s: servicios){
            if(servicioEscogido.equals(s.getNombreServicio())){
                servicioCita=s;
            }
        }
        
        Cita citaNueva= new Cita(clienteCita,empleadoCita,servicioCita,txtFecha.getText(),txtHora.getText());
        citas.add(citaNueva);
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(""))){
            out.writeObject(citas);
            out.flush();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMACION");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nuevo cita agregada exitosamente");
            alert.showAndWait();
            
        }catch(IOException e){
            System.out.println(e);
        }
        switchToMenu();
    }
    
}

