import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int K = sc.nextInt();
		int digit = N.length();
		int[][][] dp = new int[digit+1][K+1][2];
		dp[0][0][0] = 1;
		for(int i = 1; i <= digit; i++) {
			int x = Character.getNumericValue(N.charAt(i-1));
				for(int j = 0; j <= K; j++) {
					dp[i][j][1] = dp[i-1][j][1];
					if(j > 0)
						dp[i][j][1] += dp[i-1][j-1][1] * 9;
					if(x == 0)
						dp[i][j][0] = dp[i-1][j][0];
					else {
						dp[i][j][1] += dp[i-1][j][0];
						if(j > 0) {
							dp[i][j][0] = dp[i-1][j-1][0];
							dp[i][j][1] += dp[i-1][j-1][0] * (x-1);
						}
					}
				}
		}
		System.out.println(dp[digit][K][0] + dp[digit][K][1]);

	}

}