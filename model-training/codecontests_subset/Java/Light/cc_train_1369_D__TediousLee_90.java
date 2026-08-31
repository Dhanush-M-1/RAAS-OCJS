import java.util.*;
import java.io.*;
public class d {
	static final FS sc = new FS();
	static final PrintWriter pw = new PrintWriter(System.out);
	
	static final int mod = 1_000_000_007;
	static final int max = 2_000_000;
	static final long[][] dp = new long[2][max + 1];
	
	public static void main(String[] args) {
		// dp[haveWeTakenRootAlready][level]
		for(int i = 3; i <= max; ++i) {
			dp[1][i] = (dp[0][i - 2] + dp[0][i - 1] + dp[0][i - 2]) % mod;
			dp[0][i] = (dp[1][i - 2] + dp[1][i - 1] + dp[1][i - 2]) % mod;
			
			if(dp[0][i] == dp[1][i]) dp[0][i] = (dp[0][i] + 4) % mod;
			else dp[0][i] = dp[1][i];
		}
		
		int t = sc.nextInt();
		for(int tt = 1; tt <= t; ++tt) {
			pw.println(dp[0][sc.nextInt()]);
		}
		pw.flush();
	}
	static class FS {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String next() {
			while(!st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(Exception e) {}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}