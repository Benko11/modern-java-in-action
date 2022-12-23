package IntStreams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriples {
    public static void main(String[] args) {
        System.out.println(new PythagoreanTriplePrecedentPredicate().test(new Triple(3, 4, 6)));
        System.out.println(new PythagoreanTriplePredicate().test(new Triple(3, 4, 6)));

        Stream<Triple> pythagoreanTriple = IntStream.rangeClosed(1, 100).boxed().flatMap(a -> {
            return IntStream.range(1, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).mapToObj(b -> new Triple(a, b, (int) Math.sqrt(a * a + b * b)));
        });

        pythagoreanTriple.skip(50).forEach(System.out::println);
    }
}
