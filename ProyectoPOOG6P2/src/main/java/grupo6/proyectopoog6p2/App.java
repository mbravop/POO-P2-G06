package grupo6.proyectopoog6p2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    
    public static String pathClientes = "grupo6/proyectopoog6p2/files/listaClientes.csv";
    public static String pathEmpleados = "grupo6/proyectopoog6p2/files/listaEmpleados.csv";
    public static String pathServicios = "grupo6/proyectopoog6p2/files/listaServicios.csv";
    public static String pathCitas = "src/main/resources/grupo6/proyectopoog6p2/files/listaCitas.ser";
    private static Scene scene;
    

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    static void changeRoot(Parent rootNode) {
        scene.setRoot(rootNode);
    }

}