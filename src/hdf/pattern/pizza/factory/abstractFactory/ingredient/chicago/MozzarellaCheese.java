package hdf.pattern.pizza.factory.abstractFactory.ingredient.chicago;

import hdf.pattern.pizza.factory.abstractFactory.ingredient.Cheese;

public class MozzarellaCheese implements Cheese {
    @Override
    public String getName() {
        return "mozzarella";
    }
}
