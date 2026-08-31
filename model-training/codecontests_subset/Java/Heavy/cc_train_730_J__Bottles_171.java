import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class J {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = nextInt();
		int[]a = new int[n+1], b = new int[n+1];
		int s1 = 0, s2 = 0;
		for (int i = 1; i <= n; i++) {
			a[i] = nextInt();
			s1 += a[i];
		}
		ArrayList<Integer>L = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			b[i] = nextInt();
			s2 += b[i];
			L.add(b[i]);
		}
		Collections.sort(L);
		int sum = 0, k = 0;
		for (int i = L.size()-1; i >= 0; i--) {
			sum += L.get(i);
			k++;
			if (sum >= s1) {
				break;
			}
		}
		int s = s2-s1+1;
		k = n - k;
		int[][]dp = new int[s+1][k+1];
		int INF = (int) 1e9;
		for (int i = 0; i <= s; i++) {
			for (int j = 0; j <= k; j++) {
				dp[i][j] = INF;
			}
		}
		dp[0][0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = s; j >= 0; j--) {
				for (int j2 = 0; j2 <= k; j2++) {
					if (j >= b[i] && j2 > 0) {
						dp[j][j2] = Math.min(dp[j][j2], dp[j-b[i]][j2-1] + a[i]);
					}
				}
			}
		}
		int t = INF;
		for (int i = 0; i <= s2-s1; i++) {
			t = Math.min(t, dp[i][k]);
		}
		k = n-k;
		System.out.println(k+" "+t);
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