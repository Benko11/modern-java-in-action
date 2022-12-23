package More;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PredicateImplemenation {
    public <R> List<R> filter(List<R> original, Predicate<R> p) {
        List<R> filtered = new ArrayList<>();
        for (R item: original) {
            if (p.test(item))
                filtered.add(item);
        }
        return filtered;
    } 

    public static void main(String[] args) {
        PredicateImplemenation pi = new PredicateImplemenation();
        System.out.println(pi.filter(Arrays.asList(1, 2, 3, 4), (Integer item) -> item % 2 == 0));

        // use lambda
        Predicate<Integer> p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer xxx) {
                return xxx % 3 == 0;
            }
        };

        System.out.println(pi.filter(Arrays.asList(1, 2, 3, 4, 5), p));

        Runnable o = () -> { System.out.println("void, bitch!"); };
        Object o2 = (Runnable) () -> { System.out.println("void, bitch!"); };
        o.run();
    }
}
