package projects.rupizzeria.rupizzeria;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javax.swing.text.html.ImageView;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    private ImageView IV_OrderPLaced;

    @FXML
    private Button B_OrderPlaced;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize(){

    }
}