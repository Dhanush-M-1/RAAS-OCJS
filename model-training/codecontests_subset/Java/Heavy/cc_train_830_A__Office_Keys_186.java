import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class A {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = nextInt();
		int k = nextInt();
		int p = nextInt();
		int[]a = new int[n+1];
		int[]b = new int[k+1];
		for (int i = 1; i <= n; i++) {
			a[i] = nextInt();
		}
		for (int i = 1; i <= k; i++) {
			b[i] = nextInt();
		}
		Arrays.sort(a, 1, n+1);
		Arrays.sort(b, 1, k+1);
		long INF =  (long) 1e18;
		long[][]dp = new long[n+1][k+1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dp[i], INF);
		}
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= k; j++) {
				dp[i][j] = Math.min(dp[i][j-1], Math.max(dp[i-1][j-1], Math.abs(a[i]-b[j]) + Math.abs(b[j]-p)));
			}
		}
		long ans = INF;
		for (int i = 1; i <= k; i++) {
			ans = Math.min(ans, dp[n][i]);
		}
		System.out.println(ans);
		pw.close();
	}
	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	private static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	private static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	private static String next() throws IOException {
		while (st==null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}