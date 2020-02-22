package pl.sdacademy.prog.strategy;

import org.apache.commons.cli.ParseException;

public class TextModificationDemo {
    public static void main(String[] args) {

        final CustomCommandLineParser parser = new CustomCommandLineParser();
        try {
            parser.parse(args);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        String filePath = parser.getFileOptionValue().get();
        String modificationType = parser.getTypeOptionValue().get();
        TextModificationStrategySelector selector = new TextModificationStrategySelector();
        TextModificationStrategy strategy = selector.getTextModificationStrategy(modificationType);
        FileContentReader fileContentReader = new FileContentReader();
        String textToModify = fileContentReader.readContent(filePath);
        String output = strategy.modify(textToModify);

        System.out.println(output);


    }


}
