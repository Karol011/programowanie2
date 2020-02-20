package pl.sdacademy.prog.threads.ThreadLocal;

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        final Thread threadA = new Thread(new ThreadLocalThreadExample());
        final Thread threadB = new Thread(new ThreadLocalThreadExample());

        threadA.start();
        Thread.sleep(500L);
        threadB.start();

        threadA.join();
        threadB.join();
    }
}
