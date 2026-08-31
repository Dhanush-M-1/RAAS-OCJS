import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final long MOD = 1000000007;
    static int n;
    static int m;
    static int[] b;
    static long[] dp;

    private static long rec(int current) {
        if (current == n) return 1;
        if (current > n) return 0;
        if (b[current] == 1) return 0;
        if (dp[current] == MOD) {
            dp[current] = (rec(current + 1) + rec(current + 2)) % MOD;
        }
        return dp[current];
    }

    public static void main(String[] args) {
        java.util.Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        b = new int[n];
        dp = new long[n];
        for (int i = 0; i < n; i++) dp[i] = MOD;
        for (int i = 0; i < m; i++) b[input.nextInt()] = 1;
        long r = rec(0);
        System.out.println(r);
    }
}
