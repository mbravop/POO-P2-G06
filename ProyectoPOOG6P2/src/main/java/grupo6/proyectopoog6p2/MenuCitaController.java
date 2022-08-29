/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
        tvCitas.setColumnResizePolicy(tvCitas.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    public void llenarTabla() {
        ArrayList<Cita> citas = Cita.cargarCitas(App.pathCitas);
        ArrayList<Atencion> atenciones = Atencion.cargarAtenciones(App.pathAtenciones);
        ArrayList<Cita> citasNoRealizadas= Cita.citasNoAtendidas(citas, atenciones);
        tvCitas.getItems().addAll(citasNoRealizadas);
    }

    @FXML
    void buscarCitas() {
        ArrayList<Cita> citaFiltrados = new ArrayList<>();
        for (Cita c : Cita.cargarCitas(App.pathCitas)) {
            if (c.obtenerCliente().getCedula().equals(txtFiltroCliente.getText())) {
                citaFiltrados.add(c);
            }
        }
        tvCitas.getItems().setAll(citaFiltrados);
    }

    @FXML
    void consultarActividades() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuActividades.fxml"));
        fxmlLoader.setController(null);
        MenuActividadController mac = new MenuActividadController();
        fxmlLoader.setController(mac);
        Parent root = (Parent) fxmlLoader.load();
        App.changeRoot(root);
    }

    @FXML
    void crearCita() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("nuevaCita.fxml"));
        fxmlLoader.setController(null);
        NuevaCitaController ncc = new NuevaCitaController();
        fxmlLoader.setController(ncc);
        Parent root = (Parent) fxmlLoader.load();
        App.changeRoot(root);
    }

    @FXML
    void eliminarCita() throws Exception {
        ArrayList<Cita> citas = Cita.cargarCitas(App.pathCitas);
        Cita citaAEliminar = (Cita) tvCitas.getSelectionModel().getSelectedItem();
        if(citaAEliminar==null){
            Alert alerta= new Alert(Alert.AlertType.WARNING);
            alerta.setContentText("Por favor seleccione una cita ");
            alerta.showAndWait();
        }else{
            Cita citaEliminada = null;
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación necesaria");
            alert.setContentText("¿Desea eliminar la cita seleccionada?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                for (Cita c : citas) {
                    if (c.getCliente().equals(citaAEliminar.getCliente()) && c.getEmpleado().equals(citaAEliminar.getEmpleado()) && c.getFecha().equals(citaAEliminar.getFecha()) && c.getHora().equals(citaAEliminar.getHora()) && c.getServicio().equals(citaAEliminar.getServicio())) {
                        System.out.println("Iguales");
                        citaEliminada = c;
                    }
                }
                citas.remove(citaEliminada);

                try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/grupo6/proyectopoog6p2/files/listaCitas.ser", false))) {
                    out.writeObject(citas);
                    out.flush();
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("INFORMACION");
                    alert1.setHeaderText("Resultado de la operación");
                    alert1.setContentText("Cita eliminada exitosamente");
                    alert1.showAndWait();

                } catch (IOException e) {
                    System.out.println(e);
                }
            }

            switchToMenu();
        }
    }

    @FXML
    void registrarAtencion() throws IOException {
        Cita citaRegistro = (Cita) tvCitas.getSelectionModel().getSelectedItem();
        if(citaRegistro==null){
            Alert alerta= new Alert(Alert.AlertType.WARNING);
            alerta.setContentText("Por favor seleccione una cita ");
            alerta.showAndWait();
        }else{
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("nuevaAtencion.fxml"));
            fxmlLoader.setController(null);
            NuevaAtencionController nac = new NuevaAtencionController();
            fxmlLoader.setController(nac);
            Parent root = (Parent) fxmlLoader.load();
            nac.llenarCampos(citaRegistro);
            App.changeRoot(root);
        }
    }

    @FXML
    void switchToMenu() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuCitas.fxml"));
        fxmlLoader.setController(null);
        MenuCitaController mcc = new MenuCitaController();
        fxmlLoader.setController(mcc);
        Parent root = (Parent) fxmlLoader.load();
        App.changeRoot(root);
    }
}
