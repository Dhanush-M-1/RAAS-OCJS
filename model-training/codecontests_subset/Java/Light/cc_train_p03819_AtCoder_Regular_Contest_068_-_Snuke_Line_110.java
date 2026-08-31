import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
		TaskE solver = new TaskE();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskE {
		public void solve(int testNumber, FastScanner in, PrintWriter out) {
			int n = in.nextInt();
			int m = in.nextInt();
			Segment[] s = new Segment[n];
			for (int i = 0; i < n; i++) {
				int l = in.nextInt();
				int r = in.nextInt();
				s[i] = new Segment(l, r);
			}
			Arrays.sort(s);
			int p = 0;
			Tree tree = new Tree(m + 1);
			for (int d = 1; d <= m; d++) {
				int ans = 0;
				while (p < n && s[p].len < d) {
					tree.add(s[p].l, s[p].r, 1);
					++p;
				}
				ans += n - p; // long segments will always hit
				for (int i = 0; i <= m; i += d) {
					ans += tree.get(i);
				}
				out.println(ans);
			}
		}

		class Segment implements Comparable<Segment> {
			int l;
			int r;
			int len;

			Segment(int l, int r) {
				this.l = l;
				this.r = r;
				this.len = r - l + 1;
			}

			public int compareTo(Segment o) {
				return len - o.len;
			}

		}

		class Tree {
			int n;
			int[] add;

			Tree(int n) {
				this.n = n;
				add = new int[4 * n];
			}

			void add(int l, int r, int val) {
				add(0, l, r, 0, n - 1, val);
			}

			int get(int x) {
				return get(0, x, 0, n - 1);
			}

			private int get(int root, int x, int L, int R) {
				if (L == R) {
					return add[root];
				}
				push(root);
				int M = (L + R) / 2;
				if (x <= M) {
					return get(2 * root + 1, x, L, M);
				}
				return get(2 * root + 2, x, M + 1, R);
			}

			private void add(int root, int l, int r, int L, int R, int val) {
				if (l > r || l > R || L > r || L > R) {
					return;
				}
				if (l == L && r == R) {
					add[root] += val;
					return;
				}
				push(root);
				int M = (L + R) / 2;
				add(2 * root + 1, l, Math.min(M, r), L, M, val);
				add(2 * root + 2, Math.max(M + 1, l), r, M + 1, R, val);
			}

			void push(int root) {
				add[2 * root + 1] += add[root];
				add[2 * root + 2] += add[root];
				add[root] = 0;
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

