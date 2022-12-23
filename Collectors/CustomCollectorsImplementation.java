package Collectors;

import Streams.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class CustomCollectorsImplementation {
    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 4, 8, -1));
        Integer sum = numbers.stream().collect(new IntegerSumCollector());
        System.out.println(sum);

        List<Dish> menu = asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        List<Dish> dishes = menu.stream().collect(new ToListCollector<>());
        List<Dish> dishes2 = menu.stream().collect(Collectors.toList());
        List<Dish> dishes3 = menu.stream().collect(ArrayList::new, List::add, List::addAll);
        System.out.println(dishes);
        System.out.println(dishes2);
        System.out.println(dishes3);

        Integer p = Arrays.asList(5, 3, 8).parallelStream().collect(new IntegerProductCollector());
        System.out.println(p);
//        System.out.println(partitionPrimesWithCustomCollector(100000000).get(true).size());
    }
}
