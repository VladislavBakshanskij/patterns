package hdf.pattern.pizza.factory.factoryMethod;

public class NYPizzaStyle extends Pizza {
    public NYPizzaStyle() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }
}
