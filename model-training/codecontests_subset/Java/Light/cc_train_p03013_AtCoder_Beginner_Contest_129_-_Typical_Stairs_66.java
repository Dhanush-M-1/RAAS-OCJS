import java.util.*;

public class Main {
    static final int MOD = 1000000007;
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < m; i++) {
		    set.add(sc.nextInt());
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		if (!set.contains(1)) {
		    dp[1] = 1;
		}
		for (int i = 2; i <= n; i++) {
		    if (!set.contains(i)) {
		        dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
		    }
		}
		System.out.println(dp[n]);
   }
}
