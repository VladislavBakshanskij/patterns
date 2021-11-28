package hdf.pattern.ballSaleMachine.deputy.defender;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler {
    private final PersonBean source;

    public OwnerInvocationHandler(final PersonBean source) {
        this.source = source;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            if (method.getName().startsWith("get")) {
                return method.invoke(source, args);
            } else if (method.getName().equalsIgnoreCase("setHotOrNotRating")) {
                throw new IllegalStateException("self set rating not work!");
            } else if (method.getName().startsWith("set")) {
                method.invoke(source, args);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
