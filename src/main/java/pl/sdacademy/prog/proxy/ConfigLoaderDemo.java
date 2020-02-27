package pl.sdacademy.prog.proxy;

public class ConfigLoaderDemo {
    public static void main(String[] args) {

        ConfigLoader proxy = new ConfigLoaderProxy();

        proxy.load();
        proxy.load();
        proxy.load();
    }
}
