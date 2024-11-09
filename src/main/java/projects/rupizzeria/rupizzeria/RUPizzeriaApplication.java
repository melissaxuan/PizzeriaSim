package projects.rupizzeria.rupizzeria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RUPizzeriaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RUPizzeriaApplication.class.getResource("RUPizzaria.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 500);
        MainController mainController = fxmlLoader.getController();
        mainController.setPrimaryStage(stage, scene);
        stage.setTitle("RU Pizzeria");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}