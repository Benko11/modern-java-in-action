package IntStreams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Factorial {
    public static void main(String[] args) {
        var x = IntStream.rangeClosed(1, 1000).reduce((a, b) -> a * b).getAsInt();
        System.out.println(x);
    }
}
