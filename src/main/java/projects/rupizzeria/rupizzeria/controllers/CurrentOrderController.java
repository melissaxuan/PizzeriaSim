package projects.rupizzeria.rupizzeria.controllers;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import projects.rupizzeria.rupizzeria.util.Order;

import java.io.IOException;

/**
 * Controls current order view.
 */
public class CurrentOrderController {
    private MainController mainController;
    private Stage stage;
    private Scene primaryScene;
    private Stage primaryStage;
    private Order currOrder;
//    private ObservableList<String> colorList, fruitList, peopleList;

    /**
     * Default constructor for CurrentOrderController.
     */
    public CurrentOrderController() {
        currOrder = new Order();
    }

    /**
     * Sets homepage controller.
     * @param controller homepage controller
     * @param stage new popup stage
     * @param primaryStage homepage stage
     * @param primaryScene homepage scene
     */
    public void setMainController(MainController controller, Stage stage, Stage primaryStage, Scene primaryScene) {
        mainController = controller;
        this.stage = stage;
        this.primaryStage = primaryStage;
        this.primaryScene = primaryScene;
    }

    /**
     * Redirects user to order view to add a new pizza to order.
     */
    @FXML
    public void addPizza() {
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
            thirdViewController.setMainController(this.mainController, popupStage, this.primaryStage, this.primaryScene);
        } catch (IOException e) {
            // Handle exceptions with an alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading order-view.fxml.");
            alert.setContentText("Couldn't load order-view.fxml.");
            alert.showAndWait();
        }
    }

    /**
     * Returns current Order object.
     * @return current Order
     */
    public Order getCurrOrder() {
        return currOrder;
    }
}
