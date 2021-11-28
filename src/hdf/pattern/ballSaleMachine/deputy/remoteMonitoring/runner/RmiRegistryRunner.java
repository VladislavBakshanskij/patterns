package hdf.pattern.ballSaleMachine.deputy.remoteMonitoring.runner;

import java.rmi.registry.LocateRegistry;

public class RmiRegistryRunner {
    // rmi server emulator
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(2099);
            System.out.println("-> RMI server has been started");
            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

