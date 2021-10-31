package hdf.pattern.pizza.factory.factoryMethod;

public abstract class PizzaStore {
    public Pizza orderPizza(String pizzaType) {
        final Pizza pizza = createPizza(pizzaType);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * Можно сравнить по типу пиццы чтобы вернуть опред пиццу
     */
    public abstract Pizza createPizza(String pizzaType);
}
