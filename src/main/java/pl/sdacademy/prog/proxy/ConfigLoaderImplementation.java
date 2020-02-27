package pl.sdacademy.prog.proxy;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import pl.sdacademy.prog.streams.SdaException;

@Getter
@Setter
public class ConfigLoaderImplementation implements ConfigLoader {
    private String configuration;
    private String serverUrl;

    public ConfigLoaderImplementation(final String serverUrl) {
        this.serverUrl = serverUrl;
    }

    @Override
    public String load() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new SdaException("Sleeping canceled!", e);
        }
        System.out.println("Configuration from " + getServerUrl() + " downloaded successfully");
        String generatedConfiguration = RandomStringUtils.randomAlphabetic(10);
        setConfiguration(generatedConfiguration);
        return generatedConfiguration;
    }
}
