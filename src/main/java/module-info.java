module projects.rupizzeria.rupizzeria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens projects.rupizzeria.rupizzeria to javafx.fxml;
    exports projects.rupizzeria.rupizzeria;
    opens projects.rupizzeria.rupizzeria.controllers to javafx.fxml;
    exports projects.rupizzeria.rupizzeria.controllers;
    exports projects.rupizzeria.rupizzeria.factory;
    opens projects.rupizzeria.rupizzeria.factory to javafx.fxml;
    exports projects.rupizzeria.rupizzeria.util;
    opens projects.rupizzeria.rupizzeria.util to javafx.fxml;
    exports projects.rupizzeria.rupizzeria.factory.impl;
    opens projects.rupizzeria.rupizzeria.factory.impl to javafx.fxml;
}