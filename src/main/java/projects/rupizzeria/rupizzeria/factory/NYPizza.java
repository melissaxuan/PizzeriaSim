package projects.rupizzeria.rupizzeria.factory;

import projects.rupizzeria.rupizzeria.factory.impl.BBQChicken;
import projects.rupizzeria.rupizzeria.factory.impl.BuildYourOwn;
import projects.rupizzeria.rupizzeria.factory.impl.Deluxe;
import projects.rupizzeria.rupizzeria.factory.impl.Meatzza;
/**
 * Class for the NewYork pizza choice
 * @author Michael Ehresman
 */
public class NYPizza implements PizzaFactory {
    /**
     * Method to createDeluxe pizzas
     * @return new deluxe pizza
     */
    public Pizza createDeluxe() {
        return new Deluxe();
    }
    /**
     * Method to createMeatzza pizzas
     * @return new Meatzza pizza
     */
    public Pizza createMeatzza() {
        return new Meatzza();
    }
    /**
     * Method to create BBQChicken pizzas
     * @return new BBQChicken pizza
     */
    public Pizza createBBQChicken() {
        return new BBQChicken();
    }
    /**
     * Method to create your own pizzas
     * @return new self created pizza
     */
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn();
    }
}
