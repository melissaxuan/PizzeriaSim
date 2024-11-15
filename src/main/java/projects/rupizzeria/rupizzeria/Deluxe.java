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
        super.setToppings(new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.ONION,Topping.MUSHROOM)));
        super.setCrust(Crust.DEEPDISH);
        super.setSize(Size.SMALL);
    }
    /**
     * Parameter BBQChicken constructor.
     * @param pizzaStyle style of pizza 2 new york or 1 chicago
     * @param size size of the pizza
     */
    public Deluxe(int pizzaStyle, String size)
    {
        super();
        super.setToppings(new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.ONION,Topping.MUSHROOM)));
        if(pizzaStyle ==CHICAGO_STYLE)
        {
            super.setCrust(Crust.DEEPDISH);
        }
        else if(pizzaStyle ==NEWYORK_STYLE)
        {
            super.setCrust(Crust.BROOKLYN);
        }
        else
        {
            super.setCrust(Crust.DEEPDISH);
        }
        this.sizeCheck(size);
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


