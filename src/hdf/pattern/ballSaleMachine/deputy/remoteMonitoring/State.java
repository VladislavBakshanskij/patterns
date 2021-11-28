package hdf.pattern.ballSaleMachine.deputy.remoteMonitoring;

import java.io.Serializable;

public interface State extends Serializable {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();

    default void refill() {
        System.out.println("Can't fill machine");
    }
}
