package hdf.pattern.ballSaleMachine.deputy.remoteMonitoring;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GumballMachineRemote extends Remote {
    int getCountOfBall() throws RemoteException;

    String getLocation() throws RemoteException;

    State getCurrentState() throws RemoteException;
}
