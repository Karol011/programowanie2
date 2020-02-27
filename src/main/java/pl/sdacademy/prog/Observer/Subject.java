package pl.sdacademy.prog.Observer;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class Subject {

    private List<Observer> observerList;
    private int value;

    public Subject(final List<Observer> observerList, final int value) {
        this.observerList = observerList;
        this.value = value;
    }

    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    public void registerObserver(Observer... observers) {
        observerList.addAll(Arrays.asList(observers));
    }

    public void changeValue(int value) {
        this.value = value;
        notifyObservers();
    }

    public void notifyObservers() {

        for (Observer observer : observerList) {
            observer.update(value);
        }

    }
}
