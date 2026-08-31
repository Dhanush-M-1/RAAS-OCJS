import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskA {
		Random random = new Random();

		public void solve(int testNumber, FastScanner in, PrintWriter out) {
			int n = in.nextInt();
			int k = in.nextInt();
			int p = in.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			randomShuffle(a);
			Arrays.sort(a);
			int[] b = new int[k];
			for (int i = 0; i < k; i++) {
				b[i] = in.nextInt();
			}
			randomShuffle(b);
			Arrays.sort(b);

			long[][] d = new long[n + 1][k + 1];
			final long infinity = Long.MAX_VALUE / 2;
			for (long[] arr : d) {
				Arrays.fill(arr, infinity);
			}
			d[0][0] = 0;
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j < k; j++) {
					if (d[i][j] >= infinity) {
						continue;
					}
					d[i][j + 1] = Math.min(d[i][j + 1], d[i][j]);
					if (i + 1 <= n) {
						long cost = (long) Math.abs(a[i] - b[j]) + (long) Math.abs(b[j] - p);
						d[i + 1][j + 1] = Math.min(d[i + 1][j + 1], Math.max(d[i][j], cost));
					}
				}
			}
			out.println(d[n][k]);
		}

		private void randomShuffle(int[] a) {
			for (int i = 0; i < a.length; i++) {
				int j = random.nextInt(i + 1);
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}

	}

	static class FastScanner {
		private BufferedReader in;
		private StringTokenizer st;

		public FastScanner(InputStream stream) {
			in = new BufferedReader(new InputStreamReader(stream));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String rl = in.readLine();
					if (rl == null) {
						return null;
					}
					st = new StringTokenizer(rl);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
}

