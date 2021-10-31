package hdf.pattern.pizza.factory.abstractFactory;

import hdf.pattern.pizza.factory.abstractFactory.ingredient.*;

import java.util.Arrays;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Veggies[] veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;

    abstract void prepare();

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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", veggies=" + Arrays.toString(veggies) +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", clam=" + clam +
                '}';
    }
}
