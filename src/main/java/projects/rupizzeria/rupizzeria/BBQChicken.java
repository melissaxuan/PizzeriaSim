package projects.rupizzeria.rupizzeria;

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
        super.setToppings(new ArrayList<>(Arrays.asList(Topping.BBQ_CHICKEN, Topping.GREENPEPPER, Topping.PROVOLONE, Topping.CHEDDER)));
        super.setCrust(Crust.PAN);
        super.setSize(Size.SMALL);
    }
    /**
     * Parameter BBQChicken constructor.
     * @param pizzaStyle style of pizza 2 new york or 1 chicago
     * @param size size of the pizza
     */
    public BBQChicken(int pizzaStyle, String size)
    {
        super();
        super.setToppings(new ArrayList<>(Arrays.asList(Topping.BBQ_CHICKEN, Topping.GREENPEPPER, Topping.PROVOLONE, Topping.CHEDDER)));
        if(pizzaStyle ==CHICAGO_STYLE)
        {
            super.setCrust(Crust.PAN);
        }
        else if(pizzaStyle ==NEWYORK_STYLE)
        {
            super.setCrust(Crust.THIN);
        }
        else
        {
            super.setCrust(Crust.PAN);
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
