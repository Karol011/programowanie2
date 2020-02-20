package pl.sdacademy.prog.threads.ThreadLocal;

import pl.sdacademy.prog.fruits.Apple;
import pl.sdacademy.prog.fruits.Fruit;

import java.util.Random;

public class ThreadLocalThreadExample implements Runnable {
    private static ThreadLocal<Fruit> fruit = new ThreadLocal<>(); //fruit bo potrzebujemy jakiejs klasy generycznej

    @Override
    public void run() {
        final Fruit fruitFromThreadLocalBefore = fruit.get();
        System.out.println(fruitFromThreadLocalBefore);
        fruit.set(new Apple(new Random().nextDouble()));
        final Fruit fruitFromThreadLocalAfter = fruit.get();
        System.out.println(fruitFromThreadLocalAfter);
    }
}
