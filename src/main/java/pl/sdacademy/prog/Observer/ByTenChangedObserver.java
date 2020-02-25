package pl.sdacademy.prog.Observer;

public class ByTenChangedObserver extends Observer {

    public ByTenChangedObserver(final Subject subject) {
        super(subject);
    }

    @Override
    public void update(int value) {
    }
}
