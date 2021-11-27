package hdf.pattern.ballSaleMachine.deputy.rmi;


import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyService extends Remote, Serializable {
    String sayHello() throws RemoteException;
}