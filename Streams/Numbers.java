package Streams;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Numbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        
        numbers.parallelStream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
        values.stream().map(item -> (int) Math.pow(item, 2)).forEach(System.out::println);

        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(3, 4);
        List<int[]> c = a.stream()
        .flatMap(i -> b.stream().map(j -> new int[]{i, j}))
        .collect(toList());

        List<int[]> d = a.stream()
        .flatMap(i -> b.stream().filter(j -> (i + j) % 3 == 0)
        .map(j -> new int[]{i, j}))
        // .filter(item -> (item[0] + item[1]) % 3 == 0)
        .collect(toList());

        c.forEach(item -> System.out.println(Arrays.toString(item)));
        System.out.println("---------------");
        d.forEach(item -> System.out.println(Arrays.toString(item)));
    }
}
