import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    resolve(System.in, System.out);
  }

  static final int SAME_AS_N_SO_FAR = 0;
  static final int LESS_THAN_OR_EQ_N = 1;

  static void resolve(InputStream is, PrintStream pw) {
    Scanner sc = new Scanner(is);
    String n = sc.next();
    int t = Integer.valueOf(sc.next());
    int[][][] dp = new int[n.length() + 1][t + 1][LESS_THAN_OR_EQ_N + 1];
    dp[0][0][SAME_AS_N_SO_FAR] = 1;
    for (int i = 0; i < n.length(); i++) {
      for (int j = 0; j <= t; j++) {
        for (int k = SAME_AS_N_SO_FAR; k <= LESS_THAN_OR_EQ_N; k++) {
          int nd = Integer.parseInt(String.valueOf(n.charAt(i)));
          for (int d = 0; d < 10; d++) {
            int ni = i + 1;
            int nj = j;
            int nk = k;
            if (d != 0) {
              nj++;
            }
            if (nj > t) {
              continue;
            }
            if (k == SAME_AS_N_SO_FAR) {
              if (d < nd) {
                nk = LESS_THAN_OR_EQ_N;
              }
              if (d > nd) {
                continue;
              }
            }
            dp[ni][nj][nk] += dp[i][j][k];
          }
        }
      }
    }
    int ans = dp[n.length()][t][0] + dp[n.length()][t][1];
    pw.println(ans);
  }
}
