import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        final int M = sc.nextInt();

        boolean[] ok = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            ok[i] = true;
        }

        for (int i = 0; i < M; i++) {
            ok[sc.nextInt()] = false;
        }

        final int[] dp = new int[N+1];
        for (int i = 0; i <= N; i++) dp[i] = 0;

        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j <= Math.min(N, i+2); j++) {
                if (ok[j]) {
                    dp[j] += dp[i];
                    dp[j] %= 1000000007;
                }
            }
        }

        System.out.println(dp[dp.length-1]);
    }
}
