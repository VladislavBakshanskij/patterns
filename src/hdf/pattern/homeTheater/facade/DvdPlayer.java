package hdf.pattern.homeTheater.facade;

public class DvdPlayer {
    public String getName() {
        return "Super dvb";
    }

    public void on() {
        System.out.println("Dvd is on");
    }

    public void play(String movie) {
        System.out.println("Playing move " + movie);
    }

    public void stop() {
        System.out.println("Dvd player stop playing");
    }

    public void eject() {
        System.out.println("Eject of dvd player");
    }

    public void off() {
        System.out.println("Off dvd player");
    }
}
