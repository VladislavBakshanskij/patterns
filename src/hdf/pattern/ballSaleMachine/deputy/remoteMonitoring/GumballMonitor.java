package hdf.pattern.ballSaleMachine.deputy.remoteMonitoring;

import java.rmi.RemoteException;

public class GumballMonitor {
    private final GumballMachineRemote machine;

    public GumballMonitor(final GumballMachineRemote machine) {
        this.machine = machine;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine location: " + machine.getLocation());
            System.out.println("Current inventory: " + machine.getCountOfBall() + " gumballs");
            System.out.println("Current state: " + machine.getCurrentState());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
