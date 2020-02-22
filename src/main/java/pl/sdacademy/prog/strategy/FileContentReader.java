package pl.sdacademy.prog.strategy;

import pl.sdacademy.prog.streams.SdaException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.stream.Collectors;

public class FileContentReader {

    public String readContent(final String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            return reader
                    .lines()
                    .collect(Collectors.joining("\n"));
        } catch (final IOException e) {
            throw new SdaException("Content cannot be read", e);
        }
    }
}
