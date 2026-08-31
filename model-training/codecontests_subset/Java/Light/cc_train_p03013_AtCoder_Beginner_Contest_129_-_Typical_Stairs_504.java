import java.util.Scanner;

public class Main {
	static final int MOD = 1000000007;

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] hole = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			hole[i] = true;
		}
		
		int[] a = new int[M];
		
		for(int i=0; i<M; i++) {
			a[i] = sc.nextInt();
			hole[a[i]] = false;
		}
		
		int[] dp = new int[N+1];
		dp[0] = 1;
		if(hole[1]) {dp[1]=1;}
		for(int i=2; i<=N; i++) {
			if(hole[i-1]) {dp[i] = (dp[i] + dp[i-1])%MOD ;}
			if(hole[i-2]) {dp[i] = (dp[i] + dp[i-2])%MOD ;}
		}
		
		System.out.println(dp[N]);
	}
}
