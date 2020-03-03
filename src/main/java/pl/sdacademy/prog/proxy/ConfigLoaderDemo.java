package pl.sdacademy.prog.proxy;

public class ConfigLoaderDemo {
    public static void main(String[] args) {

        ConfigLoader configLoader = new ConfigLoaderImplementation("http://localhost:8080");
        final ConfigLoader proxy = new ConfigLoaderProxy(configLoader);


        proxy.load();
        proxy.load();
        proxy.load();
        proxy.load();

    }
}
