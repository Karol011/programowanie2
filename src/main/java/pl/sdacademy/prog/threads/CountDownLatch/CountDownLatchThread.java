package pl.sdacademy.prog.threads.CountDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchThread implements Runnable {

    private CountDownLatch countDownLatch;
    private static AtomicInteger counter = new AtomicInteger(0);

    public CountDownLatchThread(final CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Math.abs(new Random().nextLong() % 1000));
            //nie wymaga bloku synchronized
            countDownLatch.countDown();
            System.out.println("I am thread " + counter.incrementAndGet() + " that did countdown");
            countDownLatch.await();
            System.out.println("Exiting");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
