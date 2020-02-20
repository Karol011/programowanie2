package pl.sdacademy.prog.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadTwo implements Runnable {
    private String name;

    public ThreadTwo(final String name) {
        this.name = name;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(500L);
            System.out.println(name + " is eating breakfast");
            Thread.sleep(4000L);
            System.out.println(name + " is eating dinner");
            Thread.sleep(2500L);
            System.out.println(name + " is eating dessert");
            Thread.sleep(2000L);
            System.out.println(name + " is watching TV");
            Thread.sleep(2000L);
            System.out.println(name + " is drinking beer");
        } catch (final InterruptedException exp) {
            log.warn("Thread of " + name + " was interrupted");
        }
    }
}

