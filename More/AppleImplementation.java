package More;

import Apples.Colour;

import java.util.ArrayList;
import java.util.List;

public class AppleImplementation {
    public static <T, R> List<R> map(List<T> original, Function<T, R> f) {
        List<R> processed = new ArrayList<>();

        for (T item: original) {
            processed.add(f.apply(item));
        }

        return processed;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(40, Colour.RED));
        apples.add(new Apple(60, Colour.GREEN));
        
        Function<Apple, Integer> f = (Apple apple) -> apple.getWeight();
        System.out.println(map(apples, f));
        System.out.println(map(apples, Apple::getWeight));
    }
}
