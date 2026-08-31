import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    char[] D = scanner.next().toCharArray();
    int K = scanner.nextInt();
    int N = D.length;
    int[][][] dp = new int[2][N + 1][K + 1];
    dp[0][0][0] = 1;
    for (int i = 1; i <= N; i++) {
      for (int k = 0; k <= K; k++) {
        if (D[i - 1] == '0') {
          dp[0][i][k] = dp[0][i - 1][k];
          dp[1][i][k] = dp[1][i - 1][k];
          if (k > 0) dp[1][i][k] += 9 * dp[1][i - 1][k - 1];
        } else {
          if (k > 0) dp[0][i][k] = dp[0][i - 1][k - 1];
          dp[1][i][k] = dp[1][i - 1][k] + dp[0][i - 1][k];
          if (k > 0) dp[1][i][k] += 9 * dp[1][i - 1][k - 1]+ (D[i - 1] - '1') * dp[0][i - 1][k - 1];
        }
      }
    }
    System.out.println(dp[0][N][K] + dp[1][N][K]);
  }
}
