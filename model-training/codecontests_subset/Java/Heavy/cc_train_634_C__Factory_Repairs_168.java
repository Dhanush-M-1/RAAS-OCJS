import java.util.*;
import java.io.*;

public class C {
	FastScanner in;
	PrintWriter out;

	class SegmentTree {
		int n;
		int[] t;

		public SegmentTree(int size) {
			n = size;
			t = new int[4 * n];
		}

		int sum(int l, int r) {
			return sum(0, 0, n, l, r);
		}

		int sum(int v, int tl, int tr, int l, int r) {
			if (l <= tl && tr <= r) {
				return t[v];
			}
			if (l >= tr || r <= tl) {
				return 0;
			}
			int tm = (tl + tr) / 2;
			return sum(2 * v + 1, tl, tm, l, r) + sum(2 * v + 2, tm, tr, l, r);
		}

		void set(int i, int val) {
			set(0, 0, n, i, val);
		}

		void set(int v, int tl, int tr, int i, int val) {
			if (tr - tl == 1) {
				t[v] = val;
				return;
			}
			int tm = (tl + tr) / 2;
			if (i < tm) {
				set(2 * v + 1, tl, tm, i, val);
			} else {
				set(2 * v + 2, tm, tr, i, val);
			}
			t[v] = t[2 * v + 1] + t[2 * v + 2];
		}
	}
	
	void add(int i, int val, SegmentTree tree, int max) {
		int cur = tree.sum(i, i + 1);
		val = Math.min(cur + val, max);
		tree.set(i, val);
	}

	public void solve() throws IOException {
		int n = in.nextInt(), k = in.nextInt();
		int a = in.nextInt(), b = in.nextInt();
		int q = in.nextInt();
		SegmentTree treeA = new SegmentTree(n), treeB = new SegmentTree(n);
		for (int i = 0; i < q; i++) {
			int type = in.nextInt();
			if (type == 1) {
				int d = in.nextInt() - 1, add = in.nextInt();
				add(d, add, treeA, a);
				add(d, add, treeB, b);
			} else {
				int l = in.nextInt() - 1;
				int res = treeB.sum(0, l);
				if (l + k < n) {
					res += treeA.sum(l + k, n);
				}
				out.println(res);
			}
		}
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
		new C().run();
	}
}