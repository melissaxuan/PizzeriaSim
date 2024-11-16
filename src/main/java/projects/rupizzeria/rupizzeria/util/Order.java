package projects.rupizzeria.rupizzeria.util;

import projects.rupizzeria.rupizzeria.factory.Pizza;

import java.util.ArrayList;

/**
 * Keeps track of Order details.
 */
public class Order {
    private final int FIRST_ORDER_ID = 1;
    private final double NJ_SALES_TAX_RATE = 0.06625;
    private final double INITIAL_TOTAL = 0;
    private int number;
    private ArrayList<Pizza> pizzas;

    /**
     * Default constructor for Order.
     */
    public Order() {
        number = FIRST_ORDER_ID;
        pizzas = new ArrayList<Pizza>();
    }

    /**
     * Add the Pizza to the Order.
     * @param pizza Pizza to be added to the Order
     */
    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }

    /**
     * Removes the Pizza at the specified index of the Pizza list in Order.
     * @param index index of the Pizza to be removed from Pizza list in Order
     */
    public void removePizza(int index) {
        this.pizzas.remove(index);
    }

    /**
     * Calculates subtotal of Order.
     * @return subtotal of Order
     */
    public double calcSubtotal() {
        double subtotal = INITIAL_TOTAL;

        for (Pizza p : this.pizzas) {
            subtotal += p.price();
        }

        return subtotal;
    }

    /**
     * Calculates sales tax of Order.
     * @return sales tax of Order
     */
    public double calcTaxes() {
        return calcSubtotal() * NJ_SALES_TAX_RATE;
    }

    /**
     * Calculates order total of Order.
     * @return total cost of Order
     */
    public double calcOrderTotal() {
        return calcSubtotal() + calcTaxes();
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
