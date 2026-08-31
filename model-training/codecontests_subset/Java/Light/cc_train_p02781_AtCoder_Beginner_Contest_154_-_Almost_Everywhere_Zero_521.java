import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    char[] ns = scanner.next().toCharArray();
    int N = ns.length;
    int[] digits = new int[N + 1];
    for (int i = 0; i < N; i++) digits[i + 1] = ns[i] - '0';
    int K = scanner.nextInt();

    long[][] dp0 = new long[N + 1][K + 1];
    long[][] dp1 = new long[N + 1][K + 1];
    dp0[0][0] = 1;
    for (int i = 1; i <= N; i++) {
      for (int j = 0; j <= K; j++) {
        dp1[i][j] = dp1[i - 1][j];
        if (j > 0) dp1[i][j] += dp1[i - 1][j - 1] * 9;
        if (digits[i] == 0) {
          dp0[i][j] = dp0[i - 1][j];
        } else {
          if (j > 0) dp0[i][j] = dp0[i - 1][j - 1];
          dp1[i][j] += dp0[i - 1][j];
          if (j > 0) dp1[i][j] += dp0[i - 1][j - 1] * (digits[i] - 1);
        }
      }
    }
    System.out.println(dp0[N][K] + dp1[N][K]);
  }
}
