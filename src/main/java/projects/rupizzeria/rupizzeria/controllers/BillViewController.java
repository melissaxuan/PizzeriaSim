package projects.rupizzeria.rupizzeria.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import projects.rupizzeria.rupizzeria.MainController;


public class BillViewController {


    @FXML
    private ListView lv_bill;
    @FXML
    private Button B_cancelOrder;
    @FXML
    private Button B_exportStore;


    private MainController mainController;
    private Stage stage;
    private Scene primaryScene;
    private Stage primaryStage;
    private ObservableList<String> colorList, fruitList, peopleList;
    public void setMainController (MainController controller, Stage stage, Stage primaryStage, Scene primaryScene) {
        mainController = controller;
        this.stage = stage;
        this.primaryStage = primaryStage;
        this.primaryScene = primaryScene;
    }
}
