/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo6.proyectopoog6p2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableView;

/**
 *
 * @author mbravop
 */
public class MenuActividadController {
    @FXML
    private TableView<?> tvActividades;

    @FXML
    void switchToMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuCitas.fxml"));
        fxmlLoader.setController(null);

        MenuCitaController msc = new MenuCitaController();
        fxmlLoader.setController(msc);
        Parent root = (Parent) fxmlLoader.load();

        App.changeRoot(root);
    }
}
