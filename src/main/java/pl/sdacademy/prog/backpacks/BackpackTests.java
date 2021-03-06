package pl.sdacademy.prog.backpacks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BackpackTests {

    private List<TestExecutionInfo> testInfos = new ArrayList<>();


    public Long sumExecutionTimes() {
       return testInfos.stream()
                .mapToLong(TestExecutionInfo::getExecutionTime)
                .sum();
    }

    public void addTestInfo(final TestExecutionInfo testExecutionInfo) {
        testInfos.add(testExecutionInfo);
    }


}
