import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = scan.nextInt();
        int M = scan.nextInt();
        HashSet<Integer> bad = new HashSet<>();
        for (int i = 0; i < M; i++) {
            bad.add(scan.nextInt());
        }
        long[] dp = new long[N+1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            if (bad.contains(i)) {
                dp[i] = 0;
                continue;
            }
            if (2 <= i) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else if (i == 1) {
                dp[i] = dp[i - 1];
            }
            dp[i] = dp[i] % 1000000007;
        }
        long answer = dp[N];
        System.out.println(answer);
    }
}
