package hdf.pattern.ballSaleMachine.state;

public class GumballMachine {
    private final State soldOutState;
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    private final State winnerState;

    private State currentState;
    private int countOfBall;

    public GumballMachine(int countOfBall) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.countOfBall = countOfBall;
        this.currentState = countOfBall > 0 ? noQuarterState : soldOutState;
    }

    public void insertQuarter() {
        currentState.insertQuarter();
    }

    public void ejectQuarter() {
        currentState.ejectQuarter();
    }

    public void turnCrank() {
        currentState.turnCrank();
        currentState.dispense();
    }

    public void setState(final State state) {
        this.currentState = state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (countOfBall != 0) {
            countOfBall -= 1;
        }
    }

    public void refill(final int countOfBall) {
        this.countOfBall = countOfBall;
        if (countOfBall > 0) {
            currentState.refill();
        }
    }

    @Override
    public String toString() {
        return "Machine{" +
                "currentState=" + currentState +
                ", countOfBall=" + countOfBall +
                '}';
    }

    public int getCountOfBall() {
        return countOfBall;
    }
}
