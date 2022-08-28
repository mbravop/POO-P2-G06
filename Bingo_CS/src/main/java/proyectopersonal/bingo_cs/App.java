package proyectopersonal.bingo_cs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static java.lang.System.exit;

/**
 * JavaFX App
 */
public class App extends Application {
    public static String pathBingo = "proyectopersonal/bingo_cs/files/listaPartidasBingo.csv";
    private static Scene scene;
   
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Bingo"), 800, 640);
        stage.setScene(scene);
        stage.setOnCloseRequest(eh -> exit(0));
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

}