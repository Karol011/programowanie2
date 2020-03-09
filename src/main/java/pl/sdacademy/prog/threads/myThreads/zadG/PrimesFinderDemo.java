package pl.sdacademy.prog.threads.myThreads.zadG;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimesFinderDemo {
    public static void main(String[] args) throws InterruptedException {

int number = 1000;
        System.out.println(number % 100000 == 0 ? 0 : 1);


        List<Integer> numbersToCheck = IntStream.range(0, 400000).boxed().collect(Collectors.toList());
        final int limit = numbersToCheck.size() / 100000
                + (numbersToCheck.size() % 100000 == 0 ? 0 : 1);
        //todo finish this m8


    }
}
