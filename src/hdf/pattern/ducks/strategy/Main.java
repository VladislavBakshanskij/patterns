package hdf.pattern.ducks.strategy;

public class Main {
    public static void main(String[] args) {
        Duck d = new MallardDuck();
        d.performFly();
        d.performQuack();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPower());
        model.performFly();
    }
}
