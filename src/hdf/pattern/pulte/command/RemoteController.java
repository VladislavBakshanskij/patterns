package hdf.pattern.pulte.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoteController {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;

    // здесь будет хранится история нажатия на клавиши
    // таким образом можно отменить нажатые операции
    private Deque<Command> history = new ArrayDeque<>(15); // у нас есть всего 14 комманд

    public RemoteController() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        final Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
        history.push(onCommands[slot]);
    }

    public void offButtonWaPressed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
        history.push(offCommands[slot]);
    }

    public void undo() {
        System.out.println("Execute undo command");
        undoCommand.undo();
        history.pop(); // удаляем операцию при нажатии назад
    }

    public void cancel() {
        System.out.println("Execute cancel");
        // пока в истории есть команды, которые нужно откатить, то выполянем у нихъ undo
        while (!history.isEmpty()) {
            history.pop().undo();
        }
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
