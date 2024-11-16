package projects.rupizzeria.rupizzeria.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projects.rupizzeria.rupizzeria.MainController;
import projects.rupizzeria.rupizzeria.factory.ChicagoPizza;
import projects.rupizzeria.rupizzeria.factory.NYPizza;
import projects.rupizzeria.rupizzeria.factory.Pizza;
import projects.rupizzeria.rupizzeria.factory.PizzaFactory;
import projects.rupizzeria.rupizzeria.util.Crust;
import projects.rupizzeria.rupizzeria.util.Size;
import projects.rupizzeria.rupizzeria.util.Topping;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderController {
    private final double MIN_OPACITY = 0.0;
    private final double MAX_OPACITY = 1.0;
    private final int MAX_TOPPINGS = 7;

    @FXML
    private Button bt_add;

    @FXML
    private Button bt_placeorder;

    @FXML
    private Button bt_remove;

    @FXML
    private ComboBox<String> cb_pizzatype;

    @FXML
    private ImageView iv_pizza;

    @FXML
    private ListView<Topping> lv_availtoppings;

    @FXML
    private ListView<Topping> lv_chosentoppings;

    @FXML
    private RadioButton rb_chicagocrust;

    @FXML
    private RadioButton rb_largesize;

    @FXML
    private RadioButton rb_mediumsize;

    @FXML
    private RadioButton rb_nycrust;

    @FXML
    private RadioButton rb_smallsize;

    @FXML
    private ToggleGroup tg_crust;

    @FXML
    private ToggleGroup tg_size;

    @FXML
    private Text txt_add;

    @FXML
    private Text txt_availabletoppings;

    @FXML
    private Text txt_chosentoppings;

    @FXML
    private Text txt_crust;

    @FXML
    private Text txt_remove;

    @FXML
    private Text txt_size;

    @FXML
    private Text txt_toppings;

    private MainController mainController;
    private Stage stage;
    private Scene primaryScene;
    private Stage primaryStage;

    // private Order currOrder; ---- add to main controller
    // private ArrayList<Order> orderList; ---- add to main controller

    @FXML
    void initialize() {
        cb_pizzatype.getItems().addAll(
                "Deluxe Pizza",
                "BBQ Chicken Pizza",
                "Meatzza Pizza",
                "Build Your Own Pizza"
        );
        lv_availtoppings.setItems(FXCollections.observableArrayList(Topping.values()));
        disableAll();
    }
    /**
     * sets the main controller for navigation purposes.
     * @param controller controller of the mainController
     * @param stage stage of the mainController
     * @param primaryStage primaryStage of the mainController
     * @param primaryScene primaryScene of the mainController
     */
    public void setMainController(MainController controller, Stage stage, Stage primaryStage, Scene primaryScene) {
        mainController = controller;
        this.stage = stage;
        this.primaryStage = primaryStage;
        this.primaryScene = primaryScene;
    }

    @FXML
    void addTopping(ActionEvent event) {
        if (lv_availtoppings.getSelectionModel().getSelectedItem() != null &&
            lv_chosentoppings.getItems().size() < MAX_TOPPINGS) {
            lv_chosentoppings.getItems().add(lv_availtoppings.getSelectionModel().getSelectedItem());
            lv_availtoppings.getItems().remove(lv_availtoppings.getSelectionModel().getSelectedIndex());
        }
    }

    @FXML
    void placePizzaOrder(ActionEvent event) {
        String crust = "Chicago";
        PizzaFactory pizzaFactory;
        if (tg_crust.getSelectedToggle().toString().contains("Chicago Style")) {
            pizzaFactory = new ChicagoPizza();

        }
        else {
            crust = "NY";
            pizzaFactory = new NYPizza();
        }

        Pizza pizza = pizzaFactory.createDeluxe();
        setSpecialtyCrust(pizza, pizzaFactory, crust);

        if (tg_size.getSelectedToggle().toString().contains("Small")) {
            pizza.setSize(Size.SMALL);
        }
        else if (tg_size.getSelectedToggle().toString().contains("Medium")) {
            pizza.setSize(Size.MEDIUM);
        }
        else {
            pizza.setSize(Size.LARGE);
        }

    }

    @FXML
    void removeTopping(ActionEvent event) {
        if (lv_chosentoppings.getSelectionModel().getSelectedItem() != null) {
            lv_availtoppings.getItems().add(lv_chosentoppings.getSelectionModel().getSelectedItem());
            lv_chosentoppings.getItems().remove(lv_chosentoppings.getSelectionModel().getSelectedIndex());
        }
    }

    @FXML
    void selectPizzaType(ActionEvent event) {
        switch(cb_pizzatype.getValue()) {
            case "Deluxe Pizza" -> {
                setupDeluxe();
                break;
            }
            case "BBQ Chicken Pizza" -> {
                setupBBQChicken();
                break;
            }
            case "Meatzza Pizza" -> {
                setupMeatzza();
                break;
            }
            case "Build Your Own Pizza" -> {
                setupBYO();
                break;
            }
        }
        enablePlaceOrder();
    }

    /**
     * Enables the crust and size options for Deluxe pizza, and its toppings list.
     */
    private void setupDeluxe() {
        enableCrust();
        rb_chicagocrust.setText("Chicago Style: Deep Dish");
        rb_nycrust.setText("NY Style: Brooklyn");
        enableSize();
        rb_smallsize.setText("Small: $16.99");
        rb_mediumsize.setText("Medium: $18.99");
        rb_largesize.setText("Large: $20.99");
        showFixedToppings();
        lv_availtoppings.setItems(FXCollections.observableArrayList(new ArrayList<Topping>(Arrays.asList(
                Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER, Topping.ONION, Topping.MUSHROOM))));
    }

    /**
     * Enables the crust and size options for BBQ Chicken pizza, and its toppings list.
     */
    private void setupBBQChicken() {
        enableCrust();
        rb_chicagocrust.setText("Chicago Style: Pan");
        rb_nycrust.setText("NY Style: Thin");
        enableSize();
        rb_smallsize.setText("Small: $14.99");
        rb_mediumsize.setText("Medium: $16.99");
        rb_largesize.setText("Large: $19.99");
        showFixedToppings();
        lv_availtoppings.getItems().removeAll();
        lv_availtoppings.setItems(FXCollections.observableArrayList(new ArrayList<Topping>(Arrays.asList(
                Topping.BBQ_CHICKEN, Topping.GREEN_PEPPER, Topping.PROVOLONE, Topping.CHEDDAR))));
    }

    /**
     * Enables the crust and size options for Meatzza pizza, and its toppings list.
     */
    private void setupMeatzza() {
        enableCrust();
        rb_chicagocrust.setText("Chicago Style: Stuffed");
        rb_nycrust.setText("NY Style: Hand-tossed");
        enableSize();
        rb_smallsize.setText("Small: $17.99");
        rb_mediumsize.setText("Medium: $19.99");
        rb_largesize.setText("Large: $21.99");
        showFixedToppings();
        lv_availtoppings.getItems().removeAll();
        lv_availtoppings.setItems(FXCollections.observableArrayList(new ArrayList<Topping>(Arrays.asList(
                Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM))));
    }

    /**
     * Enables the crust, size, and toppings options for Build Your Own Pizza.
     */
    private void setupBYO() {
        enableAll();
        rb_chicagocrust.setText("Chicago Style: Pan");
        rb_nycrust.setText("NY Style: Hand-tossed");
        rb_smallsize.setText("Small: $8.99");
        rb_mediumsize.setText("Medium: $10.99");
        rb_largesize.setText("Large: $12.99");
    }

    /**
     * Helper method to disable every feature on the page other than the type of pizza combo box select.
     */
    private void disableAll() {
        txt_crust.setOpacity(MIN_OPACITY);
        rb_chicagocrust.setOpacity(MIN_OPACITY);
        rb_nycrust.setOpacity(MIN_OPACITY);
        rb_chicagocrust.setDisable(true);
        rb_nycrust.setDisable(true);
        txt_size.setOpacity(MIN_OPACITY);
        rb_smallsize.setOpacity(MIN_OPACITY);
        rb_mediumsize.setOpacity(MIN_OPACITY);
        rb_largesize.setOpacity(MIN_OPACITY);
        rb_smallsize.setDisable(true);
        rb_mediumsize.setDisable(true);
        rb_largesize.setDisable(true);
        txt_toppings.setOpacity(MIN_OPACITY);
        txt_availabletoppings.setOpacity(MIN_OPACITY);
        txt_chosentoppings.setOpacity(MIN_OPACITY);
        lv_availtoppings.setOpacity(MIN_OPACITY);
        lv_chosentoppings.setOpacity(MIN_OPACITY);
        lv_availtoppings.setDisable(true);
        lv_chosentoppings.setDisable(true);
        txt_add.setOpacity(MIN_OPACITY);
        txt_remove.setOpacity(MIN_OPACITY);
        bt_add.setOpacity(MIN_OPACITY);
        bt_remove.setOpacity(MIN_OPACITY);
        bt_add.setDisable(true);
        bt_remove.setDisable(true);
        bt_placeorder.setOpacity(MIN_OPACITY);
        bt_placeorder.setDisable(true);
    }

    /**
     * Helper method to enable every feature on the page other than the type of pizza combo box select.
     */
    private void enableAll() {
        enableCrust();
        enableSize();
        enableToppings();
        enablePlaceOrder();
    }

    /**
     * Helper method to enable crust options.
     */
    private void enableCrust() {
        txt_crust.setOpacity(MAX_OPACITY);
        rb_chicagocrust.setOpacity(MAX_OPACITY);
        rb_nycrust.setOpacity(MAX_OPACITY);
        rb_chicagocrust.setDisable(false);
        rb_nycrust.setDisable(false);
    }

    /**
     * Helper method to enable size options.
     */
    private void enableSize() {
        txt_size.setOpacity(MAX_OPACITY);
        rb_smallsize.setOpacity(MAX_OPACITY);
        rb_mediumsize.setOpacity(MAX_OPACITY);
        rb_largesize.setOpacity(MAX_OPACITY);
        rb_smallsize.setDisable(false);
        rb_mediumsize.setDisable(false);
        rb_largesize.setDisable(false);
    }

    /**
     * Helper method to enable toppings options and set the available toppings.
     */
    private void enableToppings() {
        txt_toppings.setOpacity(MAX_OPACITY);
        txt_availabletoppings.setOpacity(MAX_OPACITY);
        txt_chosentoppings.setOpacity(MAX_OPACITY);
        txt_availabletoppings.setText("Available Toppings (+$1.69 each)");
        lv_availtoppings.setOpacity(MAX_OPACITY);
        lv_chosentoppings.setOpacity(MAX_OPACITY);
        lv_availtoppings.setDisable(false);
        lv_chosentoppings.setDisable(false);
        txt_add.setOpacity(MAX_OPACITY);
        txt_remove.setOpacity(MAX_OPACITY);
        bt_add.setOpacity(MAX_OPACITY);
        bt_remove.setOpacity(MAX_OPACITY);
        bt_add.setDisable(false);
        bt_remove.setDisable(false);

        lv_availtoppings.getItems().removeAll();
        lv_availtoppings.setItems(FXCollections.observableArrayList(Topping.values()));

        lv_chosentoppings.getItems().removeAll();
    }

    /**
     * Helper method to enable place order buttons;
     */
    private void enablePlaceOrder() {
        bt_placeorder.setOpacity(MAX_OPACITY);
        bt_placeorder.setDisable(false);
    }

    /**
     * Helper method to show fixed toppings for specialty pizzas.
     */
    private void showFixedToppings() {
        txt_toppings.setOpacity(MAX_OPACITY);
        txt_availabletoppings.setOpacity(MAX_OPACITY);
        txt_availabletoppings.setText("Fixed Toppings");
        txt_chosentoppings.setOpacity(MIN_OPACITY);
        lv_availtoppings.setOpacity(MAX_OPACITY);
        lv_chosentoppings.setOpacity(MIN_OPACITY);
        lv_availtoppings.setDisable(true);
        lv_chosentoppings.setDisable(true);
        txt_add.setOpacity(MIN_OPACITY);
        txt_remove.setOpacity(MIN_OPACITY);
        bt_add.setOpacity(MIN_OPACITY);
        bt_remove.setOpacity(MIN_OPACITY);
        bt_add.setDisable(true);
        bt_remove.setDisable(true);
    }

    /**
     * Helper method to set pizza crust and specialty type.
     */
    private void setSpecialtyCrust(Pizza pizza, PizzaFactory pizzaFactory, String crust) {
        switch (cb_pizzatype.getValue()) {
            case "Deluxe Pizza" :
                pizza = pizzaFactory.createDeluxe();
                if (crust.equals("Chicago"))
                    pizza.setCrust(Crust.DEEPDISH);
                else
                    pizza.setCrust(Crust.BROOKLYN);
                break;
            case "BBQ Chicken Pizza" :
                pizza = pizzaFactory.createBBQChicken();
                if (crust.equals("Chicago"))
                    pizza.setCrust(Crust.PAN);
                else
                    pizza.setCrust(Crust.THIN);
                break;
            case "Meatzza Pizza" :
                pizza = pizzaFactory.createMeatzza();
                if (crust.equals("Chicago"))
                    pizza.setCrust(Crust.STUFFED);
                else
                    pizza.setCrust(Crust.HANDTOSSED);
                break;
            case "Build Your Own Pizza" :
                pizza = pizzaFactory.createBuildYourOwn();
                if (crust.equals("Chicago"))
                    pizza.setCrust(Crust.PAN);
                else
                    pizza.setCrust(Crust.HANDTOSSED);
                break;
        }
    }

}
