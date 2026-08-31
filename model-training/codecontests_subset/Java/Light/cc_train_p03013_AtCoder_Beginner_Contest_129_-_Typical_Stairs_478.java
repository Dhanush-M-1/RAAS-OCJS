
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		boolean[] jdg = new boolean[n+1];
		long mod = 1000000007;
		for(int i = 0; i < m; i++) {
			a[i] = sc.nextInt();
			jdg[a[i]] = true;
		}
		long[] dp = new long[n+1];
		dp[0] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j <= Math.min(n, i+2); j++) {
				if(jdg[j] == false) {
					dp[j] += dp[i];
					dp[j] %= mod;
				}
			}
		}
		System.out.println(dp[n]);
	}
}
