import java.util.Scanner;
 
public class Main {
	static final long MOD = 1_000_000_007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		boolean[] broken = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			broken[a] = true;
		}
		
		long[] dp = new long[n + 1];
		dp[0] = 1;
		dp[1] = broken[1] ? 0 : 1;
		for (int i = 2 ; i < dp.length; i++) {
			dp[i] = broken[i] ? 0 : (dp[i - 2] + dp[i - 1]) % MOD;
		}
		
//		System.out.println(Arrays.toString(dp));
		
		System.out.println(dp[n]);
		
		sc.close();
	}
}

