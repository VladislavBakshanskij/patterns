package hdf.pattern.ballSaleMachine.deputy.remoteMonitoring.runner;

import hdf.pattern.ballSaleMachine.deputy.remoteMonitoring.GumballMachine;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MachineRunner {
    // example: java -jar Moscow 10
    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                throw new IllegalStateException("Invalid args len");
            }

            final int countOfBall = Integer.parseInt(args[1]);
            System.out.println("Connect to server...");
            final Registry registry = LocateRegistry.getRegistry(2099);
            System.out.println("Connecting to server success.");

            final String machineLocation = args[0];
            registry.bind(machineLocation, new GumballMachine(machineLocation, countOfBall));
            System.out.printf("Machine has been registered with name %s", machineLocation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

