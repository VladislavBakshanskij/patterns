package hdf.pattern.ballSaleMachine.deputy.remoteMonitoring;

import java.util.Random;

public class HasQuarterState implements State {
    private final Random random = new Random();
    private GumballMachine gumballMachine;

    public HasQuarterState(final GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        final int chance = random.nextInt(10);
        if (chance == 0 && gumballMachine.getCountOfBall() > 1) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
