package projects.rupizzeria.rupizzeria;

import java.util.ArrayList;

public abstract class Pizza {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    static final int CHICAGO_STYLE = 1;
    static final int NEWYORK_STYLE= 2;

    public Pizza() {
        toppings = new ArrayList<>();
    }
    public abstract double price();

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void sizeCheck(String size)
    {
        switch(size) {
            case "Small":
                this.setSize(Size.SMALL);
                break;
            case "Medium":
                this.setSize(Size.MEDIUM);
                break;
            case "Large":
                this.setSize(Size.LARGE);
                break;
            default:
                this.setSize(Size.SMALL);
                break;
        }
    }
}
