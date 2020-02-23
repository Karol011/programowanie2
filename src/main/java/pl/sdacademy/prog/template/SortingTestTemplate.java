package pl.sdacademy.prog.template;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingTestTemplate extends PerformanceTestTemplate {


    @Override
    void testIteration() {
    }

    @Override
    int getWarmupIterationsNum() {
        return 5;
    }

    @Override
    int getIterationsNum() {
        return 10;
    }

    @Override
    void iteration() {
       final List<Integer> numbers = Stream.generate(() -> new Random().nextInt())
               .limit(300000)
               .sorted(Comparator.naturalOrder())
               .collect(Collectors.toList());
    }

    public static void main(String[] args) {

    }


}
