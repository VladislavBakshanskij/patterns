package hdf.pattern.homeTheater.facade;

public class Amplifier {
    public void on() {
        System.out.println("Amplifier is on");
    }

    public void setDvd(DvdPlayer dvd) {
        System.out.println("Set dvd " + dvd.getName());
    }

    public void setSurroundSound() {
        System.out.println("Set up surround sound");
    }

    public void setVolume(int volume) {
        System.out.println("Set up volume to " + volume);
    }

    public void off() {
        System.out.println("Amplifier is off");
    }
}
