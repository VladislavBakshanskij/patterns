package hdf.pattern.pulte.command;

public class Stereo {
    public void off() {
        System.out.println("stereo is off");
    }

    public void on() {
        System.out.println("Stereo is on");
    }

    public void setCD() {
        System.out.println("set up cd in stereo");
    }

    public void setVolume(int volume) {
        System.out.println(volume + " is set up");
    }
}
