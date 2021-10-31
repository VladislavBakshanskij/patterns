package hdf.pattern.pizza.factory.abstractFactory.ingredient.chicago;

import hdf.pattern.pizza.factory.abstractFactory.ingredient.*;
import hdf.pattern.pizza.factory.abstractFactory.ingredient.ny.SlicesPepperoni;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{
                new BlackOlives(), new Spinach(), new EggPlant()
        };
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicesPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}
