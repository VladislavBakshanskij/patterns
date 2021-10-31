package hdf.pattern.starbuzz.decarator;

public class DarkRoad extends Beverage {
    public DarkRoad() {
        description = "Dark road";
    }

    @Override
    public double cost() {
        return .99;
    }
}
