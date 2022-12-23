package Playground;

import java.math.BigInteger;

public class Fibonacci {
    public static BigInteger fib(long n) {
        if (n <= 1)
            return BigInteger.valueOf(n);
        
        return fib(n - 2).add(fib(n - 1));
    }

    public static BigInteger fib(long n, long start1, long start2) {
        if (n == 0)
            return BigInteger.valueOf(start1);
        
        if (n == 1)
            return BigInteger.valueOf(start2);
        
        return fib(n - 2, start1, start2).add(fib(n - 1, start1, start2));
    }

    public static void main(String[] args) {
        System.out.println(fib(40, 7, 11));
    }
}
