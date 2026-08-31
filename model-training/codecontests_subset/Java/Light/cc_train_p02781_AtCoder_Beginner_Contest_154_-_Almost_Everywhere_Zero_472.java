import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int l = N.length();
        int K = sc.nextInt();
        int[][][] dp = new int[l+1][K+1][2];
        dp[0][0][1] = 1;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i+1][j][0] += dp[i][j][0];
                if (j+1 <= K) {
                    dp[i+1][j+1][0] += 9*dp[i][j][0];
                }
                int a = N.charAt(i)-'0';
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
        System.out.println(dp[l][K][0]+dp[l][K][1]);
    }
}

