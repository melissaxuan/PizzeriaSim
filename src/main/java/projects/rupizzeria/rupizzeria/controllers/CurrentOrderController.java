package projects.rupizzeria.rupizzeria.controllers;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
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
    private final int COUNT_INCR = 1;
    @FXML
    private Button bt_addpizza;

    @FXML
    private Button bt_placeorder;

    @FXML
    private Button bt_removeorder;

    @FXML
    private Button bt_removepizza;

    @FXML
    private ListView<?> lv_pizzas;

    @FXML
    private Text txt_currentorderheader;

    @FXML
    private Text txt_orderno;

    @FXML
    private Text txt_ordertotal;

    @FXML
    private Text txt_subtotal;

    @FXML
    private Text txt_tax;

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
        this.currOrder = new Order();
    }

    /**
     * sets the main controller for navigation purposes
     * @param controller controller of the mainController
     * @param stage stage of the mainController
     * @param primaryStage primaryStage of the mainController
     * @param primaryScene primaryScene of the mainController
     */
    public void setMainController(MainController controller, Stage stage, Stage primaryStage, Scene primaryScene) {
        this.mainController = controller;
        this.stage = stage;
        this.primaryStage = primaryStage;
        this.primaryScene = primaryScene;
    }

    /**
     * Redirects user to order view to add a new pizza to order.
     * @param event action event
     */
    @FXML
    void addPizza(ActionEvent event) {
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
     * Removes Pizza from list of Pizzas in Order.
     * @param event action event
     */
    @FXML
    void removePizza(ActionEvent event) {
        this.mainController.getCurrentOrder().removePizza(this.lv_pizzas.getSelectionModel().getSelectedIndex());
    }

    /**
     * Places Order and increments Counter.
     * @param event action event
     */
    @FXML
    void placeOrder(ActionEvent event) {
        this.mainController.getOrder().add(this.currOrder);
        this.mainController.setCounter(this.mainController.getCounter() + COUNT_INCR);
    }

    @FXML
    void removeOrder(ActionEvent event) {
        this.mainController.getOrder().removeIf(o -> o.getNumber() == this.currOrder.getNumber());
        this.mainController.setCurrent(new Order(this.mainController.getCounter() + COUNT_INCR));
        this.mainController.setCounter(this.mainController.getCounter() + COUNT_INCR);
    }

    /**
     * Returns current Order object.
     * @return current Order
     */
    public Order getCurrOrder() {
        return currOrder;
    }
}
