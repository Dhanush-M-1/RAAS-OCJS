import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long mod = 1000000000 + 7;
        int[] a = new int[M];
        boolean[] floors = new boolean[N + 1];
        Arrays.fill(floors, true);
        for (int i = 0; i < M; i++) {
            a[i] = sc.nextInt();
            floors[a[i]] = false;
        }

        long[] dp = new long[N + 1];
        dp[0] = 1;

        for (int now = 0; now < N; now++) {
            if (floors[now + 1]) {
                dp[now + 1] += dp[now];
                dp[now + 1] %= mod;
            }

            if (now == N - 1) {
                break;
            }

            if (floors[now + 2]) {
                dp[now + 2] += dp[now];
                dp[now + 2] %= mod;
            }
        }

        System.out.println(dp[N]);
    }
}