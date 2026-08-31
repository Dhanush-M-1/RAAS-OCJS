import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] S = sc.next().toCharArray();
        int N = S.length;
        int K = sc.nextInt();
        int[][][] dp = new int[N+1][K+1][2];
        dp[0][0][1] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= K; j++) {
                for (int s = 0; s < 2; s++) {
                    if (dp[i][j][s] == 0)  continue;
                    if (s == 0) {
                        dp[i+1][j][0] += dp[i][j][0];
                        if (j+1 <= K) {
                            dp[i+1][j+1][0] += 9*dp[i][j][0];
                        }
                    } else {
                        int a = S[i]-'0';
                        if (a == 0) {
                            dp[i+1][j][1] += dp[i][j][1];
                        } else {
                            dp[i+1][j][0] += dp[i][j][1];
                            if (j+1 <= K) {
                                dp[i+1][j+1][0] += (a-1)*dp[i][j][1];
                                dp[i+1][j+1][1] += dp[i][j][1];
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[N][K][0]+dp[N][K][1]);
    }
}

