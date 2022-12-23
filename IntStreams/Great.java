package IntStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Streams.Dish;

public class Great {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
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

        IntStream caloriesCount = menu.stream().mapToInt(Dish::getCalories);
        List<Dish> totalDish = caloriesCount.boxed().map((total) -> new Dish("total", false, total, Dish.Type.OTHER)).collect(Collectors.toList());
        
        Optional<Integer> max1 = menu.stream().map(Dish::getCalories).reduce(Integer::max);
        System.out.println(max1);

        OptionalInt max2 = menu.stream().mapToInt(Dish::getCalories).max();
        System.out.println(max2);

        Integer max3 = menu.stream().mapToInt(Dish::getCalories).max().orElse(-1);
        System.out.println(max3);

        IntStream evenNumbers = IntStream.rangeClosed(0, 100).filter(i -> i % 2 == 0);
        System.out.println(evenNumbers.count());

        IntStream evenNumbers2 = IntStream.range(0, 100).filter(i -> i % 2 == 0);
        System.out.println(evenNumbers2.count());
    }
}
