import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(final String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        String N;
        N = sc.next();
        int K;
        K = sc.nextInt();

        final Solver solver = new Solver();
        solver.solve(N, K);
    }
}

class Solver {
    public void solve(String N, int K) {
        final int L = N.length();
        final long[][][] dp = new long[L + 1][2][K + 1];

        // dp[i][j][k]:
        //  i 桁まで決定
        //  N 未満フラグ (0: 未満未確定, 1: 未満確定)
        //  0 でない桁が k 個
        dp[0][0][0] = 1;
        for (int i = 0; i < L; i++) {
            final int D = N.charAt(i) - '0';

            for (int j = 0; j < 2; j++) {

                for (int k = 0; k < K + 1; k++) {

                    for (int d = 0; d <= (j == 1 ? 9 : D); d++) {
                        if (d != 0 && k == K) continue;

                        boolean smaller = j == 1 || d < D;
                        int s = smaller ? 1 : 0;
                        int l = k + (d == 0 ? 0 : 1);
                        dp[i + 1][s][l] += dp[i][j][k];
                    }
                }
            }
        }

        System.out.println(dp[L][0][K] + dp[L][1][K]);
    }
}

