package Playground;

import java.math.BigInteger;

public class Factorial {
    public static BigInteger factorial(long n) {
        if (n <= 1)
            return BigInteger.valueOf(1);

        return factorial(n - 1).multiply(BigInteger.valueOf(n));
    }

    public static void main(String[] args) {
        System.out.println(factorial(1000));
    }    
}
