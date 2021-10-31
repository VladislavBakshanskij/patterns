package hdf.pattern.pizza.factory.factoryMethod;

public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String pizzaType) {
        return new NYPizzaStyle();
    }
}
