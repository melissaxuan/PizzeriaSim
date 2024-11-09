package projects.rupizzeria.rupizzeria;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    private ImageView IV_OrderPLaced;

    @FXML
    private Button B_OrderPlaced;
    private Stage primaryStage; //the reference of the main window.
    private Scene primaryScene; //the ref. of the scene set to the primaryStage
    public void setPrimaryStage(Stage stage, Scene scene) {
        primaryStage = stage;
        primaryScene = scene;
    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize(){

    }


    @FXML
    public void onOrdersPlaced()
    {
        Stage view1 = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("bill-view.fxml"));
            System.out.println("1");
            Scene scene = new Scene(loader.load(), 400, 600);
            System.out.println("3");
            //view1.setScene(scene); //if we wnat to use the new window to draw the scene graph
           // view1.setTitle("view1");
            //view1.show();
            primaryStage.setScene(scene);
            System.out.println("4");
            BillViewController secondViewController = loader.getController();
            System.out.println("5");
            /*
              The statement below is to pass the references of the MainController objects
              to the SecondViewController object so the SecondViewController can call the
              public methods in the MainController or to navigate back to the main view.
             */
            secondViewController.setMainController(this, view1, primaryStage, primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading second-view.fxml.");
            alert.setContentText("Couldn't load second-view.fxml.");
            alert.showAndWait();
        }
    }
}