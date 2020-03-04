package pl.sdacademy.prog.threads.myThreads.zadA;

public class ThreadB implements Runnable {

    private String name;

    public ThreadB(final String name) {
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
            Thread.sleep(500);
            System.out.println(getName() + " je sniadanie");
            Thread.sleep(4000);
            System.out.println(getName() + " je obiad");
            Thread.sleep(2500);
            System.out.println(getName() + " je deser");
            Thread.sleep(2000);
            System.out.println(getName() + " oglada telewizje");
            Thread.sleep(2000);
            System.out.println(getName() + " pije piwo");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


