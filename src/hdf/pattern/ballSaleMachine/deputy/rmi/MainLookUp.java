package hdf.pattern.ballSaleMachine.deputy.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainLookUp {
    public static void main(String[] args) {
        try {
            final Registry registry = LocateRegistry.getRegistry(2099);
            final MyService service = (MyService) registry.lookup("myService");
            System.out.println(service.sayHello());
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
