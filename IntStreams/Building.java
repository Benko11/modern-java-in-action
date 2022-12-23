package IntStreams;

import java.util.Arrays;
import java.util.stream.Stream;

public class Building {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Radiohead", "Coldplay", "Pink Floyd", "Billie Eilish");
        stream.forEach(System.out::println);

        Stream<String> newStream = Stream.empty();
        Stream<String> newStream2 = Stream.ofNullable(null);

        int[] numbers = {1, 2, 8, 7, -1};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
    }
}
