package pl.sdacademy.prog.threads.myThreads.VolatileTest;

import java.util.Random;

public class PrintText implements Runnable {

    private volatile boolean randomFlag;
    private int randomFlagTrueOccurences = 0;

    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            randomFlag = new Random().nextBoolean();
            if (randomFlag) {
                randomFlagTrueOccurences++;
                System.out.println("Random is now " + randomFlag + " it is " + randomFlagTrueOccurences + "/10 it happened");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " has ended");
    }
}

