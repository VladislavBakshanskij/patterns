package hdf.pattern.pizza.factory.abstractFactory.ingredient.chicago;

import hdf.pattern.pizza.factory.abstractFactory.ingredient.Clams;

public class FrozenClams implements Clams {
    @Override
    public String getName() {
        return "frozen clams";
    }
}
