package projects.rupizzeria.rupizzeria.pizza.impl;

import projects.rupizzeria.rupizzeria.pizza.Pizza;
import projects.rupizzeria.rupizzeria.util.Crust;
import projects.rupizzeria.rupizzeria.util.Size;
import projects.rupizzeria.rupizzeria.util.Topping;

import java.util.ArrayList;

/**
 * Handles orders for Build Your Own Pizza.
 *
 * @author Melissa Xuan
 */
public class BuildYourOwn extends Pizza {
    private final double SMALL_PRICE = 8.99;
    private final double MED_PRICE = 10.99;
    private final double LARGE_PRICE = 12.99;
    private final double TOPPING_PRICE = 1.69;
    private final int MAX_TOPPINGS = 7;

    /**
     * Default constructor for BuildYourOwn pizza.
     */
    public BuildYourOwn() {
        super();
        super.setToppings(new ArrayList<>());
        super.setCrust(Crust.PAN);
        super.setSize(Size.SMALL);
    }

    /**
     * Add a topping to BuildYourOwn pizza if there are less than 7 toppings on the pizza.
     * @param topping topping to be added to the pizza
     */
    public void addTopping(Topping topping) {
        if (super.getToppings().size() < MAX_TOPPINGS)
            super.getToppings().add(topping);
    }

    /**
     * Calculates the price of the BuildYourOwn Pizza.
     * @return price of the BuildYourOwn Pizza
     */
    public double price() {
        double toppingsPrice = super.getToppings().size() * TOPPING_PRICE;
        switch(super.getSize()) {
            case SMALL -> {return SMALL_PRICE + toppingsPrice;}
            case MEDIUM -> {return MED_PRICE + toppingsPrice;}
            case LARGE -> {return LARGE_PRICE + toppingsPrice;}
            default -> {return 0;}
        }
    }
}
