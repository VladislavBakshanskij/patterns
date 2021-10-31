package hdf.pattern.weather.station.observer;

/**
 * Подтребитель подписки(Наблюдатель)
 */
public interface Observer {
    void update(float temp, float humidity, float pressure);
}
