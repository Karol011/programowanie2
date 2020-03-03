package pl.sdacademy.prog.threads.myThreadTests;

public class Number {
    private int number;

    public Number(final int number) {
        this.number = number;
    }

    public synchronized void increment() {
        number++;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(final int number) {
        this.number = number;
    }
}
