package hdf.pattern.pulte.command;

public class StereoOffCommand implements Command {
    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.setCD();
        stereo.setVolume(11);
        stereo.on();
    }
}
