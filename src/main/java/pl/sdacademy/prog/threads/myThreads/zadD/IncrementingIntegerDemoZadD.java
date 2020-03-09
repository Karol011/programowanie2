package pl.sdacademy.prog.threads.myThreads.zadD;

import pl.sdacademy.prog.threads.myThreadTests.Number;

public class IncrementingIntegerDemoZadD implements Runnable {

    private Number number;
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public IncrementingIntegerDemoZadD(final Number number) {
        this.number = number;
    }

    public static void main(String[] args) throws InterruptedException {
        Number number = new Number(0);

        Thread t1 = new Thread(new pl.sdacademy.prog.threads.myThreadTests.IncrementingIntegerDemo(number));
        Thread t2 = new Thread(new pl.sdacademy.prog.threads.myThreadTests.IncrementingIntegerDemo(number));

        t1.start();
        Thread.sleep(5);
        t2.start();
    }


    @Override
    public void run() {
        for (int i = 0; number.getNumber() < 100; i++) {
            number.increment();
            if (number.getNumber() == 50) {
                System.out.println("zmienna thread local: " + threadLocal.get());
                threadLocal.set(66);
                System.out.println("zmienna thread local: " + threadLocal.get());
            }

            System.out.println(number.getNumber() + " in thread " + Thread.currentThread().getName());

        }
    }

}
