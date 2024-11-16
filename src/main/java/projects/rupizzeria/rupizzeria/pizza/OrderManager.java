package projects.rupizzeria.rupizzeria.pizza;

import projects.rupizzeria.rupizzeria.util.Order;

import java.util.ArrayList;

/**
 * Manages orders.
 */
public class OrderManager {
    private Order currOrder;
    private ArrayList<Order> orderList;

    /**
     * Default constructor for OrderManager.
     */
    public OrderManager() {
        this.currOrder = new Order();
        this.orderList = new ArrayList<Order>();
    }

    public void addPizza(Pizza pizza) {
        this.currOrder.addPizza(pizza);
    }

    public void removePizza(int index) {
        this.currOrder.removePizza(index);
    }

    public void placeOrder() {
        Order o = this.currOrder;
        this.orderList.add(o);
    }
}
