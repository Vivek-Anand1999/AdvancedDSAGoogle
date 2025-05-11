package org.example.problems.euclidean;

import java.math.BigInteger;
import java.util.Arrays;

public class ComputeNcR {
    static int x, y;

    public static void main(String[] args) {
        int[] foo1 = foo(new int[]{1, 2, 3, 4, 5, 10});
        System.out.println(Arrays.toString(foo1));
        int[] array = {8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int foo = foo(30, 24, 56);
//        int foo = foo(38, 5, 81);
//        System.out.println(foo);
//        System.out.println();
    }

    public static int foo(int n, int r, int mod) {
        BigInteger numerator = BigInteger.ONE;
        for (int i = 0; i < r; i++) {
            numerator = numerator.multiply(BigInteger.valueOf(n - i));
        }

        BigInteger denominator = BigInteger.ONE;
        for (int i = 2; i <= r; i++) {
            denominator = denominator.multiply(BigInteger.valueOf(i));
        }

        BigInteger gcd = numerator.gcd(denominator);

        if (!gcd.gcd(BigInteger.valueOf(mod)).equals(BigInteger.ONE)) {
            BigInteger divided = numerator.divide(denominator);
            return divided.mod(BigInteger.valueOf(mod)).intValue();
        } else {
            BigInteger inverse = denominator.modInverse(BigInteger.valueOf(mod));
            return numerator.multiply(inverse).mod(BigInteger.valueOf(mod)).intValue();
        }
    }

    public static long fullFactorial(int x, int mod) {
        long result = 1;
        for (int i = 2; i <= x; i++) {
            result = (result * i);
        }
        return result;
    }

    public static int modInverse(long a, int mod) {
        if (gcd(a, mod) != 1) return -1; // Return -1 if modular inverse is not possible
        extendedEuclid(a, mod);
        return (x % mod + mod) % mod;
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, (a % b));
    }

    public static void extendedEuclid(long a, int b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return;
        }
        extendedEuclid(b, (int) (a % b));
        int temp = x;
        x = y;
        y = temp - (int) (a / b) * y;
    }

    public static long exactCombination(long n, long r, int mod) {
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;
        }
        return res;
    }

    public static int[] foo(int[] array) {
        int maxValue = 0;
        for (int num : array) {
            if (num > maxValue) {
                maxValue = num;
            }
        }

        int[] result = new int[maxValue + 1];


        for (int i = 1; i < result.length; i++) {
            for (int j = i; j < result.length; j = j + i) {
                result[j] = 0;
            }
        }

        return result;
    }

}

