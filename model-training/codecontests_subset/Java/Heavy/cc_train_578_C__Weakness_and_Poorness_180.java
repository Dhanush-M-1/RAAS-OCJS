import java.util.*;
import java.io.*;

public class B {
	FastScanner in;
	PrintWriter out;

	int n;
	double[] a;
	
	double f(double x) {
		double ans = 0;
		double pos = 0, neg = 0;
		for (int r = 0; r < n; r++) {
			if (pos < 0) {
				pos = 0;
			}
			if (neg > 0) {
				neg = 0;
			}
			pos += a[r] - x;
			neg += a[r] - x;
			ans = Math.max(ans, Math.max(pos, -neg));
		}
		return ans;
	}
	
	public void solve() throws IOException {
		n = in.nextInt();
		a = new double[n];
		double max = Double.NEGATIVE_INFINITY;
		double min = Double.POSITIVE_INFINITY;
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			max = Math.max(max, a[i]);
			min = Math.min(min, a[i]);
		}
		double l = min, r = max;
		for (int iter = 0; iter < 100; iter++) {
			double m1 = (2 * l + r) / 3;
			double m2 = (l + 2 * r) / 3;
			double f1 = f(m1), f2 = f(m2);
			if (f1 < f2) {
				r = m2;
			} else {
				l = m1;
			}
		}
		out.println(f(l));
	}

	public void run() {
		try {
			in = new FastScanner();
			out = new PrintWriter(System.out);

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}

	public static void main(String[] arg) {
		new B().run();
	}
}