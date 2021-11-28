package hdf.pattern.ballSaleMachine.deputy.defender;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        new Test().test();
    }

    public static class Test {
        private static final Map<String, PersonBean> db = new HashMap<>();

        static {
            db.put("vlad", new PersonBeanImpl("Vlad", "male", "programming"));
            db.put("oleg", new PersonBeanImpl("Oleg", "female", "football"));
        }

        public void test() {
            final PersonBean vladOwnerProxy = getOwnerProxy(getFromDb("vlad"));
            System.out.println(vladOwnerProxy.getName());
            System.out.println(vladOwnerProxy.getGender());
            System.out.println(vladOwnerProxy.getInterests());

            vladOwnerProxy.setName("Vladislav");
            System.out.println(vladOwnerProxy.getName());

            try {
                vladOwnerProxy.setHotOrNotRating(10000000);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("\t\tError\n\n");
            }

            final PersonBean olegNotOwnerProxy = getNotOwnerProxy(getFromDb("oleg"));
            System.out.println(olegNotOwnerProxy.getName());
            System.out.println(olegNotOwnerProxy.getGender());
            System.out.println(olegNotOwnerProxy.getInterests());

            olegNotOwnerProxy.setHotOrNotRating(10);
            System.out.println(olegNotOwnerProxy.getHotOrNotRating());

            try {
                olegNotOwnerProxy.setName("OLEG");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("\t\tError\n\n");
            }
        }

        private PersonBean getOwnerProxy(final PersonBean source) {
            return (PersonBean) Proxy.newProxyInstance(source.getClass().getClassLoader(),
                    source.getClass().getInterfaces(),
                    new OwnerInvocationHandler(source));
        }

        private PersonBean getNotOwnerProxy(final PersonBean source) {
            return (PersonBean) Proxy.newProxyInstance(source.getClass().getClassLoader(),
                    source.getClass().getInterfaces(),
                    new NotOwnerInvocationHandler(source));
        }

        private PersonBean getFromDb(final String personName) {
            return db.get(personName);
        }
    }
}
