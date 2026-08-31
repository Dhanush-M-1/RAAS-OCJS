import java.io.*;
import java.util.*;

public class A {
	FastScanner in;
	PrintWriter out;

	void solve() {
		int n = in.nextInt(), m = in.nextInt();
		int[] a = new int[m];
		for (int i = 0; i < n; i++) {
			int k = in.nextInt();
			for (int j = 0; j < k; j++) {
				int x = in.nextInt() - 1;
				a[x] = 1;
			}
		}
		for (int i = 0; i < m; i++) {
			if (a[i] == 0) {
				out.println("NO");
				return;
			}
		}
		out.println("YES");
	}

	void run() {
		in = new FastScanner();
		out = new PrintWriter(System.out);

		solve();

		out.close();
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(in.br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
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

	public static void main(String[] args) {
		new A().run();
	}
}