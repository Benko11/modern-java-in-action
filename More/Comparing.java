package More;

import java.util.ArrayList;
import java.util.List;

import Apples.Colour;

import static java.util.Comparator.comparing;

public class Comparing {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(50, Colour.RED));
        apples.add(new Apple(100, Colour.GREEN));
        apples.add(new Apple(90, Colour.RED));
        apples.add(new Apple(80, Colour.RED));
        apples.add(new Apple(50, Colour.GREEN));
        apples.add(new Apple(70, Colour.GREEN));
        apples.add(new Apple(40, Colour.GREEN));
        
        // apples.sort(new AppleComparator());

        // apples.sort(new Comparator<Apple>() {
        //     @Override
        //     public int compare(Apple a1, Apple a2) {
        //         return a1.getWeight().compareTo(a2.getWeight());
        //     }
        // });

        // apples.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        // apples.sort(comparing((Apple apple) -> apple.getWeight()));
        // apples.sort(comparing(Apple::getWeight));
        apples.sort(comparing(Apple::getWeight).reversed().thenComparing(apple -> Colour.RED.equals(apple.getColour())));

        System.out.println(apples);
    }
}
