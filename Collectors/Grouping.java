package Collectors;

import java.util.*;

import static java.util.Arrays.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import Streams.Dish;

public class Grouping {
    public enum CaloricLevel {DIET, NORMAL, FAT};

    public static void main(String[] args) {
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

        Map<Dish.Type, List<Dish>> group = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(group);

        Map<Integer, List<Dish>> group2 = menu.stream().collect(groupingBy(Dish::getCalories));
        System.out.println(group2);

        Map<CaloricLevel, List<Dish>> group3 = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() > 700) return CaloricLevel.FAT;
            if (dish.getCalories() > 400) return CaloricLevel.NORMAL;
            return CaloricLevel.DIET;
        }));
        System.out.println(group3);

        Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream().filter(d -> d.getCalories() > 500).collect(groupingBy(Dish::getType));
        System.out.println(caloricDishesByType); // FISH has disappeared completely

        Map<Dish.Type, List<Dish>> caloricDishesByType2 = menu.stream().collect(groupingBy(Dish::getType, filtering(d -> d.getCalories() > 500, toList())));
        System.out.println(caloricDishesByType2); // FISH is empty

        Map<Dish.Type, List<String>> caloricDishesByType3 = menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
        System.out.println(caloricDishesByType3);

        Map<Integer, List<Dish>> dishesByLength = menu.stream().collect(groupingBy(d -> d.getName().length()));
        System.out.println(dishesByLength);

        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));

        var dishNamesByTags = menu.stream().collect(groupingBy(Dish::getType, flatMapping(d -> dishTags.get(d.getName()).stream(), toSet())));
        System.out.println(dishNamesByTags);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishByTypesByCaloricLevel = menu.stream().collect(groupingBy(Dish::getType, groupingBy(d -> {
            if (d.getCalories() > 700) return CaloricLevel.FAT;
            if (d.getCalories() > 400) return CaloricLevel.NORMAL;
            return CaloricLevel.DIET;
        })));
        System.out.println(dishByTypesByCaloricLevel);

        Map<Dish.Type, Long> typeCounts = menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(typeCounts);

        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream().collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);

        Optional<Dish> mostCaloricDish = menu.stream().collect(maxBy(comparingInt(Dish::getCalories)));
        System.out.println(mostCaloricDish);

        Map<Dish.Type, Dish> mostCaloricByType2 = menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricByType2);

        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType);

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream().collect(groupingBy(Dish::getType, mapping(d -> {
            if (d.getCalories() > 700) return CaloricLevel.FAT;
            if (d.getCalories() < 400) return CaloricLevel.NORMAL;
            return CaloricLevel.DIET;
        }, toCollection(HashSet::new))));
        System.out.println(caloricLevelsByType);
    }
}