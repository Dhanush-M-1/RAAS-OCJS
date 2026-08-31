import java.io.*;
import java.util.*;

public class C {
	FastScanner in;
	PrintWriter out;

	void solve() {
		int n = in.nextInt(), m = in.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = in.nextInt();
		}
		boolean[] was = new boolean[n];
		int[] st1 = new int[n];
		int[] st2 = new int[n];
		int sp1 = 0, sp2 = 0;
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = in.nextInt() - 1;
			if (!was[b[i]]) {
				st1[sp1++] = b[i];
				was[b[i]] = true;
			}
		}
		while (sp1 > 0) {
			st2[sp2++] = st1[--sp1];
		}
		int ans = 0;
		for (int i = 0; i < m; i++) {
			int x = b[i];
			while (st2[sp2 - 1] != x) {
				int y = st2[--sp2];
				ans += w[y];
				st1[sp1++] = y;
			}
			sp2--;
			while (sp1 > 0) {
				st2[sp2++] = st1[--sp1];
			}
			st2[sp2++] = x;
		}
		out.println(ans);
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
		new C().run();
	}
}