package projects.rupizzeria.rupizzeria.util;

import projects.rupizzeria.rupizzeria.factory.Pizza;

import java.util.ArrayList;

/**
 * Keeps track of Order details.
 */
public class Order {
    private int number;
    private ArrayList<Pizza> pizzas;

    /**
     * Default constructor for Order.
     */
    public Order() {
        number = 0;
        pizzas = new ArrayList<Pizza>();
    }

    /**
     * Returns Order ID number.
     * @return Order number.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns list of Pizzas in this Order.
     * @return list of Pizzas in this Order
     */
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * Sets Order ID number.
     * @param number Order ID number
     */
    public void setNumber(int number) {
        this.number = number;
    }
}
