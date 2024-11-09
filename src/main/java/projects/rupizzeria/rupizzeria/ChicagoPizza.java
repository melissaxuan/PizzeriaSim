package projects.rupizzeria.rupizzeria;

public class ChicagoPizza implements PizzaFactory{
    public Pizza createDeluxe() {
        return new Deluxe();
    }

    public Pizza CreateMeatzza() {
        return new Meatzza();
    }

    public Pizza createBBQChicken() {
        return new BBQChicken();
    }

    public Pizza createBuildYourOwn() {
        return new BuildYourOwn();
    }
}
