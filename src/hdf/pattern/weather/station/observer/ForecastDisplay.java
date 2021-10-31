package hdf.pattern.weather.station.observer;

public class ForecastDisplay implements Observer, DisplayElement {
    private float temp;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        display();
    }

    @Override
    public void display() {
        System.out.printf("ForecastDisplay: temp=%s\n", temp);
    }
}
