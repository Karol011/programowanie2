package pl.sdacademy.prog.strategy;

import org.apache.commons.cli.*;

import java.util.Optional;

public class CustomCommandLineParser {

    private static final String FILE_OPTION_NAME = "f"; //sciezka do pliku
    private static final String TYPE_OPTION_NAME = "t";
    private static final char VALUE_SEPARATOR = '=';

    private CommandLine parsedArguments;

    public void parse(final String[] args) throws ParseException {
        final CommandLineParser parser = new DefaultParser();
        parsedArguments = parser.parse(createOPtionsDefinitions(), args);
    }

    public Optional<String> getTypeOptionValue() {
        return Optional.ofNullable(parsedArguments)
                .map(args -> args.getOptionValue(TYPE_OPTION_NAME));
    }

    public Optional<String> getFileOptionValue() {
        if (parsedArguments == null) {
            return Optional.empty();
        }
        return Optional.of(parsedArguments.getOptionValue(FILE_OPTION_NAME));
    }


    private Options createOPtionsDefinitions() {
        return new Options()
                .addOption(buildConversionTypeOption())
                .addOption(buildSourceFileTypeOption());
    }

    private Option buildSourceFileTypeOption() {
        return Option.builder()
                .required()
                .longOpt(FILE_OPTION_NAME)
                .valueSeparator(VALUE_SEPARATOR)
                .hasArg() //musi miec wartosc
                .argName(FILE_OPTION_NAME)
                .desc("Source file path for text conversion")
                .build();
    }

    private Option buildConversionTypeOption() {
        return Option.builder()
                .required()
                .longOpt(TYPE_OPTION_NAME)
                .valueSeparator(VALUE_SEPARATOR)
                .hasArg()
                .argName(TYPE_OPTION_NAME)
                .desc("Conversion type for strategy (CAMEL_CASE, COMPRESS, KEBAB_CASE, NONE)")
                .build();
    }

}
