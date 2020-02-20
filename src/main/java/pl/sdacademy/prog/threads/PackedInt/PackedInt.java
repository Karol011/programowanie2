package pl.sdacademy.prog.threads.PackedInt;

public class PackedInt {
    private int value;

    public PackedInt(final int value) {
        this.value = value;
    }

    public synchronized void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}
