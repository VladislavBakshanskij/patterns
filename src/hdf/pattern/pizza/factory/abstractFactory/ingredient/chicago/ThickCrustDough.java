package hdf.pattern.pizza.factory.abstractFactory.ingredient.chicago;

import hdf.pattern.pizza.factory.abstractFactory.ingredient.Dough;

public class ThickCrustDough implements Dough {
    @Override
    public String getName() {
        return "thin crust dough";
    }
}
