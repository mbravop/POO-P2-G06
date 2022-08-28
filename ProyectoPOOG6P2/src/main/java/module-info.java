module grupo6.proyectopoog6p2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.media;

    opens grupo6.proyectopoog6p2 to javafx.fxml;
    opens grupo6.proyectopoog6p2.modelo to javafx.base;
    exports grupo6.proyectopoog6p2;
}
