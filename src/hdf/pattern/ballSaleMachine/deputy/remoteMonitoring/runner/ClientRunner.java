package hdf.pattern.ballSaleMachine.deputy.remoteMonitoring.runner;

import hdf.pattern.ballSaleMachine.deputy.remoteMonitoring.GumballMachineRemote;
import hdf.pattern.ballSaleMachine.deputy.remoteMonitoring.GumballMonitor;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRunner {
    // example: java -jar Moscow
    public static void main(String[] args) {
        try {
            System.out.println("Connect to server...");
            final Registry registry = LocateRegistry.getRegistry(2099);
            System.out.println("Connecting to server success.");
            GumballMachineRemote gumballMachine = (GumballMachineRemote) registry.lookup(args[0]);
            final GumballMonitor monitor = new GumballMonitor(gumballMachine);
            System.out.println("\nReport:\n");
            monitor.report();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}

