package pl.sdacademy.prog.Observer;

import lombok.Getter;

@Getter
public class ByTenChangedObserver extends Observer {
    private int value = subject.getValue();

    public ByTenChangedObserver(final Subject subject) {
        super(subject);
    }

    @Override
    public void update(int value) {
        if (value - this.getValue() > 10) {
            System.out.println("new value is bigger by at least 10, new value is: " + value);
        }
        if (this.getValue() - value > 10) {
            System.out.println("new value is smaller by at least 10, new value is: " + value);
        }
        this.value = value;
    }
}
