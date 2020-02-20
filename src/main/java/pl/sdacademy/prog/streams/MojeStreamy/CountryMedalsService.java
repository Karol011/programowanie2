package pl.sdacademy.prog.streams.MojeStreamy;

import pl.sdacademy.prog.streams.SdaException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountryMedalsService {


    private static final int POINTS_FOR_GOLD_MEDALS = 3;
    private static final int POINTS_FOR_SILVER_MEDALS = 2;
    private static final int POINTS_FOR_BRONZE_MEDALS = 1;

    public List<CountryMedals> readDataFromFile(final String path) {
        try {
            return Files.readAllLines(Paths.get(path)).stream()
                    .filter(line -> !line.isEmpty())
                    .map(line -> line.split(","))
                    .map(this::toCountryMedals)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new SdaException("Failed to read input file at " + path, e);
        }
    }

    private CountryMedals toCountryMedals(final String[] args) {

        CountryMedals countryMedals = new CountryMedals();
        countryMedals.setCountryShortName(args[0]);
        countryMedals.setGoldMedalCount(Integer.parseInt(args[1]));
        countryMedals.setSilverMedalCount(Integer.parseInt(args[2]));
        countryMedals.setBronzeMedalCount(Integer.parseInt(args[3]));
        if (args.length == 5) {
            countryMedals.setFourthPlacesCount(Integer.parseInt(args[4]));
        } else {
            countryMedals.setFourthPlacesCount(0);
        }
        return countryMedals;
    }

    public List<CountryMedals> hasAtLeastOneGoldMedal(List<CountryMedals> countryMedalsList) {

        return countryMedalsList.stream()
                .filter(countryMedals -> countryMedals.getGoldMedalCount() > 0)
                .collect(Collectors.toList());
    }

    public List<CountryMedals> hasAnyMedal(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .filter(c -> (c.getGoldMedalCount() + c.getSilverMedalCount() + c.getBronzeMedalCount()) > 0)
                .collect(Collectors.toList());
    }

    public List<String> hasMostGoldMedals(List<CountryMedals> countryMedalsList) {

        return countryMedalsList.stream()
                .collect(Collectors.groupingBy(CountryMedals::getGoldMedalCount)).entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .map(CountryMedalsService::toCountryName)
                .orElseGet(List::of);
   }

    private static List<String> toCountryName(List<CountryMedals> countryMedals) {
        return countryMedals.stream()
                .map(CountryMedals::getCountryShortName)
                .collect(Collectors.toList());
    }

    public CountryMedals hasMostMedals(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .max(Comparator.comparing(CountryMedals::totalMedalsCount))
                .get();
    }

    public Optional<CountryMedals> hasMostFourthPlaces(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .max(Comparator.comparing(CountryMedals::getFourthPlacesCount));
        //   .get();
    }

    public List<CountryMedals> countriesWithMoreSilverThanGoldMedals(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .filter(countryMedals -> countryMedals.getSilverMedalCount() > countryMedals.getGoldMedalCount())
                .collect(Collectors.toList());

    }

    public List<CountryMedals> countriesWithMoreBronzeThanSilverAndMoreSilverThanGoldMedals(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .filter(countryMedals -> countryMedals.getSilverMedalCount() > countryMedals.getGoldMedalCount() &&
                        countryMedals.getBronzeMedalCount() > countryMedals.getSilverMedalCount())
                .collect(Collectors.toList());

    }

    public Map<String, Integer> howManyMedalsCountryHas(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .collect(Collectors.toMap(CountryMedals::getCountryShortName, CountryMedals::totalMedalsCount));
    }

    public Long mostCommonNumbersOfGoldMedals(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                //przeksztalcam na mape: ilosc zlotych medali:ilosc wystapien
                .collect(Collectors.groupingBy(CountryMedals::getGoldMedalCount, Collectors.counting()))
                //tworze streama z tej mapy
                .entrySet().stream()
                //wyszukuje najczestszej wartosci (najczesciej wsytepujaca liczba zlotych medali per panstwo)
                .max(Comparator.comparing(Map.Entry::getValue))
                //zmieniam typ z Map<K,V> na wartosc
                .map(Map.Entry::getValue)
                .orElse(null);
    }

    public Map.Entry<String, Integer> mostPointsAccordingToGoldSilverAndBronzeMedalsCount(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .collect(Collectors.toMap(CountryMedals::getCountryShortName, CountryMedalsService::calculatePointsAccordingToGoldSilverAndBronzeMedalsCount))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get();

    }

    private static int calculatePointsAccordingToGoldSilverAndBronzeMedalsCount(CountryMedals country) {
        return (country.getGoldMedalCount() * POINTS_FOR_GOLD_MEDALS) +
                (country.getSilverMedalCount() * POINTS_FOR_SILVER_MEDALS) +
                country.getBronzeMedalCount() * POINTS_FOR_BRONZE_MEDALS;
    }

    public int countMedalsAquiredByAllCountries(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .mapToInt(CountryMedals::totalMedalsCount)
                .sum();
    }

    public Map<String, Integer> createMapAndSortBySilverMedalsCount(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .collect(Collectors.toMap(CountryMedals::getCountryShortName, CountryMedals::getSilverMedalCount))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                // .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

    }


    public static void printCountries(List<CountryMedals> list) {
        list
                .forEach(System.out::println);
    }
}
