package pl.sdacademy.prog.streams.TestyStreamow;

import java.awt.*;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test  {
    public static void main(String[] args) {
        final IntStream stream = IntStream.range(1, 10);
        final IntStream stream2 = IntStream.range(5, 20);
       // System.out.println(stream.sum());
      /*  IntStream.concat(stream,stream2)
                .sorted()
                .collect(Collectors.toList());
        */

        //  stream.forEach(System.out::println);
        //System.out.println(1e6+34534);
    }
}
