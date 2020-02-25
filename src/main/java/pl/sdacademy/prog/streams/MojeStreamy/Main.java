package pl.sdacademy.prog.streams.MojeStreamy;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Users\\rudaz\\javaRepozytoria4\\sdaprogtwo\\src\\main\\resources\\data4.txt";
        CountryMedalsService countryMedalsService = new CountryMedalsService();
        List<CountryMedals> countryMedalsList = countryMedalsService.readDataFromFile(path);

        //CountryMedalsService.printCountries(countryMedalsList);
        //System.out.println(countryMedalsService.getCountriesWithAtLeastOneMedal(countryMedalsList));
//        CountryMedalsService.printCountries(countryMedalsService.getCountriesWithAtLeastOneMedal(countryMedalsList));
//        CountryMedalsService.printCountries(countryMedalsService.getCountriesWithAnyMedals(countryMedalsList));
//        System.out.println(countryMedalsService.getCountriesWhichWonMostGoldMedals(countryMedalsList));
        //System.out.println(countryMedalsService.getCountriesWithMostMedals(countryMedalsList));
//        System.out.println(countryMedalsService.getCountriesWithMostFourthPlaces(countryMedalsList));
//        CountryMedalsService.printCountries(countryMedalsService.getCountriesWithMoreSilverThanGoldMedals(countryMedalsList));
//        CountryMedalsService.printCountries(countryMedalsService.getCountriesWithMoreBronzeThanSilverAndMoreSilverThanGoldMedals(countryMedalsList));
//        countryMedalsService.getHowManyMedalsCountryHas(countryMedalsList).forEach((k, v) -> System.out.println(k + " = " + v));
//        System.out.println(countryMedalsService.getMostCommonNumbersOfGoldMedals(countryMedalsList));
//        System.out.println(countryMedalsService.getCountriesWithMostPointsAccordingToGoldSilverAndBronzeMedalsCount(countryMedalsList));
//        System.out.println(countryMedalsService.countMedalsAquiredByAllCountries(countryMedalsList));
//        countryMedalsService.createMapAndSortBySilverMedalsCount(countryMedalsList).forEach((k, v) -> System.out.println(k + " = " + v));
//

    }
}
