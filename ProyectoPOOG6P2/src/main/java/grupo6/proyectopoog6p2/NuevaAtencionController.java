package grupo6.proyectopoog6p2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import grupo6.proyectopoog6p2.modelo.Atencion;
import grupo6.proyectopoog6p2.modelo.Cita;
import grupo6.proyectopoog6p2.modelo.Cliente;
import grupo6.proyectopoog6p2.modelo.Empleado;
import grupo6.proyectopoog6p2.modelo.Servicio;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class NuevaAtencionController {
    
    public static Cliente cedulaClienteAtendido;
    public static String fechaAtencion;

    @FXML
    private ComboBox<String> cmbEmpleados;
    
    @FXML
    private Label lblEmpleado;

    @FXML
    private Label lblFechayHora;

    @FXML
    private Label lblNombreCliente;

    @FXML
    private TextField txtDuracion;
    @FXML
    private Label lblServicio;
    
    public void initialize(){
        ArrayList<Cita> citas = Cita.cargarCitas(App.pathCitas);
        ArrayList<Empleado> empleados = Empleado.cargarEmpleados(App.pathEmpleados);
        ArrayList<Empleado> empleadosActivos = Empleado.mostrarEmpleadosDisponibles(citas, empleados, "", "");
        for(Empleado e: empleadosActivos){
            cmbEmpleados.getItems().add(e.getNombre());
        }
        
        lblServicio.setVisible(false);
        lblEmpleado.setVisible(false);
    }

    @FXML
    void registrarAtencion() throws IOException{
        ArrayList<Cliente> clientes = Cliente.cargarClientes(App.pathClientes);
        ArrayList<Empleado> empleados = Empleado.cargarEmpleados(App.pathEmpleados);
        ArrayList<Servicio> servicios = Servicio.cargarServicios(App.pathServicios);
        
        Cliente clienteAtendido = null;
        Servicio servicioAtendido = null;
        Empleado empleadoCita = null;
        Empleado empleadoAtiende = null;
        
        String[] horario = lblFechayHora.getText().split(" "); 
        String[] infoCliente = lblNombreCliente.getText().split("- ");
        String fechaAtendida = horario[0];
        String horaAtendida = horario[1];
        String ceduCliente = infoCliente[1];
          
        for(Cliente c:clientes){
            if(c.getCedula().equals(ceduCliente)){
                clienteAtendido = c;
            }
        }
        
        for(Servicio s:servicios){
            if(s.getNombreServicio().equals(lblServicio.getText())){
                servicioAtendido = s;
            }
        }
        
        for(Empleado e: empleados){
            if(e.getNombre().equals(cmbEmpleados.getValue())){
                empleadoAtiende = e;
            }
            if(e.getNombre().equals(lblEmpleado.getText())){
                empleadoCita = e;
            }
        }
        
        Cita citaAtendida = new Cita(clienteAtendido,empleadoCita,servicioAtendido,fechaAtendida,horaAtendida);
        ArrayList<Atencion> atencionesRealizadas = Atencion.cargarAtenciones(App.pathAtenciones);
        Atencion atencionNueva = new Atencion(citaAtendida,Integer.parseInt(txtDuracion.getText()),empleadoAtiende);
        atencionesRealizadas.add(atencionNueva);
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.pathAtenciones,false))){
            out.writeObject(atencionesRealizadas);
            out.flush();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMACION");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nuevo cita agregada exitosamente");
            alert.showAndWait();
            
        }catch(IOException e){
            System.out.println(e);
        }
        
        ArrayList<Cita> citas = Cita.cargarCitas(App.pathCitas);
        Cita citaAEliminar = citaAtendida;
        Cita citaEliminada = null;
        for (Cita c : citas) {
            if (c.getCliente().equals(citaAEliminar.getCliente()) && c.getEmpleado().equals(citaAEliminar.getEmpleado()) && c.getFecha().equals(citaAEliminar.getFecha()) && c.getHora().equals(citaAEliminar.getHora()) && c.getServicio().equals(citaAEliminar.getServicio())) {
                System.out.println("Iguales");
                citaEliminada = c;
                }
            citas.remove(citaEliminada);

            try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/grupo6/proyectopoog6p2/files/listaCitas.ser", false))) {
                out.writeObject(citas);
                out.flush();

            } catch (IOException e) {
                System.out.println(e);
            }
        }
        switchToMenu();
        
    }
    
    @FXML
    void iniciarJuego() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Bingo.fxml"));
        fxmlLoader.setController(null);
        BingoController bc = new BingoController();
        fxmlLoader.setController(bc);
        Parent root = (Parent) fxmlLoader.load();
        App.changeRoot(root);
    }
    
    void llenarCampos(Cita c){
        lblFechayHora.setText(c.getFecha()+" "+c.getHora());
        lblNombreCliente.setText(c.getCliente()+" - "+c.obtenerCliente().getCedula());
        lblServicio.setText(c.getServicio());
        lblEmpleado.setText(c.getEmpleado());
        
        cedulaClienteAtendido = c.obtenerCliente();
        fechaAtencion = c.getFecha();
    }

    @FXML
    void switchToMenu() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuCitas.fxml"));
        fxmlLoader.setController(null);
        MenuCitaController mcc = new MenuCitaController();
        fxmlLoader.setController(mcc);
        Parent root = (Parent) fxmlLoader.load();
        App.changeRoot(root);
    }

}

