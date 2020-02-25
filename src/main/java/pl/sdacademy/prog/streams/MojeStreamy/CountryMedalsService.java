package pl.sdacademy.prog.streams.MojeStreamy;

import pl.sdacademy.prog.streams.SdaException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CountryMedalsService {

    private static final int COUNTRY_SHORT_NAME_INDEX = 0;
    private static final int COUNTRY_GOLD_MEDALS_COUNT_INDEX = 1;
    private static final int COUNTRY_SILVER_MEDALS_COUNT_INDEX = 2;
    private static final int COUNTRY_BRONZE_MEDALS_COUNT_INDEX = 3;
    private static final int COUNTRY_FOURTH_PLACES_COUNT_INDEX = 4;
    private static final int NUMBER_OF_ALL_COUNTRY_PARAMETERS = 5;
    private static final int DEFAULT_VALUE_OF_FOURTH_PLACES = 0;

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
        countryMedals.setCountryShortName(args[COUNTRY_SHORT_NAME_INDEX]);
        countryMedals.setGoldMedalCount(Integer.parseInt(args[COUNTRY_GOLD_MEDALS_COUNT_INDEX]));
        countryMedals.setSilverMedalCount(Integer.parseInt(args[COUNTRY_SILVER_MEDALS_COUNT_INDEX]));
        countryMedals.setBronzeMedalCount(Integer.parseInt(args[COUNTRY_BRONZE_MEDALS_COUNT_INDEX]));
        if (args.length == NUMBER_OF_ALL_COUNTRY_PARAMETERS) {
            countryMedals.setFourthPlacesCount(Integer.parseInt(args[COUNTRY_FOURTH_PLACES_COUNT_INDEX]));
        } else {
            countryMedals.setFourthPlacesCount(DEFAULT_VALUE_OF_FOURTH_PLACES);
        }
        return countryMedals;
    }

    public List<CountryMedals> getCountriesWithAtLeastOneMedal(List<CountryMedals> countryMedalsList) {

        return countryMedalsList.stream()
                .filter(countryMedals -> countryMedals.getGoldMedalCount() > 0)
                .collect(Collectors.toList());
    }

    public List<CountryMedals> getCountriesWithAnyMedals(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .filter(c -> (c.getGoldMedalCount() + c.getSilverMedalCount() + c.getBronzeMedalCount()) > 0)
                .collect(Collectors.toList());
    }

    public List<String> getCountriesWhichWonMostGoldMedals(List<CountryMedals> countryMedalsList) {

        return countryMedalsList.stream()
                .collect(Collectors.groupingBy(CountryMedals::getGoldMedalCount)).entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .map(this::toCountryName)
                .orElseGet(List::of);
    }

    private List<String> toCountryName(List<CountryMedals> countryMedals) {
        return countryMedals.stream()
                .map(CountryMedals::getCountryShortName)
                .collect(Collectors.toList());
    }

    public List<String> getCountriesWithMostMedals(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .collect(Collectors.groupingBy(CountryMedals::getTotalMedalsCount)).entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .map(this::toCountryName)
                .orElseThrow(() -> new SdaException("No such element"));
    }

    public List<String> getCountriesWithMostFourthPlaces(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .collect(Collectors.groupingBy(CountryMedals::getFourthPlacesCount)).entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .map(this::toCountryName)
                .orElseThrow(() -> new SdaException("No such element"));
    }

    public List<CountryMedals> getCountriesWithMoreSilverThanGoldMedals(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .filter(countryMedals -> countryMedals.getSilverMedalCount() > countryMedals.getGoldMedalCount())
                .collect(Collectors.toList());

    }

    public List<CountryMedals> getCountriesWithMoreBronzeThanSilverAndMoreSilverThanGoldMedals(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .filter(countryMedals -> countryMedals.getSilverMedalCount() > countryMedals.getGoldMedalCount() &&
                        countryMedals.getBronzeMedalCount() > countryMedals.getSilverMedalCount())
                .collect(Collectors.toList());

    }

    public Map<String, Integer> getHowManyMedalsCountryHas(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .collect(Collectors.toMap(CountryMedals::getCountryShortName, CountryMedals::getTotalMedalsCount));
    }

    public Long getMostCommonNumbersOfGoldMedals(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                //przeksztalcam na mape: ilosc zlotych medali:ilosc wystapien
                .collect(Collectors.groupingBy(CountryMedals::getGoldMedalCount, Collectors.counting()))
                //tworze streama z tej mapy
                .entrySet().stream()
                //wyszukuje najczestszej wartosci (najczesciej wsytepujaca liczba zlotych medali per panstwo)
                .max(Comparator.comparing(Map.Entry::getValue))
                //zmieniam typ z Map<K,V> na wartosc
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new SdaException("No such value"));
    }

    public Map.Entry<String, Integer> getCountriesWithMostPointsAccordingToGoldSilverAndBronzeMedalsCount(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .collect(Collectors.toMap(CountryMedals::getCountryShortName, CountryMedalsService::calculatePointsAccordingToGoldSilverAndBronzeMedalsCount))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow(() -> new SdaException("No such element"));

    }

    private static int calculatePointsAccordingToGoldSilverAndBronzeMedalsCount(CountryMedals country) {
        return (country.getGoldMedalCount() * POINTS_FOR_GOLD_MEDALS) +
                (country.getSilverMedalCount() * POINTS_FOR_SILVER_MEDALS) +
                country.getBronzeMedalCount() * POINTS_FOR_BRONZE_MEDALS;
    }

    public int countMedalsAquiredByAllCountries(List<CountryMedals> countryMedalsList) {
        return countryMedalsList.stream()
                .mapToInt(CountryMedals::getTotalMedalsCount)
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
