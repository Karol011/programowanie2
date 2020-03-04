package pl.sdacademy.prog.threads.myThreads.VolatileTest;

public class PrintSecondText implements Runnable {

    private volatile boolean randomFlag;
    private int counter = 0;

    @Override
    public void run() {
        while (!randomFlag) {
            try {
                System.out.println("Random is now " + randomFlag + " so i'm counting...");
                System.out.println(counter++);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " has ended");
    }
}
