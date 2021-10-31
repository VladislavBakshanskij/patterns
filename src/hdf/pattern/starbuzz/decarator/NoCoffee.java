package hdf.pattern.starbuzz.decarator;

public class NoCoffee extends Beverage {
    public NoCoffee() {
        description = "No coffee";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
