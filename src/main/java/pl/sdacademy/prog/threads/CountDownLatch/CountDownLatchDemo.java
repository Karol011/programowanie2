package pl.sdacademy.prog.threads.CountDownLatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        final int cdlCounter = 5;
        final CountDownLatch countDownLatch = new CountDownLatch(cdlCounter);
        final List<Thread> threads = Stream
                .generate(() -> new Thread(new CountDownLatchThread(countDownLatch)))
                .limit(cdlCounter)
                .collect(Collectors.toList());

        threads.forEach(Thread::start);
        threads.forEach(tr -> {
            try {
                tr.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
