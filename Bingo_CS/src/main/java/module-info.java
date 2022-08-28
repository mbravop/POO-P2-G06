module proyectopersonal.bingo_cs {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    
    opens proyectopersonal.bingo_cs to javafx.fxml;
    exports proyectopersonal.bingo_cs;
}
