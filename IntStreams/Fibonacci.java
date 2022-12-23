package IntStreams;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

public class Fibonacci {
    public static Stream<BigInteger> fibSequence() {
        return Stream.iterate(new BigInteger[]{BigInteger.valueOf(0), BigInteger.valueOf(1)}, a -> new BigInteger[]{a[1], a[0].add(a[1])}).map(p -> p[1]);
    }

    public static void main(String[] args) {
        // Stream.iterate(new int[]{2, 1}, a -> new int[]{a[1], a[0] + a[1]}).skip(20).takeWhile(a -> a[1] < 10000000)
        // .forEach(p -> System.out.println(Arrays.toString(p)));
        
        fibSequence().skip(100000).limit(1).forEach(System.out::println);
    }
}
