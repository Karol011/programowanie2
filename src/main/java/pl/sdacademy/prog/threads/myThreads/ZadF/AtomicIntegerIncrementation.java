package pl.sdacademy.prog.threads.myThreads.ZadF;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerIncrementation implements Runnable {

    private AtomicInteger atomicInteger;
    private final int MAX_VALUE = 10000;

    public AtomicIntegerIncrementation(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    @Override
    public synchronized void run() {
        while (atomicInteger.get() <= MAX_VALUE) {
            System.out.println("Value = " + atomicInteger.getAndIncrement() +
                    " operation performed by thread "+ Thread.currentThread().getId());

        }
    }
}
