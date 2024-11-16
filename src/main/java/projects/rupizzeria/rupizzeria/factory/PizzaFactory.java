package projects.rupizzeria.rupizzeria.factory;

/**
 * interface for the types of pizza made in the factory
 * @author Michael Ehresman
 */
public interface PizzaFactory {
    Pizza createDeluxe();
    Pizza createMeatzza();
    Pizza createBBQChicken();
    Pizza createBuildYourOwn();
}
