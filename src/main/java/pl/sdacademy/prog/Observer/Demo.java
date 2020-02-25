package pl.sdacademy.prog.Observer;


import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Observer> observers = new ArrayList<>();
        Subject subject = new Subject(observers, 3);
        Observer concreteValueObserver = new ConcreteValueObserver(subject);
        Observer valueLoweredObserver = new ValueLoweredObserver(subject);
        Observer byTenChangedObserver = new ByTenChangedObserver(subject);
        observers.add(concreteValueObserver);
        observers.add(valueLoweredObserver);
        observers.add(byTenChangedObserver);


        subject.changeValue(20);
        subject.changeValue(23);
        subject.changeValue(34);
        subject.changeValue(10);
    }
}
