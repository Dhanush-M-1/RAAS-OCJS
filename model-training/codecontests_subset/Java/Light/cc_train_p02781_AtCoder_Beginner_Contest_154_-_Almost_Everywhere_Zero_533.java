import java.util.Scanner;

public class Main {

    static long dp[][][];
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        char[] n = sc.next().toCharArray();
        int K = sc.nextInt();

        System.out.println(digitDP(n, K));
    }

    static long digitDP(char[] s, int K) {

        final int L = s.length;
        dp = new long[103][2][K + 1];
        dp[0][0][0] = 1;
        for (int i = 0 ; i < L ; i++) {
            final int D = s[i] - '0';
            for (int j = 0 ; j < 2 ; j++) {
                for (int k = 0 ; k <= K ; k++) {
                    for (int d = 0 ; d <= (j != 0 ? 9 : D) ; d++) {
                        if (d == 0) {
                            dp[i + 1][(j == 1 || (d < D)) ? 1 : 0][k] += dp[i][j][k];
                        } else {
                            if (k < K) {
                                dp[i + 1][(j == 1 || (d < D)) ? 1 : 0][k + 1] += dp[i][j][k];
                            }
                        }

                    }
                }
            }
        }

        return dp[L][0][K] + dp[L][1][K];
    }

}