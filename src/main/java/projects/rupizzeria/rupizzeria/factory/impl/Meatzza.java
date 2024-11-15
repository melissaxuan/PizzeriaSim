package projects.rupizzeria.rupizzeria.factory.impl;

import projects.rupizzeria.rupizzeria.factory.Pizza;
import projects.rupizzeria.rupizzeria.util.Crust;
import projects.rupizzeria.rupizzeria.util.Size;
import projects.rupizzeria.rupizzeria.util.Topping;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Handles Meatzza details.
 */
public class Meatzza extends Pizza {
    private final double SMALL_PRICE = 17.99;
    private final double MED_PRICE = 19.99;
    private final double LARGE_PRICE = 21.99;
    /**
     * Default Meatzza constructor.
     */
    public Meatzza() {
        super();
        super.setToppings(new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM)));
        super.setCrust(Crust.STUFFED);
        super.setSize(Size.SMALL);
    }

    /**
     * Calculates price of Meatzza pizza.
     * @return price of Meatzza pizza.
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
