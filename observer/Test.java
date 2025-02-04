package DESIGNPATTERNS.observer;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String args[]){
        WeatherStation ws = new WeatherStation();

        PhoneDisplay pd = new PhoneDisplay();
        TVDisplay td = new TVDisplay();
        ws.addObserver(pd);
        ws.addObserver(td);

        ws.notifyObservers("sunny"); // updates pd and td automatically
    }
}


interface
Observer{
    void updateWeather(String weather);
}


class PhoneDisplay implements Observer{
    String weather;
    public void updateWeather(String weather){
        this.weather = weather;
        display();
    }

    public void display(){
        System.out.println(this.weather);
    }
}

class TVDisplay implements Observer{
    String weather;
    public void updateWeather(String weather){
        this.weather = weather;
        display();
    }

    public void display(){
        System.out.println(this.weather);
    }
}


interface Subject{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String weather);
}

class WeatherStation implements Subject{

    List<Observer> observers = new ArrayList<>();

    private String weather;

    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    };

    @Override
    public void notifyObservers(String weather){
        this.weather = weather;
        for( Observer ele:observers){
            ele.updateWeather(weather);
        }
    };
}
