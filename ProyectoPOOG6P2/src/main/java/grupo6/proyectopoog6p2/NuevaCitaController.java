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
    private void buscarEmpleados() {

        ArrayList<Cita> citas = Cita.cargarCitas(App.pathCitas);
        ArrayList<Empleado> empleados = Empleado.cargarEmpleados(App.pathEmpleados);
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();
        ArrayList<Empleado> empleadosDisponibles = Empleado.mostrarEmpleadosDisponibles(citas, empleados, fecha, hora);
        if(empleadosDisponibles.size()!=0){
            for (Empleado e : empleadosDisponibles) {
                cmbEmpleados.getItems().add(e.getNombre());
            }
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setContentText("No hay empleados disponibles para la fecha y hora ingresadas");
            alerta.showAndWait();
        }
    }

    public void initialize() {
        ArrayList<Servicio> servicios = Servicio.cargarServicios(App.pathServicios);
        ArrayList<Servicio> serviciosDisponibles = Servicio.serviciosDisponibles(servicios);
        ArrayList<String> nombreServicios = new ArrayList<>();
        for (Servicio s : serviciosDisponibles) {
            nombreServicios.add(s.getNombreServicio());
        }

        cmbServicios.getItems().setAll(nombreServicios);
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
        ArrayList<Cita> citas = Cita.cargarCitas(App.pathCitas);
        ArrayList<Cliente> clientes = Cliente.cargarClientes(App.pathClientes);
        ArrayList<Empleado> empleados = Empleado.cargarEmpleados(App.pathEmpleados);
        ArrayList<Servicio> servicios = Servicio.cargarServicios(App.pathServicios);
        String cedulaClienteEscogido = txtCedula.getText();
        String servicioEscogido = cmbServicios.getValue();

        Cliente clienteCita = null;
        Empleado empleadoCita = null;
        Servicio servicioCita = null;
        int clienteEncontrado = 0;
        for (Cliente c : clientes) {
            if (cedulaClienteEscogido.equals(c.getCedula())) {
                clienteCita = c;
                clienteEncontrado++;
            }
        }
        
        for (Servicio s : servicios) {
            if (servicioEscogido.equals(s.getNombreServicio())) {
                servicioCita = s;
            }
        }
        if (clienteEncontrado != 0) {
            String nombreEmpleadoEscogido = cmbEmpleados.getValue();
            for (Empleado e : empleados) {
            if (nombreEmpleadoEscogido.equals(e.getNombre())) {
                empleadoCita = e;
                }
            }
            Cita citaNueva = new Cita(clienteCita, empleadoCita, servicioCita, txtFecha.getText(), txtHora.getText());
            citas.add(citaNueva);

            try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/grupo6/proyectopoog6p2/files/listaCitas.ser", false))) {
                out.writeObject(citas);
                out.flush();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMACION");
                alert.setHeaderText("Resultado de la operación");
                alert.setContentText("Nuevo cita agregada exitosamente");
                alert.showAndWait();

            } catch (IOException e) {
                System.out.println(e);
            }
            switchToMenu();
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setContentText("No existen clientes con el número de cédula ingresado");
            alerta.showAndWait();
        }

    }

}
