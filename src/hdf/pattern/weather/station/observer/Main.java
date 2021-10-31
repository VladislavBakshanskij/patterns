package hdf.pattern.weather.station.observer;

import java.util.Observable;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final WeatherData weatherData = new WeatherData();

        final CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        final StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        final ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        final HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(1, 2, 3);
        weatherData.setMeasurements(getRandomFloat(), getRandomFloat(), getRandomFloat());
        weatherData.setMeasurements(12.2f, 13.f, 14f);
    }

    private static float getRandomFloat() {
        final Random random = new Random();
        return random.nextFloat() * 100.0f;
    }


    public static class ObservableImpl extends Observable {

    }
}
