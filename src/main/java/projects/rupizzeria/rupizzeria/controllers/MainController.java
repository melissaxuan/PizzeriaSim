package projects.rupizzeria.rupizzeria.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import projects.rupizzeria.rupizzeria.util.Order;

import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button B_OrderPlaced;
    private Stage primaryStage; //the reference of the main window.
    private Scene primaryScene;  //the ref. of the scene set to the primaryStage
    private Order currentOrder;

    private ArrayList<Order> order;

    public void setPrimaryStage(Stage stage, Scene scene) {
        primaryStage = stage;
        primaryScene = scene;
    }


    public void initialize(){

    }


    @FXML
    public void onOrdersPlaced() {
        Stage popupStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projects/rupizzeria/rupizzeria/bill-view.fxml"));
            Scene popupScene = new Scene(loader.load(), 400, 600);
            popupStage.setScene(popupScene);
            popupStage.setTitle("Bill View");
            popupStage.initModality(Modality.APPLICATION_MODAL); // Make it modal (blocks interaction with other windows)
            popupStage.show(); // Show the popup window


            BillViewController secondViewController = loader.getController();

            secondViewController.setMainController(this, popupStage, primaryStage, primaryScene);
        } catch (IOException e) {
            // Handle exceptions with an alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading bill-view.fxml.");
            alert.setContentText("Couldn't load bill-view.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    public void onCurrentOrder() {
        Stage popupStage = new Stage(); // Create a new Stage for the popup

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projects/rupizzeria/rupizzeria/current-order-view.fxml"));
            Scene popupScene = new Scene(loader.load(), 600, 400);

            popupStage.setScene(popupScene);
            popupStage.setTitle("Current Order");
            popupStage.initModality(Modality.APPLICATION_MODAL); // Make it modal (blocks interaction with other windows)
            popupStage.show(); // Show the popup window

            CurrentOrderController forthViewController = loader.getController();
            forthViewController.setMainController(this, popupStage, primaryStage, primaryScene);
        } catch (IOException e) {
            // Handle exceptions with an alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading current-order-view.fxml.");
            alert.setContentText("Couldn't load current-order-view.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    public void Order() {
        Stage popupStage = new Stage(); // Create a new Stage for the popup

        try {
            // Load the order-view.fxml for the popup
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projects/rupizzeria/rupizzeria/order-view.fxml"));
            Scene popupScene = new Scene(loader.load(), 614, 547);

            // Set the scene for the popup stage
            popupStage.setScene(popupScene);
            popupStage.setTitle("Order A Pizza");
            popupStage.initModality(Modality.APPLICATION_MODAL); // Make it modal (blocks interaction with other windows)
            popupStage.show(); // Show the popup window

            // Pass references to the OrderController
            OrderController thirdViewController = loader.getController();
            thirdViewController.setMainController(this, popupStage, primaryStage, primaryScene);
        } catch (IOException e) {
            // Handle exceptions with an alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading order-view.fxml.");
            alert.setContentText("Couldn't load order-view.fxml.");
            alert.showAndWait();
        }
    }

    public ArrayList<Order> getOrder() {
        return this.order;
    }
}