package hdf.pattern.ballSaleMachine.state;

public interface State {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();

    default void refill() {
        System.out.println("Can't fill machine");
    }
}
