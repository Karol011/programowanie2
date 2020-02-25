package pl.sdacademy.prog.Observer;

public abstract class Observer {
    public Subject subject;

    public abstract void update(int value);

    public Observer(final Subject subject) {
        this.subject = subject;
    }
}
