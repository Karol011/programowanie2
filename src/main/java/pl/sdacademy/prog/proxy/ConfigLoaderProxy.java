package pl.sdacademy.prog.proxy;

import lombok.Data;

@Data

public class ConfigLoaderProxy implements ConfigLoader {

    private final ConfigLoader configLoader;
    private String configuration;

    public ConfigLoaderProxy(final ConfigLoader configLoader) {
        this.configLoader = configLoader;
    }

    @Override
    public String load() {
        if (configuration == null) {
            configuration = configLoader.load();
        }
        return configuration;
    }
}

/*
    stwórz proxy implementującą interfejs ConfigLoader.
        W metodzie load zwracaj konfigurację zwróconą przez klasę stworzoną w poprzednim punkcie
        tylko jeżeli nie została ona pobrana z zewnętrznego serwera (tzn. z serverUrl).
        Tzn. konfigurację w rzeczywistości pobieramy tylko raz
        (czyli tylko raz powinniśmy czekać 2 sekundy mimo wielokrotnego wywołania metody load,
        proxy ukrywa fakt że configuracja jest zapisywana lokalnie przez proxy).*/