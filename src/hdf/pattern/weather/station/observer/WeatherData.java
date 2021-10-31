package hdf.pattern.weather.station.observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("<---------------------------------------------->");
        System.out.println("Notify all observers is started");
        observers.forEach(observer -> observer.update(getTemperature(), getHumidity(), getPressure()));
        System.out.println("Notify all observers is end");
        System.out.println("<---------------------------------------------->");
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }


    public static class SwingObserverExample extends JFrame {
        private JFrame frame;

        public static void main(String[] args) {
            new SwingObserverExample().go();
        }

        public void go() {
            frame = new JFrame();

            JButton button = new JButton("Should I do it?");
//            button.addActionListener(new AngelListener());
//            button.addActionListener(new DevilListener());
            button.addActionListener(e -> System.out.println("Angel: don't do it, you might regret it!"));
            button.addActionListener(e -> System.out.println("Devil: come on, do it man!"));

            frame.add(button);
            frame.setSize(600, 1600);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

//        public static class AngelListener implements ActionListener {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Angel: don't do it, you might regret it!");
//            }
//        }
//
//        public static class DevilListener implements ActionListener {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Devil: come on, do it man!");
//            }
//        }
    }
}
