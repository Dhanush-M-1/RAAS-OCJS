import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	private static final int MAXN = 5000;
	private static final String NO = "NO";
	private static final String YES = "YES";
	InputStream is;
	PrintWriter out;
	String INPUT = "";

	private static final long MOD = 1000000007L;
	private static final int MAX = 200000;

	void solve() {
		int Q = ni();
		while (Q-- > 0) {
			int N = ni();
			long l = nl() - 1;
			long r = nl() - 1;
			long cur = 0;
			for (int i = 1; i <= N && cur <= r; i++) {
				if (cur + 2 * (N - i) < l)
					cur += 2 * (N - i);
				else {
					for (int j = i + 1; j <= N && cur <= r; j++) {
						if (cur >= l && cur <= r)
							out.print(i + " ");
						cur++;
						if (cur >= l && cur <= r)
							out.print(j + " ");
						cur++;
					}
				}
			}
//			tr(cur, r);
			if (cur <= r)
				out.print(1);
			out.println();
		}
	}

	class segTree {
		int[] tree;
		int[] lazy;

		public segTree(int n) {
			tree = new int[4 * n + 2];
			lazy = new int[4 * n + 2];
		}

		public void build(int node, int l, int r, int[] ar) {
			if (l == r) {
				tree[node] = ar[l];
				return;
			}
			int mid = (l + r) / 2;
			build(2 * node, l, mid, ar);
			build(2 * node + 1, mid + 1, r, ar);
			tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
		}

		public void update(int node, int l, int r, int s, int e, int val) {
			if (lazy[node] != 0) {
				tree[node] += lazy[node];
				if (l != r) {
					lazy[2 * node] += lazy[node];
					lazy[2 * node + 1] += lazy[node];
				}
				lazy[node] = 0;
			}
			if (l > e || r < s)
				return;
			if (l >= s && r <= e) {
				tree[node] += val;
				if (l != r) {
					lazy[2 * node] += val;
					lazy[2 * node + 1] += val;
				}
				return;
			}
			int mid = (l + r) / 2;
			update(2 * node, l, mid, s, e, val);
			update(2 * node + 1, mid + 1, r, s, e, val);
			tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
		}

	}

	long power(long a, long b) {
		long x = 1, y = a;
		while (b > 0) {
			if (b % 2 != 0) {
				x = (x * y) % MOD;
			}
			y = (y * y) % MOD;
			b /= 2;
		}
		return x % MOD;
	}

	private long gcd(long a, long b) {
		while (a != 0) {
			long tmp = b % a;
			b = a;
			a = tmp;
		}
		return b;
	}

	void run() throws Exception {
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);

		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if (!INPUT.isEmpty())
			tr(System.currentTimeMillis() - s + "ms");
	}

	public static void main(String[] args) throws Exception {
		new Main().run();
	}

	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	private boolean vis[];

	private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	private boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	private int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	private double nd() {
		return Double.parseDouble(ns());
	}

	private char nc() {
		return (char) skip();
	}

	private String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != '
									// ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	private char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n) {
			if (!(isSpaceChar(b)))
				buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	private char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}

	private int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	private List<Integer> na2(int n) {
		List<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			a.add(ni());
		return a;
	}

	private int[][] na(int n, int m) {
		int[][] a = new int[n][];
		for (int i = 0; i < n; i++)
			a[i] = na(m);
		return a;
	}

	private int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	private long[] nl(int n) {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nl();
		return a;
	}

	private long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	private static void tr(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
}