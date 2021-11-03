package hdf.pattern.pulte.command;

public class RemoteController {
    private Command[] onCommands;
    private Command[] offCommands;

    public RemoteController() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        final Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWaPressed(int slot) {
        offCommands[slot].execute();
    }

    @Override
    public String toString() {
        StringBuilder stringBuff = new StringBuilder();
        stringBuff.append("\n------Remote Control------ -\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot ")
                        .append(i)
                    .append("]\t")
                        .append(onCommands[i].getClass().getSimpleName())
                    .append("\t")
                        .append(offCommands[i].getClass().getSimpleName())
                    .append("\n");
        }
        return stringBuff.toString();
    }
}
