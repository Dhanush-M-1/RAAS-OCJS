import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    char[] ns = scanner.next().toCharArray();
    int N = ns.length;
    for (int i = 0; i < N; i++) ns[i] = (char) (ns[i] - '0');
    int K = scanner.nextInt();

    long[][] dp1 = new long[N + 1][K + 1];
    long[][] dp2 = new long[N + 1][K + 1];
    dp1[1][1] = ns[0] - 1;
    dp1[1][0] = 1;
    dp2[1][1] = 1;
    for (int i = 2; i <= N; i++) {
      dp1[i][0] = 1;
      for (int j = 1; j <= K; j++) {
        dp1[i][j] = dp1[i - 1][j] + 9 * dp1[i - 1][j - 1];
        if (ns[i - 1] != 0) dp1[i][j] += dp2[i - 1][j] + (ns[i - 1] - 1) * dp2[i - 1][j - 1];
        if (ns[i - 1] == 0) dp2[i][j] = dp2[i - 1][j];
        else dp2[i][j]= dp2[i - 1][j - 1];
      }
    }
    System.out.println(dp1[N][K] + dp2[N][K]);
  }
}
