import static java.lang.System.*;
import java.util.*;

public class Main {
	public static final int MOD = 1000000007;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
		int m = sc.nextInt();
		
		boolean[] wet = new boolean[n+1];
		Arrays.fill(wet, false);
		for(int i=0; i<m; i++) wet[sc.nextInt()] = true;

		int[] dp = new int[n+3];
		Arrays.fill(dp, 0);
		
		dp[0] = 1;
		for(int i=0; i<=n; i++) {
			if(wet[i]) continue;

			dp[i+1] += dp[i];
			dp[i+1] %= MOD;
			dp[i+2] += dp[i];
			dp[i+2] %= MOD;
		}
		
        out.println(dp[n]);
    }
}
