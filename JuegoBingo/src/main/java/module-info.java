module espol.edu.ec.juegobingo {
    requires javafx.controls;
    requires javafx.fxml;

    opens espol.edu.ec.juegobingo to javafx.fxml;
    exports espol.edu.ec.juegobingo;
}
