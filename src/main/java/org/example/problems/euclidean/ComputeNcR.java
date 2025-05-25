package org.example.problems.euclidean;

import java.math.BigInteger;
import java.util.Arrays;

public class ComputeNcR {
    static int x, y;

    public static void main(String[] args) {
        int[] r = subArray(new int[]{23, 50, 44, 6, 39, 15, 44, 27, 47, 29, 30, 44, 28, 42, 7, 32, 16, 40, 8, 7, 5, 48, 48, 16, 9, 5, 50, 16, 18, 9, 21, 26, 48, 37, 27, 7, 5, 29, 24, 28, 10, 44, 21, 1, 48, 15, 31, 41, 42, 23, 4, 32, 40, 40, 27, 20, 29, 42, 25, 18, 37, 43, 13, 30, 42, 24, 17, 42, 14, 42, 43, 36, 31, 29, 24, 24, 8, 3, 12, 34, 14, 6}, 62);
        System.out.println(Arrays.toString(r));
        System.out.println(findRank("DAMBC"));
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
                result[j]++;
            }
        }

        return result;
    }

    public static int findRank(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int result = 0;
        int spaceLeft = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) > str.charAt(j)) {
                    count++;
                }
            }
            int fac = fullFactorial(spaceLeft);
            spaceLeft--;
            result += count * fac;
        }
        return result + 1;
    }

    public static int fullFactorial(int x) {
        int result = 1;
        for (int i = 2; i <= x; i++) {
            result = (result * i);
        }
        return result;
    }

    public static int[] subArray(int[] array, int target) {
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
        int[] prefixSum = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            prefixSum[i] = i == 0 ? array[i] : prefixSum[i - 1] + array[i];
        }

        System.out.println(Arrays.toString(prefixSum));

        int[] result = new int[2];

        int i = 0;
        int j = 1;

        while (j < array.length && i < j) {
            int sum = i == 0 ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
            System.out.println(sum);
            if (sum > target) {
                i++;
                j = i + 1;
            } else if (sum < target) {
                j++;
            } else {
                return Arrays.copyOfRange(array, i, j + 1);
            }
        }

        return new int[]{-1};
    }

}

