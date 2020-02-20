package pl.sdacademy.prog.threads.ThreadF;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*public class ThreadFDemo {
    public static void main(String[] args) {


        final AtomicInteger atomicInteger = new AtomicInteger(0);

        final List<Thread> threads = Stream.generate(() -> new Thread(new AtomicInteger(atomicInteger)))
                .limit(2)
                .collect(Collectors.toList());
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}*/
