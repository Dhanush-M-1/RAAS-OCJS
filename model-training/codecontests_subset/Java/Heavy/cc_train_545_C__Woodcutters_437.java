import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class H {
	
	static long[][] dp;
	static long[] trees;
	static long[] h;
	
	static final long INF = 200000000000L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] parts;
		trees = new long[N + 2];
		h = new long[N + 2];
		trees[0] = -INF;
		h[0] = 0;
		trees[N + 1] = INF;
		h[N + 1] = 0;
		for (int i = 1; i <= N; i++) {
			parts = br.readLine().split(" ");
			trees[i] = Integer.parseInt(parts[0]);
			h[i] = Integer.parseInt(parts[1]);
		}
		dp = new long[N + 2][2];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1); 
		}
		System.out.println(dp(1, 0));
	}

	private static long dp(int i, int j) {
		if (i == trees.length - 1) {
			return 0L;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		long dist = trees[i] - trees[i - 1];
		if (j == 1) {
			dist -= h[i - 1];
		}
		if (dist > h[i]) {
			return dp[i][j] = 1 + dp(i + 1, 0);
		}
		if (trees[i + 1] - trees[i] > h[i]) {
			return dp[i][j] = Math.max(dp(i + 1, 0) , dp(i + 1, 1) + 1);
		}
		return dp[i][j] = dp(i + 1, 0);
	}
	
	

}
