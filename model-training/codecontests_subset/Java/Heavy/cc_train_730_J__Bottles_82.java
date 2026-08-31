
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bottles {

	static class Bottle {
		int a, b;

		Bottle(int x, int y) {
			a = x;
			b = y;
		}

		@Override
		public String toString() {
			return a + " " + b;
		}
	}

	static final int oo = 1 << 28;
	static final int MAX = 10001;

	static int N;
	static Bottle[] b;
	static int[][][] dp;

	static int solve(int k, int idx, int volume) {
		if(k == 0)
			return volume <= 0 ? 0 : -oo;
		if(idx == N)
			return -oo;
		if (dp[k][idx][volume] != -1)
			return dp[k][idx][volume];
		return dp[k][idx][volume] = Math.max(solve(k - 1, idx + 1, volume - b[idx].b) + b[idx].a,
				solve(k, idx + 1, volume));
	}

	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		N = sc.nextInt();
		int need = 0;
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
			need += a[i] = sc.nextInt();
		b = new Bottle[N];
		for (int i = 0; i < N; i++)
			b[i] = new Bottle(a[i], sc.nextInt());
		Arrays.sort(b, (x, y) -> x.b - y.b);
		int volume = 0, numBottles;
		for (numBottles = N - 1; numBottles >= 0 && volume < need; numBottles--)
			volume += b[numBottles].b;
		numBottles = N - numBottles - 1;
		dp = new int[numBottles + 1][N][need + 1];
		for (int i = 0; i <= numBottles; i++)
			for (int j = 0; j < N; j++)
				Arrays.fill(dp[i][j], -1);
		out.printf("%d %d\n", numBottles, need - solve(numBottles, 0, need));
		out.flush();
		out.close();
	}

	static class MyScanner {

		BufferedReader br;
		StringTokenizer st;

		MyScanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
