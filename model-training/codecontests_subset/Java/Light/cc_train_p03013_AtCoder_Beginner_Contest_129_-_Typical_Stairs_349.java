import java.util.HashSet;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    long MOD = 1_000_000_007;
    int N = scanner.nextInt();
    int M = scanner.nextInt();
    HashSet<Integer> a = new HashSet<>();
    for (int i = 0; i < M; i++) a.add(scanner.nextInt());
    long[] dp = new long[N + 1];
    dp[0] = 1;
    if (!a.contains(1)) dp[1] = 1;
    for (int i = 2; i <= N; i++) {
      if (!a.contains(i)) {
        dp[i] += dp[i - 1];
        if (dp[i] >= MOD) dp[i] -=MOD;
        dp[i] += dp[i - 2];
        if (dp[i] >= MOD) dp[i] -=MOD;
      }
    }
    System.out.println(dp[N]);
  }
}
