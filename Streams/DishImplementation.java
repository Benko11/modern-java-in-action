package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DishImplementation {
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

        List<Dish> vegetarianMeals = menu.parallelStream().filter(Dish::isVegetarian).limit(3).collect(Collectors.toList());
        System.out.println(vegetarianMeals);

        List<Dish> heavyMeals = menu.parallelStream().filter(new HeavyDishPredicate()).collect(Collectors.toList());
        System.out.println(heavyMeals);

        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("This menu is (somewhat) vegetarian friendly!");
        }

        boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(isHealthy);

        boolean isStillHealthy = menu.stream().noneMatch(dish -> dish.getCalories() >= 1000);
        System.out.println(isStillHealthy);
        // short-circuit evaluation

        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
        System.out.println(dish.orElse(null));

        menu.stream().filter(d -> d.getCalories() < 500).findAny().ifPresent(item -> System.out.println(item));

        menu.stream().map(d -> 1).reduce((a, b) -> a + b).ifPresent(System.out::println);


        int totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(totalCalories);

        // collections - how things are computed immediately
        // streams - using things on the fly
        
    }
}
