package hdf.pattern.ballSaleMachine.deputy.defender;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NotOwnerInvocationHandler implements InvocationHandler {
    private final PersonBean source;

    public NotOwnerInvocationHandler(PersonBean source) {
        this.source = source;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            if (method.getName().startsWith("get")) {
                return method.invoke(source, args);
            } else if (method.getName().equalsIgnoreCase("setHotOrNotRating")) {
                return method.invoke(source, args);
            } else if (method.getName().startsWith("set")) {
                throw new IllegalStateException("set up info not self doesn't not work");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
