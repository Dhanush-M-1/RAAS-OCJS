//package sixhundredsixtythree;

import java.util.Scanner;

public class CyclicPermutations {
    private static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        System.out.println(Math.floorMod(fact(n) - pow(2, n - 1), MOD));
    }

    static long fact(long n) {
        long prod = 1L;
        for (int i = 1; i <= n; i++) {
            prod *= i;
            prod = Math.floorMod(prod,MOD);
        }
        return prod;
    }

    static long pow(long base, long exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base;
        long x = pow(base, exp / 2);
        long ans = (exp % 2 == 0) ? x * x : base * x * x;
        return Math.floorMod(ans, MOD);
    }
}
