package hdf.pattern.pizza.factory.factoryMethod;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String pizzaType) {
        return new ChicagoPizzaStyle();
    }
}
