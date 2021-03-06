package pl.sdacademy.prog.threads.PrimesThread;

import java.util.ArrayList;
import java.util.List;

public class PrimesThread implements Runnable {

    private static final int BATCH_SIZE = 100000;

    private List<Integer> ints;
    private int index;

    public PrimesThread(final List<Integer> ints, final int index) {
        this.ints = ints;
        this.index = index;
    }

    @Override
    public void run() {
        if (ints.size() >= index * BATCH_SIZE) {
            final int lowerIndex = index * BATCH_SIZE;
            final int upperIndex = Math.min((index + 1) * BATCH_SIZE, ints.size());
            final List<Integer> foundPrimes = new ArrayList<>();
            for (int i = lowerIndex; i < upperIndex; i++) {
                if (isPrime(ints.get(i))) {
                    foundPrimes.add(ints.get(i));
                }
            }
            foundPrimes.forEach(System.out::println);
        }
    }

    private boolean isPrime(final int valueToCheck) {
        for (int i = 2; i <=valueToCheck / 2; i++) {
            if (valueToCheck % i == 0) {
                return false;
            }
        }
        return true;
    }
}


