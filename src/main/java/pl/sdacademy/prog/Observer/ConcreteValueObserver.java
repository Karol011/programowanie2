package pl.sdacademy.prog.Observer;

import lombok.Getter;

@Getter
public class ConcreteValueObserver extends Observer {

    public ConcreteValueObserver(final Subject subject) {
        super(subject);
    }

    @Override
    public void update(int value) {
        System.out.println("value has been changed, new value is: "  + value);
    }
}
