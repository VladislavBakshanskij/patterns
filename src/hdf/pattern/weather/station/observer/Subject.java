package hdf.pattern.weather.station.observer;

/**
 * Субъект(рассыльщик)
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
