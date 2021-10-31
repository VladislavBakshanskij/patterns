package hdf.pattern.ducks.strategy;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't flyway(");
    }
}
