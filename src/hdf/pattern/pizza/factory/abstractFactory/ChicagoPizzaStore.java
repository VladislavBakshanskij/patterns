package hdf.pattern.pizza.factory.abstractFactory;

import hdf.pattern.pizza.factory.abstractFactory.ingredient.PizzaIngredientFactory;
import hdf.pattern.pizza.factory.abstractFactory.ingredient.chicago.ChicagoPizzaIngredientFactory;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String pizzaType) {
        final Pizza pizza;
        final PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();
        if (pizzaType.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("Chicago cheese pizza");
        } else if (pizzaType.equalsIgnoreCase("clam")) {
            pizza = new ClamPizza(pizzaIngredientFactory);
            pizza.setName("Chicago clam pizza");
        } else if (pizzaType.equalsIgnoreCase("veggie")) {
            pizza = new VeggiePizza(pizzaIngredientFactory);
            pizza.setName("Chicago veggie pizza");
        } else {
            throw new UnsupportedOperationException("Pizza not supported " + pizzaType);
        }
        return pizza;
    }
}
