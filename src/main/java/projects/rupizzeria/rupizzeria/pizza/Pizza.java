package projects.rupizzeria.rupizzeria.pizza;

import projects.rupizzeria.rupizzeria.util.Crust;
import projects.rupizzeria.rupizzeria.util.Size;
import projects.rupizzeria.rupizzeria.util.Topping;

import java.util.ArrayList;

/**
 * Describes the pizza type.
 * @author Melissa Xuan
 */
public abstract class Pizza {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;

    /**
     * Default constructor for the pizza class
     */
    public Pizza() {
        toppings = new ArrayList<>();
    }

    /**
     * Abstract classes for subclasses of pizza to implement to get the pizza price
     * @return the price of the pizza
     */
    public abstract double price();

    /**
     * Getter method for the toppings arraylist
     * @return the toppings
     */
    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    /**
     * Sets the toppings on a pizza
     * @param toppings toppings to be added
     */
    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    /**
     * Getter method to get the crust of the pizza
     * @return the crust of the pizza
     */
    public Crust getCrust() {
        return crust;
    }

    /**
     * Sets the crust of the pizza
     * @param crust crust to be set
     */
    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    /**
     * Getter method to get the size of the pizza
     * @return the size of the pizza
     */
    public Size getSize() {
        return size;
    }

    /**
     * Sets the size of the pizza
     * @param size size to be set
     */
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return this.getSize().toString() + " " + Object.class + ": Toppings [" + this.toppings + "], "
                + this.getCrust().toString() + " Crust";
    }
}