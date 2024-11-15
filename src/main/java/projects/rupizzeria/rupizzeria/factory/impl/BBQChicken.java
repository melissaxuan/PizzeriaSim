package projects.rupizzeria.rupizzeria.factory.impl;

import projects.rupizzeria.rupizzeria.factory.Pizza;
import projects.rupizzeria.rupizzeria.util.Crust;
import projects.rupizzeria.rupizzeria.util.Size;
import projects.rupizzeria.rupizzeria.util.Topping;

import java.util.ArrayList;
import java.util.Arrays;

public class BBQChicken extends Pizza {
    private final double SMALL_PRICE = 14.99;
    private final double MED_PRICE = 16.99;
    private final double LARGE_PRICE = 19.99;
    /**
     * Default BBQChicken constructor.
     */
    public BBQChicken() {
        super();
        super.setToppings(new ArrayList<>(Arrays.asList(Topping.BBQ_CHICKEN, Topping.GREEN_PEPPER, Topping.PROVOLONE, Topping.CHEDDAR)));
        super.setCrust(Crust.PAN);
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
