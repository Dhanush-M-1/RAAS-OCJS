import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int MOD = 1_000_000_007;

    private static int N;
    private static int M;
    private static boolean[] a;

    private static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt() + 1;
        M = sc.nextInt();

        a = new boolean[N];
        Arrays.fill(a, true);

        for (int i = 0; i < M; i++) {
            a[sc.nextInt()] = false;
        }

        dp = new int[N];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            if (!a[i]) continue;

            if (i + 1 < N) {
                dp[i + 1] = (dp[i + 1] + dp[i]) % MOD;
            }
            if (i + 2 < N) {
                dp[i + 2] = (dp[i + 2] + dp[i]) % MOD;
            }
        }

        System.out.println(dp[N - 1]);
    }

}
