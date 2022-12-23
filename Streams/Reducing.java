package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 8, 4, 5, 1, 7));

        Optional<Integer> sum = numbers.stream().reduce((Integer a, Integer b) -> a + b);
        Integer sum2 = numbers.stream().reduce(0, (Integer a, Integer b) -> a + b);
        sum.ifPresent(System.out::println);
        System.out.println(sum2);

        Optional<Integer> max = numbers.stream().reduce((a, b) -> {
            System.out.println(a + " " + b);
            return Integer.max(a, b);
        });
        max.ifPresent(System.out::println);
    }
}
