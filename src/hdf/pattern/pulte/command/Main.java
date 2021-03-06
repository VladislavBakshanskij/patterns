package hdf.pattern.pulte.command;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
//<editor-fold defaultstate="collapsed" desc="Code with simpleRemoteController" >

//        final SimpleRemoteController remoteController = new SimpleRemoteController();
//        final Light light = new Light();
//        final LightOnCommand lightOn = new LightOnCommand(light);
//
//
//        remoteController.setCommand(lightOn);
//        remoteController.buttonWasPressed();
//
//        final GarageDoor garageDoor = new GarageDoor();
//        final GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
//
//        remoteController.setCommand(garageDoorOpen);
//        remoteController.buttonWasPressed();
//</editor-fold>


        final Light light = new Light();
        final LightOnCommand lightOn = new LightOnCommand(light);
        final LightOffCommand lightOffCommand = new LightOffCommand(light);

        final Stereo stereo = new Stereo();
        final StereoOnCDCommand stereoOnCDCommand = new StereoOnCDCommand(stereo);
        final StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        final GarageDoor garageDoor = new GarageDoor();
        final GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        final GarageDoorCloseCommand garageDoorCloseCommand = new GarageDoorCloseCommand(garageDoor);

        final PartyOnCommand partyOnCommand = new PartyOnCommand(
                new Command[]{lightOn, stereoOnCDCommand, garageDoorCloseCommand});
        final PartyOffCommand partyOffCommand = new PartyOffCommand(
                new Command[]{lightOffCommand, stereoOffCommand, garageDoorOpenCommand});

        RemoteController remoteController = new RemoteController();

        remoteController.setCommand(1, lightOn, lightOffCommand);
        remoteController.setCommand(2, stereoOnCDCommand, stereoOffCommand);
        remoteController.setCommand(0, partyOnCommand, partyOffCommand);

        System.out.println(remoteController);

        remoteController.onButtonWasPressed(1);
        remoteController.offButtonWaPressed(1);
        remoteController.onButtonWasPressed(2);
        remoteController.offButtonWaPressed(2);

        remoteController.undo();

        remoteController.cancel();

        System.out.println();
        System.out.println();
        System.out.println("TIME TO PARTYYYYYY!y!yy!!yy!y!!y!y!y!y!y");
        remoteController.onButtonWasPressed(0);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
            // not like exceptions!
        }
        System.out.println("PARTY IS OF!!!!!!????");
        remoteController.offButtonWaPressed(0);
    }

    public static class SimpleCafe {
        public static void main(String[] args) {
            final Cook cook = new SimpleCook();
            final Order burger = new Burger(cook);
            final Order potatoFree = new PotatoFree(cook);

            final SimpleClient client = new SimpleClient();
            client.setOrders(new Order[]{burger, potatoFree});

            final Waiter waiter = new SimpleWaiter();

            waiter.takeOrder(client.createOrder());
        }

        public interface Order {
            BigDecimal orderUp();
        }

        public interface Waiter {
            BigDecimal takeOrder(Order... orders);
        }

        public interface Cook {
            BigDecimal createBurger();

            BigDecimal createPotatoFree();
        }

        public static class SimpleClient {
            private Order[] orders;

            public void setOrders(Order[] orders) {
                this.orders = orders == null ? new Order[0] : orders;
            }

            public Order[] createOrder() {
                return orders;
            }
        }

        public static class SimpleWaiter implements Waiter {
            @Override
            public BigDecimal takeOrder(Order... orders) {
                BigDecimal sum = BigDecimal.ZERO;

                for (Order order : orders) {
                    sum = sum.add(order.orderUp());
                }

                return sum;
            }
        }

        public static class SimpleCook implements Cook {
            @Override
            public BigDecimal createBurger() {
                System.out.println("make a burger");
                return BigDecimal.valueOf(30);
            }

            @Override
            public BigDecimal createPotatoFree() {
                System.out.println("make a potato free");
                return BigDecimal.valueOf(100);
            }
        }

        public static class Burger implements Order {
            private final Cook cook;

            public Burger(Cook cook) {
                this.cook = cook;
            }

            @Override
            public BigDecimal orderUp() {
                return cook.createBurger();
            }
        }

        public static class PotatoFree implements Order {
            private final Cook cook;

            public PotatoFree(Cook cook) {
                this.cook = cook;
            }

            @Override
            public BigDecimal orderUp() {
                return cook.createPotatoFree();
            }
        }
    }
}
