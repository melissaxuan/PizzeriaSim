module projects.rupizzeria.rupizzeria {
    requires javafx.controls;
    requires javafx.fxml;


    opens projects.rupizzeria.rupizzeria to javafx.fxml;
    exports projects.rupizzeria.rupizzeria;
}