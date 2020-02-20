package pl.sdacademy.prog.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadOne implements Runnable {
    private String name;

    public ThreadOne(final String name) {
        this.name = name;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000L);
            if (isMomCalling()) {
                return;
            }
            System.out.println(name + " is waking up");
            Thread.sleep(2000L);
            if (isMomCalling()) {
                return;
            }
            System.out.println(name + " is preparing breakfast");
            Thread.sleep(5000L);
            if (isMomCalling()) {
                return;
            }
            System.out.println(name + " is coming back from school");
            Thread.sleep(1000L);
            if (isMomCalling()) {
                return;
            }
            System.out.println(name + " is eating dinner");
            Thread.sleep(2000L);
            if (isMomCalling()) {
                return;
            }
            System.out.println(name + " is doing homework");
        } catch (final InterruptedException exp) {
            log.warn("Thread of " + name + " was interrupted");
        }
    }

    private boolean isMomCalling() {
        final boolean interrupted = Thread.currentThread().isInterrupted();
        System.out.println("Mom is " + (interrupted ? "" : "not") + " calling");
        return Thread.currentThread().isInterrupted();
    }
}
