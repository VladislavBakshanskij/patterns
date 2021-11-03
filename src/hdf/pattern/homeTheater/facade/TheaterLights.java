package hdf.pattern.homeTheater.facade;

public class TheaterLights {
    public void dim(int lightVolume) {
        System.out.printf("Set up light to %d%n", lightVolume);
    }

    public void on() {
        System.out.println("Light on");
    }
}
