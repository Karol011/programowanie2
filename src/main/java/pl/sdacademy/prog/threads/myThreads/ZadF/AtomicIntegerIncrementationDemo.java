package pl.sdacademy.prog.threads.myThreads.ZadF;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AtomicIntegerIncrementationDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(1);
        List<Thread> threads = Stream.generate(() -> new Thread(new AtomicIntegerIncrementation(atomicInteger)))
                .limit(2)
                .collect(Collectors.toList());
        threads.forEach(Thread::start);
        threads.forEach(tr ->{
            try{
                tr.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
