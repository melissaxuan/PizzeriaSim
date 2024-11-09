package projects.rupizzeria.rupizzeria;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class OrderController {

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

    private final double MIN_OPACITY = 0.0;
    private final double MAX_OPACITY = 1.0;
    private Order currOrder;
    private ArrayList<Order> orderList;

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
    @FXML
    void addTopping(ActionEvent event) {

    }

    @FXML
    void placePizzaOrder(ActionEvent event) {

    }

    @FXML
    void removeTopping(ActionEvent event) {

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
    }

    /**
     * Enables the crust and size options for Deluxe pizza, and the toppings list.
     */
    private void setupDeluxe() {
        enableCrust();
        rb_chicagocrust.setText("Chicago Style: Deep Dish");
        rb_nycrust.setText("NY Style: Brooklyn");
        enableSize();
        rb_smallsize.setText("Small: $16.99");
        rb_mediumsize.setText("Medium: $18.99");
        rb_largesize.setText("Large: $20.99");
        enableToppings();

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

    private void enableCrust() {
        txt_crust.setOpacity(MAX_OPACITY);
        rb_chicagocrust.setOpacity(MAX_OPACITY);
        rb_nycrust.setOpacity(MAX_OPACITY);
        rb_chicagocrust.setDisable(false);
        rb_nycrust.setDisable(false);
    }

    private void enableSize() {
        txt_size.setOpacity(MAX_OPACITY);
        rb_smallsize.setOpacity(MAX_OPACITY);
        rb_mediumsize.setOpacity(MAX_OPACITY);
        rb_largesize.setOpacity(MAX_OPACITY);
        rb_smallsize.setDisable(false);
        rb_mediumsize.setDisable(false);
        rb_largesize.setDisable(false);
    }

    private void enableToppings() {
        txt_toppings.setOpacity(MAX_OPACITY);
        txt_availabletoppings.setOpacity(MAX_OPACITY);
        txt_chosentoppings.setOpacity(MAX_OPACITY);
        txt_availabletoppings.setText("Available Toppings");
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
    }

    private void enablePlaceOrder() {
        bt_placeorder.setOpacity(MAX_OPACITY);
        bt_placeorder.setDisable(false);
    }

    private void showFixedToppings() {
        txt_toppings.setOpacity(MAX_OPACITY);
        txt_availabletoppings.setOpacity(MAX_OPACITY);
        txt_availabletoppings.setText("Chosen Toppings (Fixed)");
        lv_availtoppings.setOpacity(MIN_OPACITY);
        lv_chosentoppings.setOpacity(MAX_OPACITY);
        lv_availtoppings.setDisable(false);
        lv_chosentoppings.setDisable(false);
        txt_add.setOpacity(MAX_OPACITY);
        txt_remove.setOpacity(MAX_OPACITY);
        bt_add.setOpacity(MAX_OPACITY);
        bt_remove.setOpacity(MAX_OPACITY);
        bt_add.setDisable(false);
        bt_remove.setDisable(false);
    }
}
