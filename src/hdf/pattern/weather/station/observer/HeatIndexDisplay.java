package hdf.pattern.weather.station.observer;

import java.util.Random;

public class HeatIndexDisplay implements Observer, DisplayElement {
    private float temp;
    private float humidity;
    public WeatherData weatherData;

    public HeatIndexDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        float heatIndex =  new Random().nextFloat() * 1000;
        System.out.printf("Heat index: %s\n", heatIndex);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }
}
