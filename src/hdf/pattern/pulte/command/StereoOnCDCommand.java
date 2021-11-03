package hdf.pattern.pulte.command;

public class StereoOnCDCommand implements Command {
    private Stereo stereo;

    public StereoOnCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
