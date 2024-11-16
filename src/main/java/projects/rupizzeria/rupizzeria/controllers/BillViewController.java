package projects.rupizzeria.rupizzeria.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import projects.rupizzeria.rupizzeria.util.Order;

import java.util.ArrayList;
import java.util.List;


/**
 * Class to display the total bill of all the orders.
 * @author Michael Ehresman
 */
public class BillViewController {


    @FXML
    private ListView<String> Lv_bill;
    @FXML
    private Button B_cancelOrder;
    @FXML
    private Button B_exportStore;
    @FXML
    private TextField tf_orderTotal;


    private MainController mainController;
    private Stage stage;
    private Scene primaryScene;
    private Stage primaryStage;
    private ObservableList<String> colorList, fruitList, peopleList;


    @FXML
    public void initialize()
    {
        printView();
    }
    @FXML
    public void onCancel()
    {

    }

    /**
     * Prints the orderlist to the list view and the total price of the orders.
     */
    public void printView()
    {
        ArrayList<Order> orders = mainController.getOrder();
        double totaledPrice=0;
        for(Order order: orders)
        {
            totaledPrice += order.calcOrderTotal();
        }
        String pricePrint = "$ " + totaledPrice;

        Lv_bill.getItems().addAll(String.valueOf(orders));
        tf_orderTotal.setText(pricePrint);
    }



    /**
     * sets the main controller for navigation purposes.
     * @param controller controller of the mainController
     * @param stage stage of the mainController
     * @param primaryStage primaryStage of the mainController
     * @param primaryScene primaryScene of the mainController
     */
    public void setMainController (MainController controller, Stage stage, Stage primaryStage, Scene primaryScene) {
        mainController = controller;
        this.stage = stage;
        this.primaryStage = primaryStage;
        this.primaryScene = primaryScene;
    }
}
