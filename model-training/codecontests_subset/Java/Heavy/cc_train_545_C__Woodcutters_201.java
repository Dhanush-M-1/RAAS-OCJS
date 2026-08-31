import java.util.*;
import java.io.*;

public class C545 {
	
	public static void main(String[] args) throws Exception {

		int n = Integer.parseInt(in.readLine());

		int[] h = new int[n];
		int[] x = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			x[i] = i();
			h[i] = i();
		}

		int[][] dp = new int[n][3];
		int MIN = -100000;

		dp[0][0] = 0;
		dp[0][1] = 1;
		dp[0][2] = n > 1 ? x[0] + h[0] < x[1] ? 1 : 0 : 1;

		for (int i = 1; i < n; i++) {
			dp[i][0] = max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]);

			int l = x[i - 1] < x[i] - h[i] ? 1 : MIN;
			int l2 = x[i - 1] + h[i - 1] < x[i] - h[i] ? 1 : MIN;
			int r = i == n - 1 ? 1 : x[i] + h[i] < x[i + 1] ? 1 : MIN;

			dp[i][1] = max(dp[i - 1][0] + l, dp[i - 1][1] + l, dp[i - 1][2] + l2);

			dp[i][2] = r + dp[i][0];
		}	

		out.println(max(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]));

		out.close();
	}

	public static int max(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}

	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static {
		try {
			in = new BufferedReader(new FileReader("cf.in"));
		} catch (Exception e) {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	static int i() {return Integer.parseInt(st.nextToken());}
	static double d() {return Double.parseDouble(st.nextToken());}
	static String s() {return st.nextToken();}
	static long l() {return Long.parseLong(st.nextToken());}
}
