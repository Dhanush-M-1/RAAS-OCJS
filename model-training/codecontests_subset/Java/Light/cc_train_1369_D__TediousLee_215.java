import java.io.*;
import java.util.*;

public class Main {
  private static long MOD = 1000000007;

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    long[][] result = solve();

    int T = Integer.parseInt(in.readLine());
    for (int t = 0; t < T; ++t) {
      int n = Integer.parseInt(in.readLine());

      System.out.println(Math.max(result[n][0], result[n][1]));
    }

    in.close();
  }

  private static long[][] solve() {
    long[][] dp = new long[2000001][2];

    dp[1][0] = dp[1][1] = 0;
    dp[2][0] = dp[2][1] = 0;
    dp[3][1] = 4;
    dp[3][0] = 0;

    for (int i = 4; i <= 2000000; ++i) {
      dp[i][1] = (4 + dp[i - 2][0] * 2 + dp[i - 1][0]) % MOD;
      dp[i][0] = (Math.max(dp[i - 2][1], dp[i - 2][0]) * 2 + Math.max(dp[i - 1][1], dp[i - 1][0])) % MOD;
    }

    return dp;
  }
}