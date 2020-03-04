package pl.sdacademy.prog.threads.myThreads.VolatileTest;

import java.util.Random;

public class VolatileTestDemo {
    public static void main(String[] args) throws InterruptedException {

        //program tests volatile boolean variable

        Thread thread1 = new Thread(() -> {
            new PrintText().run();
        });
        //Thread thread1 = new Thread(new PrintText());
        Thread thread2 = new Thread(()->{
            new PrintSecondText().run();
        });
       // Thread thread2 = new Thread(new PrintSecondText());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


    }
}
