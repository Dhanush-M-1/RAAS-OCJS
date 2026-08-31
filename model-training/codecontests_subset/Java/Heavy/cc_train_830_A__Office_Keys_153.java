import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wyj on 17-7-27.
 */
public class Main {

    public static final Scanner in = new Scanner(System.in);

    public static int n;
    public static int k;
    public static int p;

    public static long[] personPos;
    public static long[] keyPos;
    public static long[][] dp;
    public static long[][][] a;


    public static void main(String[] args) {
        input();
        System.out.println(solve());
    }

    public static long solve() {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= k; j++) {
                if (i == j) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], distance(i - 1, j - 1));
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j - 1], Math.max(dp[i - 1][j - 1], distance(i - 1, j - 1)));
            }
        }
        return dp[n][k];
    }

    public static long distance(int a, int b) {
        return Math.abs(personPos[a] - keyPos[b]) + Math.abs(keyPos[b] - p);
    }

    public static void input() {
        n = in.nextInt();
        k = in.nextInt();
        p = in.nextInt();
        personPos = new long[n + 1];
        keyPos = new long[k + 1];
        dp = new long[n + 1][k + 1];

        for (int i = 0; i < n; i++) {
            personPos[i] = in.nextLong();
        }
        for (int i = 0; i < k; i++) {
            keyPos[i] = in.nextLong();
        }
        Arrays.sort(personPos, 0, n);
        Arrays.sort(keyPos, 0, k);
    }
}
