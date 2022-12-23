package IntStreams;

import java.util.stream.IntStream;

public class Introduction {
    public static void main(String[] args) {
        IntStream.range(0, 20).forEach(System.out::println);
    }
}
