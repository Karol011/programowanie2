package pl.sdacademy.prog.streams.TestyStreamow;

import java.awt.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test  {
    public static void main(String[] args) {
        final IntStream stream = IntStream.range(1, 10);
        System.out.println(stream.sum());

        //  stream.forEach(System.out::println);
        System.out.println(1e6+34534);
    }
}
