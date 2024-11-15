package projects.rupizzeria.rupizzeria;

import java.util.ArrayList;
import java.util.Arrays;

public class Deluxe extends Pizza{
    private final double SMALL_PRICE = 16.99;
    private final double MED_PRICE = 18.99;
    private final double LARGE_PRICE = 20.99;
    /**
     * Default BBQChicken constructor.
     */
    public Deluxe() {
        super();
        super.setToppings(new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER, Topping.ONION,Topping.MUSHROOM)));
        super.setCrust(Crust.DEEPDISH);
        super.setSize(Size.SMALL);
    }
    /**
     * Calculates price of BBQChicken pizza.
     * @return price of BBQChicken pizza.
     */
    public double price() {
        switch(super.getSize()) {
            case SMALL -> {return SMALL_PRICE;}
            case MEDIUM -> {return MED_PRICE;}
            case LARGE -> {return LARGE_PRICE;}
            default -> {return 0;}
        }
    }
}


