package pl.sdacademy.prog.Observer;

import lombok.Getter;

@Getter
public class ValueLoweredObserver extends Observer {
    private int value = subject.getValue();

    public ValueLoweredObserver(final Subject subject) {
        super(subject);
    }

    @Override
    public void update(int value) {
        if (this.getValue() > value) {
            System.out.println("new value is smaller, new value is: " + value);
        }
        this.value = value;
    }
}
