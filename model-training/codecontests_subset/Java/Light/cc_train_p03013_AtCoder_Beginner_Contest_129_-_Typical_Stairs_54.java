import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] dp = new int[n+1];

		for (int i=0; i<n+1; i++){
			dp[i] = 1;
		}

		for (int i=0; i<m; i++){
			int a = Integer.parseInt(sc.next());
			dp[a] = 0;
		}

		dp[1] = dp[1] != 0 ? dp[0] : 0;

		for (int i=2; i<n+1; i++){
			dp[i] = dp[i] != 0 ? (dp[i-1] + dp[i-2])%1000000007 : 0;
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]%1000000007);
	}
}