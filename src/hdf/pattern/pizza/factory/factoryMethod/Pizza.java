package hdf.pattern.pizza.factory.factoryMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;

    List<String> toppings = new ArrayList<>();

    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        for (String topping : toppings) {
            System.out.println("--> " + topping);
        }
    }

    public void bake() {
        System.out.println("Bake. Wait 25 min...");
    }

    public void cut() {
        System.out.println("Cut your pizza on slice");
    }

    public void box() {
        System.out.println("Box your pizza");
    }

    public String getName() {
        return name;
    }

    public String getDough() {
        return dough;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getToppings() {
        return toppings;
    }
}
