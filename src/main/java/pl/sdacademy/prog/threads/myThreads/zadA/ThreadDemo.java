package pl.sdacademy.prog.threads.myThreads.zadA;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(new ThreadA("Bogdanek"));
        Thread threadB = new Thread(new ThreadB("Janusz"));

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
    }
}
