package projects.rupizzeria.rupizzeria.factory;

import projects.rupizzeria.rupizzeria.factory.impl.BBQChicken;
import projects.rupizzeria.rupizzeria.factory.impl.BuildYourOwn;
import projects.rupizzeria.rupizzeria.factory.impl.Deluxe;
import projects.rupizzeria.rupizzeria.factory.impl.Meatzza;

/**
 * Handles orders for New York-style pizza.
 *
 * @author Melissa Xuan
 */
public class NYPizza implements PizzaFactory {
    /**
     * Creates New York-style Deluxe pizza.
     * @return New York-style Deluxe pizza.
     */
    public Pizza createDeluxe() {
        return new Deluxe();
    }

    /**
     * Creates New York-style Meatzza pizza.
     * @return New York-style
     */
    public Pizza createMeatzza() {
        return new Meatzza();
    }

    public Pizza createBBQChicken() {
        return new BBQChicken();
    }

    public Pizza createBuildYourOwn() {
        return new BuildYourOwn();
    }
}
