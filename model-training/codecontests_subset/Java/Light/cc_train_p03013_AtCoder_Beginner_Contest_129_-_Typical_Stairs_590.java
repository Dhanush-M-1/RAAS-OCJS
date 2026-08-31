
import java.util.Scanner;


public class Main {
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] broken = new boolean[n+1];
		
		for (int i=0;i<m;i++) {
			broken[sc.nextInt()]=true;
		}
		
		long[] dp = new long[n+1];
		dp[0]=1;
		
		for (int i=1;i<=n;i++) {
			if (broken[i]) {
				dp[i]=0;
			} else {
				if (i==1) {
					dp[i]=1;
				} else {
					dp[i]=(dp[i-1]+dp[i-2])%1_000_000_007;
				}
			}
		}
		System.out.println(dp[n]);
	}
}