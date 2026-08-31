import java.util.*;

public class Main {
    static final int MOD = 1000000007;
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
		int length = arr.length;
		int[] values = new int[length + 1];
		for (int i = 0; i < length; i++) {
		    values[i + 1] = arr[i] - '0';
		}
		int kk = sc.nextInt();
		long[][][] dp = new long[length + 1][kk + 2][2];
		dp[0][0][1] = 1;
		for (int i = 1; i <= length; i++) {
		    for (int j = 0; j <= kk; j++) {
		        dp[i][j][0] += dp[i - 1][j][0];
		        dp[i][j][0] %= MOD;
	            dp[i][j + 1][0] += dp[i - 1][j][0] * 9;
	            dp[i][j + 1][0] %= MOD;
		        if (values[i] == 0) {
		            dp[i][j][1] += dp[i - 1][j][1];
		            dp[i][j][1] %= MOD;
		            continue;
		        }
	            dp[i][j][0] += dp[i - 1][j][1];
	            dp[i][j][0] %= MOD;
	            dp[i][j + 1][0] += dp[i - 1][j][1] * (values[i] - 1);
	            dp[i][j + 1][0] %= MOD;
		        dp[i][j + 1][1] += dp[i - 1][j][1];
		    }
		}
		System.out.println((dp[length][kk][0] + dp[length][kk][1]) % MOD);
   }
}
