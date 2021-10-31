package hdf.pattern.weather.station.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData; // используется для отмены подписки

    /**
     * Конструктору передается
     * объект WeatherData, который
     * используется для регистрации
     * элемента в качестве наблюдателя
     */
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.printf("Current conditions: temperature=%s, humidity=%s\n", temperature, humidity);
    }
}
