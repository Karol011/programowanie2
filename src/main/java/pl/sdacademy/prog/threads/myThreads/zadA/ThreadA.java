package pl.sdacademy.prog.threads.myThreads.zadA;

import java.util.Random;

public class ThreadA implements Runnable {

    private volatile boolean isMomCalling = false;
    private String name;

    public ThreadA(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
                Thread.sleep(1000);
                System.out.println(getName() + " budzi sie");
                isMomCalling();
                Thread.sleep(2000);
                System.out.println(getName() + " wraca ze szkoly");
                isMomCalling();
                Thread.sleep(5000);
                System.out.println(getName() + " przygotowuje sniadanie");
                isMomCalling();
                Thread.sleep(1000);
                System.out.println(getName() + " je obiad");
                isMomCalling();
                Thread.sleep(2000);
                System.out.println(getName() + " odrabia lekcje");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void isMomCalling() {
        Random chanceOFMomCalling = new Random();
        isMomCalling = chanceOFMomCalling.nextBoolean();
        if (isMomCalling) {
            System.out.println(getName() + " pora uciekac, tesciowa dzwoni");
        }
    }
}