package pl.sdacademy.prog.streams.MojeStreamy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountryMedals {
    private String countryShortName;
    private int goldMedalCount;
    private int silverMedalCount;
    private int bronzeMedalCount;
    private int fourthPlacesCount;

    int totalMedalsCount() {
        return this.getGoldMedalCount() + this.getSilverMedalCount() + this.getBronzeMedalCount();
    }
    public List<String> toCountryName(List<CountryMedals> countryMedals) {
        return countryMedals.stream()
                .map(CountryMedals::getCountryShortName)
                .collect(Collectors.toList());
    }
}
