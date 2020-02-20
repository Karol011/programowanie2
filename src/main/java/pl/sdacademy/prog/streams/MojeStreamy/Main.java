package pl.sdacademy.prog.streams.MojeStreamy;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Users\\rudaz\\javaRepozytoria4\\sdaprogtwo\\src\\main\\resources\\data4.txt";
        CountryMedalsService countryMedalsService = new CountryMedalsService();
        List<CountryMedals> countryMedalsList = countryMedalsService.readDataFromFile(path);

        // CountryMedalsService.printCountries(countryMedalsList);
        // System.out.println(countryMedalsService.hasAtLeastOneGoldMedal(countryMedalsList));
        // CountryMedalsService.printCountries(countryMedalsService.hasAtLeastOneGoldMedal(countryMedalsList));
        // CountryMedalsService.printCountries(countryMedalsService.hasAnyMedal(countryMedalsList));
          // System.out.println(countryMedalsService.hasMostGoldMedals(countryMedalsList));
        //  System.out.println(countryMedalsService.hasMostMedals(countryMedalsList));
        // System.out.println(countryMedalsService.hasMostFourthPlaces(countryMedalsList));
        //CountryMedalsService.printCountries(countryMedalsService.countriesWithMoreSilverThanGoldMedals(countryMedalsList));
        //  CountryMedalsService.printCountries(countryMedalsService.countriesWithMoreBronzeThanSilverAndMoreSilverThanGoldMedals(countryMedalsList));
        // countryMedalsService.howManyMedalsCountryHas(countryMedalsList).forEach((k, v) -> System.out.println(k + " = " + v));
        //System.out.println(countryMedalsService.mostCommonNumbersOfGoldMedals(countryMedalsList));
        // System.out.println(countryMedalsService.mostPointsAccordingToGoldSilverAndBronzeMedalsCount(countryMedalsList));
        //  System.out.println(countryMedalsService.countMedalsAquiredByAllCountries(countryMedalsList));
        //countryMedalsService.createMapAndSortBySilverMedalsCount(countryMedalsList).forEach((k, v) -> System.out.println(k + " = " + v));

    }
}
