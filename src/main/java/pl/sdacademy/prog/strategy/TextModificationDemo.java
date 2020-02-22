package pl.sdacademy.prog.strategy;

public class TextModificationDemo {
    public static void main(String[] args) {

        String filePath = args[0];
        String modificationType = args[1];
        TextModificationStrategySelector selector = new TextModificationStrategySelector();
        TextModificationStrategy strategy = selector.getTextModificationStrategy(modificationType);
        FileContentReader fileContentReader = new FileContentReader();
        String textToModify = fileContentReader.readContent(filePath);
        String output = strategy.modify(textToModify);

        System.out.println(output);


    }


}
