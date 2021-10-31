package hdf.pattern.pizza.factory.abstractFactory.ingredient;

public interface Veggies {
    default String getName() {
        return this.getClass().getSimpleName().toLowerCase(); // return special name of implementation interface in lower case.
    }
}
