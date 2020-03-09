package pl.sdacademy.prog.threads.myThreads.ZadF;

import java.util.concurrent.atomic.AtomicInteger;

class IncTo100Demo implements Runnable {
    public AtomicInteger count;
    String name;

    public IncTo100Demo(final AtomicInteger count, String name) {
        this.count = count;
        this.name = name;
    }

    public void run() {
        Thread current = Thread.currentThread();
        try {
            while (count.get() < 21) {
                System.out.println(current.getName() + " count = " + count.getAndIncrement());
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);

        Thread one = new Thread(new IncTo100Demo(count, "one"));
        Thread two = new Thread(new IncTo100Demo(count, "two"));

        try {
            one.start();
            two.start();
            System.out.println("one alive? " + one.isAlive());
            one.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

