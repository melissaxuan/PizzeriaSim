package projects.rupizzeria.rupizzeria;

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
     * Parameter constructor for Meatzaa
     * @param pizzaStyle style of pizza 2 new york or 1 chicago
     * @param size size of the pizza
     */
    public Meatzza(int pizzaStyle, String size)
    {
        super();
        super.setToppings(new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM)));
        if(pizzaStyle ==CHICAGO_STYLE)
        {
            super.setCrust(Crust.STUFFED);
        }
        else if(pizzaStyle ==NEWYORK_STYLE)
        {
            super.setCrust(Crust.HANDTOSSED);
        }
        else
        {
            super.setCrust(Crust.STUFFED);
        }
        this.sizeCheck(size);
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
