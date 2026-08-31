import java.util.Arrays;
import java.util.Scanner;

class Main{
	static int mod = 1000000007;
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[M];
		for(int i = 0; i < M; i++) a[i] = sc.nextInt();
		int[] dp = new int[N + 3];
		Arrays.fill(dp, 0);
		dp[0] = 1;
		for(int i = 0; i < M; i++) dp[a[i]] = -1;
		for(int i = 0; i < N; i++) {
			if(dp[i] == -1) continue;
			if(dp[i + 1] != -1) {
				dp[i + 1] += dp[i];
				dp[i + 1] %= mod;
			}
			if(dp[i + 2] != -1) {
				dp[i + 2] += dp[i];
				dp[i + 2] %= mod;
			}
		}
		System.out.println(dp[N]);
	}
}