package pl.sdacademy.prog.Observer;

public class ValueLoweredObserver extends Observer {

    public ValueLoweredObserver(final Subject subject) {
        super(subject);
    }

    @Override
    public void update(int value) {
    }
}
