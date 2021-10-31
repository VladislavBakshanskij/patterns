package hdf.pattern.pizza.factory.abstractFactory.ingredient.ny;

import hdf.pattern.pizza.factory.abstractFactory.ingredient.Dough;

public class ThinCrustDough implements Dough {
    @Override
    public String getName() {
        return "thin crust dough";
    }
}
