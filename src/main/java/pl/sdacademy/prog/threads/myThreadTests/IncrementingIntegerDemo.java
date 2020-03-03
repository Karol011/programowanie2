package pl.sdacademy.prog.threads.myThreadTests;

public class IncrementingIntegerDemo implements Runnable {
    private Number number;


    public IncrementingIntegerDemo(final Number number) {
        this.number = number;
    }

    public static void main(String[] args) {
        Number number = new Number(0);

        Thread t1 = new Thread(new IncrementingIntegerDemo(number));
        Thread t2 = new Thread(new IncrementingIntegerDemo(number));

        t1.start();
        t2.start();
    }



    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            number.increment();
            System.out.println(number.getNumber() + " in thread "+ Thread.currentThread().getName());
        }
    }
}
