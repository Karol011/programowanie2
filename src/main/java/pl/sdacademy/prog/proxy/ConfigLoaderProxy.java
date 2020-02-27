package pl.sdacademy.prog.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class ConfigLoaderProxy implements ConfigLoader {

    private ConfigLoader proxy;

    @Override
    public String load() {
        if (proxy == null) {
            proxy = new ConfigLoaderImplementation("www.blablA.com");
            return proxy.load();

        } else {
            return proxy.load();
        }
        //todo

    }
}

/*
    stwórz proxy implementującą interfejs ConfigLoader.
        W metodzie load zwracaj konfigurację zwróconą przez klasę stworzoną w poprzednim punkcie
        tylko jeżeli nie została ona pobrana z zewnętrznego serwera (tzn. z serverUrl).
        Tzn. konfigurację w rzeczywistości pobieramy tylko raz
        (czyli tylko raz powinniśmy czekać 2 sekundy mimo wielokrotnego wywołania metody load,
        proxy ukrywa fakt że configuracja jest zapisywana lokalnie przez proxy).*/