package pl.sdacademy.prog.Observer;

import lombok.Getter;

import java.util.List;

@Getter
public class Subject {

    private List<Observer> observerList;
    private int value;

    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    public void changeValue(int value) {
        this.value = value;
    }

    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
