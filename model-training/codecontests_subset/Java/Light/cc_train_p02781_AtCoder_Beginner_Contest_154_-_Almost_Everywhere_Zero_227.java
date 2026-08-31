import java.util.Scanner;

/**
 * 桁DP問題
 * ABC154E http://drken1215.hatenablog.com/entry/2020/02/09/225300
 * 桁DPの思想 http://drken1215.hatenablog.com/entry/2019/02/04/013700
 * 参考提出@yuya178 https://atcoder.jp/contests/abc154/submissions/9990765
 */
public class Main {
    private static final int MOD = 1_000_000_007;
    private static final String YES = "Yes";
    private static final String NO = "No";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();
        int K = sc.nextInt();

        System.out.println(solve(N, K));
    }

    private static long solve(String N, int K) {
        //[上限ギリギリか][桁数][条件]
        long[][][] dp = new long[2][N.length()+1][K+2];
        dp[1][0][0] = 1;
        int len = N.length();

        for (int i=0; i<len; i++) {
            int val = N.charAt(i) - '0';
            System.err.println(val);

            for (int k=0; k<=K; k++) {
                // dp[1][*][*]の更新
                if (val > 0) {
                    // ギリギリを維持するパターン
                    // 非0のvalを末尾に利用する
                    dp[1][i+1][k+1] += dp[1][i][k];

                    // ギリギリでなくなるパターン
                    // 1以上val未満の値を利用する
                    dp[0][i+1][k+1] += dp[1][i][k] * (val-1);
                    // 0を利用する場合はKの条件は更新されない
                    dp[0][i+1][k]   += dp[1][i][k];
                } else {
                    // 0の場合はギリギリが自動的に維持される
                    dp[1][i+1][k] += dp[1][i][k];
                }


                // dp[0][*][*]の更新
                // 0でない任意の値を利用する場合
                dp[0][i+1][k+1] += dp[0][i][k] * 9;
                // 0を利用する場合
                dp[0][i+1][k]   += dp[0][i][k];
            }
        }

        return dp[0][len][K] + dp[1][len][K];
    }
}