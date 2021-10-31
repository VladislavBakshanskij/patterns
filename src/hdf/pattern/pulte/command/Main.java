package hdf.pattern.pulte.command;

public class Main {
    public static void main(String[] args) {
        final SimpleRemoteController remoteController = new SimpleRemoteController();
        final Light light = new Light();
        final LightOnCommand lightOn = new LightOnCommand(light);


        remoteController.setCommand(lightOn);
        remoteController.buttonWasPressed();

        final GarageDoor garageDoor = new GarageDoor();
        final GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);

        remoteController.setCommand(garageDoorOpen);
        remoteController.buttonWasPressed();
    }
}
