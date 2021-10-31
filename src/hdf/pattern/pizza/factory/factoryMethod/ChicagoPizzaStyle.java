package hdf.pattern.pizza.factory.factoryMethod;

public class ChicagoPizzaStyle extends Pizza {
    public ChicagoPizzaStyle() {
        name = "Chicago pizza style";
        dough = "Extra thick crust dough";
        sauce = "Plum tomato sauce";

        toppings.add("Mozzarella");
    }

    @Override
    public void cut() {
        System.out.println("Cut your pizza on square");
    }
}
