import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        AlmostEverywhereZero solver = new AlmostEverywhereZero();
        solver.solve(1, in, out);
        out.close();
    }

    static class AlmostEverywhereZero {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String n = in.next();
            int k = in.nextInt();

            out.println(digitDP(n, k));
        }

        static long digitDP(String num, int z) {

            char[] s = num.toCharArray();
            int size = s.length;

            // 桁数 | 未満フラグ | 条件
            long[][][] dp = new long[size + 1][2][z + 1];
            dp[0][0][0] = 1;
            for (int i = 0; i < size; i++) {
                int limit = s[i] - '0';
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k <= z; k++) {
                        int dMax = (j == 1) ? 9 : limit;
                        for (int d = 0; d <= dMax; d++) {
                            int nextJ = (j == 1) || (limit > d) ? 1 : 0;
                            int nextK = d == 0 ? k : k + 1;
                            if (nextK <= z) {
                                dp[i + 1][nextJ][nextK] += dp[i][j][k];
                            }
                        }
                    }
                }
            }
            return dp[size][1][z] + dp[size][0][z];
        }

    }
}

