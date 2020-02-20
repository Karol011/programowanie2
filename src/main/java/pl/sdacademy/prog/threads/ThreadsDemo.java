package pl.sdacademy.prog.threads;

public class ThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        //przeciazanie Thread
        Thread t1 = new Thread(new ThreadOne("Janusz"));
        Thread t2 = new Thread(new ThreadTwo("Inny Janusz"));


        t1.start();
        t2.start();

        Thread.sleep(5000L);
        t1.interrupt();

        //czeka na koniec pracy watku
        t1.join();
        t2.join();

    }
}
