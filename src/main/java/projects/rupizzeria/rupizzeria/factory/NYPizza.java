package projects.rupizzeria.rupizzeria.factory;

import projects.rupizzeria.rupizzeria.factory.impl.BBQChicken;
import projects.rupizzeria.rupizzeria.factory.impl.BuildYourOwn;
import projects.rupizzeria.rupizzeria.factory.impl.Deluxe;
import projects.rupizzeria.rupizzeria.factory.impl.Meatzza;

public class NYPizza implements PizzaFactory {
    public Pizza createDeluxe() {
        return new Deluxe();
    }

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
