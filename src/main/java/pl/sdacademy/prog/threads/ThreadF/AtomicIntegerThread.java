package pl.sdacademy.prog.threads.ThreadF;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerThread implements Runnable {

    private java.util.concurrent.atomic.AtomicInteger atomicInteger;

    public AtomicIntegerThread(final AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        for (int i = 0; atomicInteger.get() < 10000; i++) {
            System.out.println(atomicInteger.getAndIncrement()+" "+ Thread.currentThread().getId());
        }
        System.out.println(atomicInteger.get());
    }
}



