package pl.sdacademy.prog.threads.PackedInt;

public class IncrementingThread implements Runnable {

    private PackedInt packedInt;

    public IncrementingThread(final PackedInt packedInt) {
        this.packedInt = packedInt;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            packedInt.increment();
        }
        System.out.println(packedInt.getValue());
    }
}
