package Collectors;

import java.util.List;
import java.util.stream.IntStream;

public class PrimeNumbers {
    public static boolean isPrime(int candidate) {
        int rootedCandidate = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, rootedCandidate).noneMatch(i -> candidate % i == 0);
    }

    public static boolean isPrime(List<Integer> primes, int candidate) {
        int rootedCandidate = (int) Math.sqrt(candidate);
        return primes.stream().takeWhile(i -> i <= rootedCandidate).noneMatch(i -> candidate % i == 0);
    }
}
