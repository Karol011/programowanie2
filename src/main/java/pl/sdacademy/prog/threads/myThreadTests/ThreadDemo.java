package pl.sdacademy.prog.threads.myThreadTests;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo implements Runnable {


    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(100);
                System.out.println("Thread 1 " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final AtomicInteger number = new AtomicInteger();

        Thread thread1 = new Thread();
        thread1.start();

        Thread thread2 = new Thread(() ->{
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(100);
                    System.out.println("Thread 2 " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });

        Thread thread3 = new Thread(()->{
            while (number.get() < 10000) {
                System.out.println(number.get());
                number.getAndIncrement();
            }

        });

        Thread thread4 = new Thread(()->{
            while (number.get() < 10000) {
                System.out.println(number.get());
                number.getAndIncrement();
            }

        });
        thread3.start();
        thread4.start();
       // thread2.start();
    }
}
