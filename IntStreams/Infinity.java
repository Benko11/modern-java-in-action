package IntStreams;

import java.util.stream.Stream;

public class Infinity {
    public static void main(String[] args) {
        Stream<Integer> succession = Stream.iterate(0, n -> n + 2);
        // succession.forEach(System.out::println);

        var g = Stream.generate(Math::random);
    }
}
