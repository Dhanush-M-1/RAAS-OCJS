
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        boolean[] broken = new boolean[N+1];

        for (int i=0; i<M; i++) {
            broken[scanner.nextInt()] = true;
        }

        long[] dp = new long[N+2];
        dp[N+1] = 0;
        dp[N] = 1;
        for (int i=N-1; i >= 0; i--) {
            if (broken[i]) {
                dp[i] = 0;
                continue;
            }
            dp[i] = (dp[i+1] + dp[i+2]) % 1000000007;
        }
        System.out.println(dp[0]);
    }
}
