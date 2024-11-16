package projects.rupizzeria.rupizzeria.controllers;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projects.rupizzeria.rupizzeria.MainController;
public class CurrentOrderController {
    private MainController mainController;
    private Stage stage;
    private Scene primaryScene;
    private Stage primaryStage;
    private ObservableList<String> colorList, fruitList, peopleList;
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
