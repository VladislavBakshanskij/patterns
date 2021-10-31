package hdf.pattern.pizza.factory.abstractFactory.ingredient.ny;

import hdf.pattern.pizza.factory.abstractFactory.ingredient.Sauce;

public class MarinaraSauce implements Sauce {
    @Override
    public String getName() {
        return "marinara sauce";
    }
}
