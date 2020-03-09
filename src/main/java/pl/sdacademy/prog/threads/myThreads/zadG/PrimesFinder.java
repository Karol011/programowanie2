package pl.sdacademy.prog.threads.myThreads.zadG;

import java.util.ArrayList;
import java.util.List;

public class PrimesFinder implements Runnable {
    private int MIN_VALUE;
    private int MAX_VALUE;

    public PrimesFinder(final int MIN_VALUE, final int MAX_VALUE) {
        this.MIN_VALUE = MIN_VALUE;
        this.MAX_VALUE = MAX_VALUE;
    }

    @Override
    public void run() {
        List<Integer> primes = new ArrayList<>();
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        System.out.println(primes);
        System.out.println("Number of primes found in thread " + Thread.currentThread().getId() + " is " + primes.size());
    }

    private boolean isPrime(final int valueToCheck) {
        for (int i = 2; i < valueToCheck / 2; i++) {
            if (valueToCheck % i == 0) {
                return false;
            }
        }
        return true;
    }
}
