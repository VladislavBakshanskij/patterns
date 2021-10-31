package hdf.pattern.ducks.strategy;

public class FlyRocketPower implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Fly rocket power!!!");
    }
}
