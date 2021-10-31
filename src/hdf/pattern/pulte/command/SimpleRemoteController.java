package hdf.pattern.pulte.command;

public class SimpleRemoteController {
    private Command slot;

    public SimpleRemoteController() {
    }

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
