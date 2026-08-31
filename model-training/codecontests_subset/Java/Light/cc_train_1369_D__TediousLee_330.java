
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * <pre>
 * Success is not final, failure is not fatal.
 * The courage to continue is what counts.
 * </pre>
 * @author bodmas
 * @since Jun 24, 2020.
 */
public class ProblemD {

    private static final int MOD = (int) 1e9 + 7;
    private int[][] dp = new int[(int) 2e6 + 1][2];
    {
        for (int i = 3; i < dp.length; i++) {// 0-included, 1-excluded
            dp[i][0] = (int) ((4 + 2L * dp[i - 2][1] + dp[i - 1][1]) % MOD);
            dp[i][1] = (int) ((2L * Math.max(dp[i - 2][0], dp[i - 2][1]) + Math.max(dp[i - 1][0], dp[i - 1][1])) % MOD);
        }
    }

    private int solve(int n) {
        return Math.max(dp[n][0], dp[n][1]);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out))) {

            final ProblemD problemD = new ProblemD();
            int t = Integer.parseInt(in.readLine());
            while (t-- != 0) {
                int n = Integer.parseInt(in.readLine());
                out.println(problemD.solve(n));
            }
        }
    }
}
