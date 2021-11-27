package hdf.pattern.ballSaleMachine.deputy.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            final MyService myService = new MyServiceImpl();
            final Registry registry = LocateRegistry.createRegistry(2099);
            registry.bind("myService", UnicastRemoteObject.exportObject(myService, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
