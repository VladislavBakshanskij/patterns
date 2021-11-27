package hdf.pattern.ballSaleMachine.deputy.rmi;

import java.rmi.RemoteException;

public class MyServiceImpl implements MyService {
    private static final long serialVersionUID = 1L;

    public MyServiceImpl() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        return "result from server";
    }
}