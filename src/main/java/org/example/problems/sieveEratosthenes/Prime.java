package org.example.problems.sieveEratosthenes;

import java.util.Arrays;

public class Prime {
    public static void main(String[] args) {
        int n = 100;
//        System.out.println(pow(2, 5, 10));
        long x = modInverse(2, 33);
        System.out.println((6 * x) % 33 + "jjjj");
//        System.out.println(fact(5, 13));
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, 2, isPrime.length, true);
        for (int index = 2; index * index <= n; index++) {
            if (isPrime[index]) {
                for (int factor = index * index; factor <= n; factor = factor + index) {
                    isPrime[factor] = false;
                }
            }
        }
        for (int index = 2; index <= n; index++) {
            if (isPrime[index]) {
                System.out.print(index + " ");
            }
        }

    }

    public static int foo(int n, int r) {
        if (r == 0 || n == r) return 1;
        return foo(n - 1, r - 1) + foo(n - 1, r);
    }

    public static long pow(int base, int pow, int mod) {
        if (pow == 0) return 1;
        long result = pow(base, pow / 2, mod);
        if (pow % 2 != 0) {
            return ((result * result) % mod * base) % mod;
        } else {
            return (result * result) % mod;
        }

    }

    public static long fact(int n, int mod) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = (result * i) % mod;
        }
        return result;
    }

    public static long modInverse(long a, long mod) {
        long t = 0;
        long newT = 1;
        long r = mod;
        long newR = a;

        while (newR != 0) {
            long quotient = r / newR;

            // Update t and newT
            long tempT = t;
            t = newT;
            newT = tempT - quotient * newT;

            // Update r and newR
            long tempR = r;
            r = newR;
            newR = tempR - quotient * newR;
        }

        if (r > 1) {
            return -1; // No inverse if gcd(a, m) != 1
        }

        if (t < 0) {
            t = t + mod; // Ensure positive result
        }

        return t;
    }


}
