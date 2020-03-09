package pl.sdacademy.prog.threads.myThreads.zadA;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(new ThreadA("Bogdanek"));
        Thread threadB = new Thread(new ThreadB("Janusz"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Thread> threads = new ArrayList<>();
        threads.add(threadA);
        threads.add(threadB);

        threads.forEach(executorService::submit);

        //threadA.start();
        //threadB.start();

        threadA.join();
        threadB.join();
    }
}
