package pl.sdacademy.prog.streams.WordStatistics;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LetterCounter {


    public static Map<String, Long> countLettersInWord(String sentence) {
        return Stream.of(sentence.split(""))
                .map(String::trim)
                .filter(letter -> !letter.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static Map<String, Long> wordOccurency(String sentence) {
        return Stream.of(sentence.split(" "))
                .map(word -> word.trim())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {


        // System.out.println(countLettersInWord(args[0]));
        wordOccurency(args[0]).forEach((k, v) -> System.out.println(k + ":" + v));

    }
}
