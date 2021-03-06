package pl.sdacademy.prog.backpacks;

import java.util.List;

public class BackpacksDemo {
    public static void main(String[] args) {
        final String sourcePath = args[0];
        final TestExecutionInfosReader reader = new TestExecutionInfosReader();
        final BackpacksDataWriter writer = new BackpacksDataWriter();
        final BackpacksDividingService service = new BackpacksDividingService();

        final List<TestExecutionInfo> testExecutionInfos = reader.readFromFile(sourcePath);
        final List<BackpackTests> backpacks = service.divideIntoBackpacks(testExecutionInfos, 4);
        writer.writeBacksData(backpacks, "C:\\Users\\rudaz\\Desktop\\sda\\Zadania\\Java");
    }
}
