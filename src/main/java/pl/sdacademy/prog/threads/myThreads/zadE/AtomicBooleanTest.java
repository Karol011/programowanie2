package pl.sdacademy.prog.threads.myThreads.zadE;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AtomicBooleanTest implements Runnable {
    private AtomicBoolean flag = new AtomicBoolean(false);
    private static AtomicInteger counter = new AtomicInteger(0);


    public AtomicBooleanTest(final AtomicInteger counter) {
        AtomicBooleanTest.counter = counter;
    }

    public static void main(String[] args) {
        final int numberOfCoresOnCPU = Runtime.getRuntime().availableProcessors();

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfCoresOnCPU);
        List<Thread> threads = Stream.generate(() -> new Thread(new AtomicBooleanTest(counter)))
                .limit(numberOfCoresOnCPU)
                .collect(Collectors.toList());
        threads.forEach(Thread::start);
        executorService.shutdown();
    }

    @Override
    public void run() {
        while (counter.get() < 101) {
            final boolean tempFlag = flag.get();
            System.out.println("Flag is now " + tempFlag +
                    "(Thread nr:" + Thread.currentThread().getId() +
                    " change number " + counter.getAndIncrement() + ")");
            flag.set(!tempFlag);
        }
    }
}



