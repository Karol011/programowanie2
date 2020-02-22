package pl.sdacademy.prog.strategy;

import org.apache.commons.cli.ParseException;

public class TextModificationDemo {
    public static void main(String[] args) {

        final CustomCommandLineParser parser = new CustomCommandLineParser();
        final FileContentReader reader = new FileContentReader();
        final TextModificationStrategySelector selector = new TextModificationStrategySelector();
        final TextModificationProcessFacade facade = new TextModificationProcessFacade(
                parser, reader, selector);
        try {
            System.out.println(facade.process(args));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

    }
}
