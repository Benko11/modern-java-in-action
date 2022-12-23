package Collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class PrimeNumbersImplementation {
    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(partitioningBy(PrimeNumbers::isPrime));
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int start, int n) {
        return IntStream.rangeClosed(start, n).boxed().collect(partitioningBy(PrimeNumbers::isPrime));
    }

    public static void main(String[] args) {
        System.out.println(partitionPrimes(50000, 51000).get(true));
    }
}
