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
        System.out.println("Getting configuration from " + serverUrl);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new SdaException("Sleeping canceled!", e);
        }
        System.out.println("Configuration from " + getServerUrl() + " downloaded successfully");
        configuration = RandomStringUtils.randomAlphabetic(10);
        return configuration;
    }
}
