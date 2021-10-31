package hdf.pattern.pizza.factory.abstractFactory;

public class Main {
    public static void main(String[] args) {
        PizzaStore nyPs = new NYPizzaStore();
        PizzaStore chicagoPs = new ChicagoPizzaStore();

        final Pizza nyPizza = nyPs.orderPizza("cheese");
        System.out.println("Pizza for Oleg " + nyPizza.getName());

        final Pizza chicagoPizza = chicagoPs.orderPizza("cheese");
        System.out.println("Pizza for John " + chicagoPizza.getName());
    }
}
