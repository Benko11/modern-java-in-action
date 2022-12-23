package Collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Streams.Dish;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;

public class Reducing {
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

        long howManyDishes = menu.stream().collect(counting());
        long howManyDishes2 = menu.stream().count();
        System.out.println(howManyDishes);
        System.out.println(howManyDishes2);

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloriesDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
        System.out.println(mostCaloriesDish);

        Optional<Integer> mostCalories = menu.stream().map(Dish::getCalories).reduce(Integer::max);
        Optional<Dish> mostCaloriesDish2 = menu.stream().filter(d -> d.getCalories() == mostCalories.get()).findFirst();
        System.out.println(mostCaloriesDish2);

        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        int totalCalories2 = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(totalCalories2);

        int totalCalories3 = menu.stream().map(Dish::getCalories).reduce(0, (a, b) -> a + b);
        System.out.println(totalCalories3);

        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu);

        int totalCalories4 = menu.stream().collect(reducing(0, Dish::getCalories, (a, b) -> a + b));
        System.out.println(totalCalories4);

        String shortMenu2 = menu.stream().collect(reducing("", Dish::getName, (a, b) -> a + ", " + b));
        System.out.println(shortMenu2);

        int mostCalories2 = menu.stream().collect(reducing(0, Dish::getCalories, (a, b) -> Integer.max(a, b)));
        System.out.println(mostCalories2);

        Optional<Dish> mostCaloriesDish3 = menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2 ));
        System.out.println(mostCaloriesDish3);

        List<Dish> menuList = menu.stream().collect(toList());
        System.out.println(menuList);

        int x = menu.stream().collect(reducing(0, Dish::getCalories, (a, b) -> a + b));
        var y = menu.stream().map(Dish::getName).collect(reducing((d1, d2) -> d1 + d2));
        // var z = menu.stream().collect(reducing((Dish d1, Dish d2) -> d1.getName() + d2.getName()));
        var z = menu.stream().collect(reducing("", Dish::getName, (d1, d2) -> d1 + d2));
    }
}