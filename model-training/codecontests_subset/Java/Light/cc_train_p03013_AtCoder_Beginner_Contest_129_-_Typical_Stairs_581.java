import java.math.BigDecimal;
import java.util.*;
import java.util.stream.*;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    long[] dp = new long[N+1];
    for (int i = 0; i < M; i++) {
      dp[sc.nextInt()] = -1;
    }
    dp[0] = 1;
    dp[1] = dp[1] == 0 ? 1 : 0;
    for (int i = 2; i < N+1; i++) {
      if (dp[i] == -1) {
        dp[i] = 0;
      } else {
        dp[i] = dp[i-1] + dp[i-2];
        dp[i] %= 1000000007;
      }
    }
    System.out.println(dp[N]);
  }
}