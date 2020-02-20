package pl.sdacademy.prog.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Util {

    List<Integer> concatAllIntegersFromLists(List<Dummy> dummies) {
        return dummies.stream()
                .flatMap(dummy -> dummy.getInts().stream())
                .collect(Collectors.toList());
    }


}
