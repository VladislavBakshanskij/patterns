package hdf.pattern.homeTheater.facade;

public class Main {
    public static void main(String[] args) {
        final HomeTheaterFacade facade = new HomeTheaterFacade(
                new Amplifier(),
                new Tuner(),
                new DvdPlayer(),
                new CdPlayer(),
                new Projector(),
                new Screen(),
                new TheaterLights(),
                new PopcornPopper()
        );

        facade.watchMovie("Start wars");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }

        System.out.println();
        System.out.println();
        System.out.println();
        facade.endMovie();
    }
}
