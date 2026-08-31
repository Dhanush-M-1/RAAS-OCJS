import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	final static int mod = 1_000_000_007;
	
	public static void main(String[] args) throws Exception {

		STDIN scan = new STDIN();
		PrintWriter pw = new PrintWriter(System.out);

		int n = scan.nextInt();
		int[][] dp = new int[n][3]; // 0 not cut, 1 cut backward, 2 cut forward
		int[] x = new int[n], h = new int[n];
		for(int i = 0; i < n; i++) {
			x[i] = scan.nextInt();
			h[i] = scan.nextInt();
		}
		dp[0][0] = 0; dp[0][1] = 1; dp[0][2] = (n == 1 || x[0] + h[0] < x[1]) ? 1 : 0;
		for(int i = 1; i < n; i++) {
			dp[i][0] = dp[i][1] = dp[i][2] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
			if(i+1 == n || x[i] + h[i] < x[i+1]) dp[i][2]++;
			if(x[i-1] + h[i-1] < x[i] - h[i]) dp[i][1]++;
			else if(x[i-1] < x[i] - h[i]) dp[i][1] = Math.max(dp[i][1], 1 + Math.max(dp[i-1][0], dp[i-1][1]));
		}
		pw.println(Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2])));
	
		pw.flush();
	}

	
	static class STDIN {
		BufferedReader br;
		StringTokenizer st;

		public STDIN() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = null;
		}
		
		boolean hasNext() throws Exception {
			if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			return st.hasMoreTokens();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws Exception {
			return br.readLine();
		}
	}
}