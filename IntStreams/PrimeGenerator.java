package IntStreams;

import java.util.stream.IntStream;

public class PrimeGenerator {
    public static void main(String[] args) {
        IntStream.rangeClosed(2, 1000).filter(item -> item == 2 || item % 2 == 1);
    }
}
