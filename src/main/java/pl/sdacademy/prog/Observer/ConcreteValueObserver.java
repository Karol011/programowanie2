package pl.sdacademy.prog.Observer;

public class ConcreteValueObserver extends Observer {
    @Override
    public void update() {
        System.out.println("value has been changed, new value is: " );
    }
}
