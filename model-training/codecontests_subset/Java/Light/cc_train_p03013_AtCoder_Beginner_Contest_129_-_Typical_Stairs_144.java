import java.util.*;

public class Main {
	Scanner sc = new Scanner(System.in);
	final int MOD = 1000000007;
	final int MAX = Integer.MAX_VALUE;
	final long LMAX = Long.MAX_VALUE;

	int max3(int a, int b, int c) {
		int max = ((a < b) ? b : a);
		return (max < c)? c : max;
	}
	
	void doIt() {
		int n = sc.nextInt() + 1;
		int m = sc.nextInt();
		boolean b[] = new boolean[n];
		Arrays.fill(b, true);
		for(int i = 0; i < m; i++) 
			b[sc.nextInt()] = false;
		int dp[] = new int[n];
		Arrays.fill(dp, 0);
		dp[0] = 1;
		for(int i = 0; i < n; i++) {
			if(b[i]) {
				if(i + 1 < n) {
					dp[i + 1] = (dp[i + 1] + dp[i]) % MOD;
				}
				if(i + 2 < n) {
					dp[i + 2] = (dp[i + 2] + dp[i]) % MOD;
				}
			}
		}
		System.out.println(dp[n - 1]);
	}
	
	
	public static void main(String[] args) {
		new Main().doIt();
	}
}
