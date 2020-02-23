package pl.sdacademy.prog.backpacks;

import pl.sdacademy.prog.streams.SdaException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BackpacksDividingService {

    public List<BackpackTests> divideIntoBackpacks(final List<TestExecutionInfo> allTests,
                                                   final int backpacksNum) {
        validateBackpacksNum(backpacksNum);
        final List<BackpackTests> backpacks = initializeEmptyBackpacks(backpacksNum);
        allTests.forEach(testExecutionInfo -> processTestExecutionInfo(testExecutionInfo, backpacks));
        return backpacks;
    }

    private void validateBackpacksNum(final int backpacksNum) {
        if (backpacksNum <= 0) {
            throw new IllegalArgumentException("Backpacks number has to be positive");
        }
    }

    private List<BackpackTests> initializeEmptyBackpacks(final int backpacksNum) {
        final List<BackpackTests> backpacks = new ArrayList<>();
        for (int i = 0; i < backpacksNum; i++) {
            backpacks.add(new BackpackTests());
        }
        return backpacks;
    }

    private void processTestExecutionInfo(final TestExecutionInfo testExecutionInfo,
                                          final List<BackpackTests> backpacks) {
        final int backpackIndex = findBackpackIndexWithLowestExecutionTime(backpacks);
        backpacks.get(backpackIndex).addTestInfo(testExecutionInfo);
    }

    private int findBackpackIndexWithLowestExecutionTime(final List<BackpackTests> backpacks) {
        final int index[] = {0};
        return backpacks.stream()
                .collect(Collectors.toMap(backpack -> index[0]++,
                        BackpackTests::sumExecutionTimes))
                .entrySet().stream()
                .min(Comparator.comparingLong(Map.Entry::getValue))
                //mapowanie optionala
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new SdaException("This should not happen")); //bo na poczatku sprawdzamy czy backpacksNum <=0
    }
}
