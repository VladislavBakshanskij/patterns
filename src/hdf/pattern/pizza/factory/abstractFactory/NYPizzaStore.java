package hdf.pattern.pizza.factory.abstractFactory;

import hdf.pattern.pizza.factory.abstractFactory.ingredient.PizzaIngredientFactory;
import hdf.pattern.pizza.factory.abstractFactory.ingredient.ny.NYPizzaIngredientFactory;

public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String pizzaType) {
        final Pizza pizza;
        final PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
        if (pizzaType.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("New York cheese pizza");
        } else if (pizzaType.equalsIgnoreCase("clam")) {
            pizza = new ClamPizza(pizzaIngredientFactory);
            pizza.setName("New York clam pizza");
        } else if (pizzaType.equalsIgnoreCase("veggie")) {
            pizza = new VeggiePizza(pizzaIngredientFactory);
            pizza.setName("New York veggie pizza");
        } else {
            throw new UnsupportedOperationException("Pizza not supported " + pizzaType);
        }
        return pizza;
    }
}
