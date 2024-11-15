package projects.rupizzeria.rupizzeria;

public class NYPizza implements PizzaFactory{
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

    public Pizza createDeluxe(int style,String size) {
        return new Deluxe(style,size);
    }

    public Pizza CreateMeatzza(int style,String size) {
        return new Meatzza(style,size);
    }

    public Pizza createBBQChicken(int style,String size) {
        return new BBQChicken(style,size);
    }

}
