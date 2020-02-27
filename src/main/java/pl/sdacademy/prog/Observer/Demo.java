package pl.sdacademy.prog.Observer;


import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        Subject subject = new Subject(new ArrayList<>(), 3);
        Observer concreteValueObserver = new ConcreteValueObserver(subject);
        Observer valueLoweredObserver = new ValueLoweredObserver(subject);
        Observer byTenChangedObserver = new ByTenChangedObserver(subject);
        subject.registerObserver(concreteValueObserver);
        subject.registerObserver(valueLoweredObserver, byTenChangedObserver);


        subject.changeValue(20);
        subject.changeValue(23);
        subject.changeValue(34);
        subject.changeValue(10);
    }
}
