package hdf.pattern.ballSaleMachine.state;

public class SoldState implements State {
    private GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn’t get you another gumball!");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCountOfBall() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else  {
            gumballMachine.setState(gumballMachine.getSoldOutState());
            System.out.println("Oops, out of gumballs!"); // шарики кончились
        }
    }
}
