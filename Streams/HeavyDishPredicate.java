package Streams;

import java.util.function.Predicate;

public class HeavyDishPredicate implements Predicate<Dish> {
    @Override
    public boolean test(Dish dish) {
        return dish.getCalories() > 600;
    }
}
