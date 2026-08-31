import java.io.*;
import java.util.*;

public class Main implements Runnable {
	boolean judge = false;
	FastReader scn;
	PrintWriter out;
	String INPUT = "";

	void solve() {
		int n = scn.nextInt(), m = scn.nextInt(), Q = scn.nextInt();
		int[] from = new int[m], to = new int[m];
		DisJointSet dj = new DisJointSet(n);
		for (int i = 0; i < m; i++) {
			from[i] = scn.nextInt() - 1;
			to[i] = scn.nextInt() - 1;
			dj.union(from[i], to[i]);
		}

		q = new int[n];
		dist = new int[n];
		par = new int[n];
		Arrays.fill(dist, n);

		int[][] g = packU(n, from, to);
		int[] vis = new int[n];
		int[] dia = new int[n];
		for (int i = 0; i < n; i++) {
			if (vis[i] != 0) {
				continue;
			}

			int[] rv = farthest(g, vis, i);
			rv = farthest(g, vis, rv[0]);

			int rt = dj.root(i);
			dia[rt] = rv[1];
		}

		while (Q-- > 0) {
			int type = scn.nextInt();
			if (type == 1) {
				int x = scn.nextInt() - 1;
				int root = dj.root(x);
				out.println(dia[root]);
			} else {
				int x = scn.nextInt() - 1, y = scn.nextInt() - 1;
				if (!dj.isSame(x, y)) {
					int r1 = dj.root(x), r2 = dj.root(y);
					dj.union(x, y);

					int max = Math.max(dia[r1], dia[r2]);
					max = Math.max(max, 1 + (dia[r1] + 1) / 2 + (dia[r2] + 1) / 2);
					int root = dj.root(x);
					dia[root] = max;
				}
			}
		}
	}

	int[] q, dist, par;

	int[] farthest(int[][] g, int[] vis, int u) {
		int ptr = 0;
		q[ptr++] = u;
		dist[u] = 0;
		vis[u] = 1;
		par[u] = -1;
		int rv = u, dis = 0;
		for (int i = 0; i < ptr; i++) {
			u = q[i];
			for (int v : g[u]) {
				if(par[u] == v) {
					continue;
				}
				par[v] = u;
				dist[v] = 1 + dist[u];
				q[ptr++] = v;
				vis[v] = 1;
				if (dist[v] > dis) {
					dis = dist[v];
					rv = v;
				}
			}
		}
		return new int[] { rv, dis };
	}

	int[][] packU(int n, int[] from, int[] to) {
		int[][] g = new int[n][];
		int[] p = new int[n];
		for (int f : from)
			p[f]++;
		for (int t : to)
			p[t]++;
		for (int i = 0; i < n; i++)
			g[i] = new int[p[i]];
		for (int i = 0; i < from.length; i++) {
			g[from[i]][--p[from[i]]] = to[i];
			g[to[i]][--p[to[i]]] = from[i];
		}
		return g;
	}

	class DisJointSet {
		int[] table, rank, count;
		int size;

		DisJointSet(int size) {
			this.table = new int[size];
			this.rank = new int[size];
			this.count = new int[size];
			this.size = size;
			for (int i = 0; i < size; i++) {
				this.table[i] = i;
				this.rank[i] = 1;
				this.count[i] = 1;
			}
		}

		boolean isSame(int x, int y) {
			return root(x) == root(y);
		}

		int root(int node) {
			if (table[node] == node) {
				return node;
			} else {
				return table[node] = root(table[node]);
			}
		}

		void union(int x, int y) {
			x = root(x);
			y = root(y);
			if (x != y)
				this.size--;
			if (rank[x] < rank[y]) {
				table[x] = y;
				count[y] += count[x];
			} else if (rank[x] > rank[y]) {
				table[y] = x;
				count[x] += count[y];
			} else if (x != y) {
				table[y] = x;
				count[x] += count[y];
				rank[x]++;
			}
		}
	}

	public void run() {
		long time = System.currentTimeMillis();
		boolean oj = System.getProperty("ONLINE_JUDGE") != null || judge;
		out = new PrintWriter(System.out);
		scn = new FastReader(oj);
		solve();
		out.flush();
		if (!oj) {
			System.out.println(Arrays.deepToString(new Object[] { System.currentTimeMillis() - time + " ms" }));
		}
	}

	public static void main(String[] args) {
		new Thread(null, new Main(), "Main", 1 << 28).start();
	}

	class FastReader {
		InputStream is;

		public FastReader(boolean onlineJudge) {
			is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		}

		byte[] inbuf = new byte[1024];
		public int lenbuf = 0, ptrbuf = 0;

		int readByte() {
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

		boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b))
				;
			return b;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		char nextChar() {
			return (char) skip();
		}

		String next() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		String nextLine() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while ((!isSpaceChar(b) || b == ' ')) { // when nextLine, (isSpaceChar(b) && b != ' ')
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		char[] next(int n) {
			char[] buf = new char[n];
			int b = skip(), p = 0;
			while (p < n && !(isSpaceChar(b))) {
				buf[p++] = (char) b;
				b = readByte();
			}
			return n == p ? buf : Arrays.copyOf(buf, p);
		}

		int nextInt() {
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

		long nextLong() {
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

		char[][] nextMatrix(int n, int m) {
			char[][] map = new char[n][];
			for (int i = 0; i < n; i++)
				map[i] = next(m);
			return map;
		}

		int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long[] nextLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		int[][] next2DInt(int n, int m) {
			int[][] arr = new int[n][];
			for (int i = 0; i < n; i++) {
				arr[i] = nextIntArray(m);
			}
			return arr;
		}

		long[][] next2DLong(int n, int m) {
			long[][] arr = new long[n][];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLongArray(m);
			}
			return arr;
		}

		int[] shuffle(int[] arr) {
			Random r = new Random();
			for (int i = 1, j; i < arr.length; i++) {
				j = r.nextInt(i);
				int c = arr[i];
				arr[i] = arr[j];
				arr[j] = c;
			}
			return arr;
		}

		long[] shuffle(long[] arr) {
			Random r = new Random();
			for (int i = 1, j; i < arr.length; i++) {
				j = r.nextInt(i);
				long c = arr[i];
				arr[i] = arr[j];
				arr[j] = c;
			}
			return arr;
		}

		int[] uniq(int[] arr) {
			arr = scn.shuffle(arr);
			Arrays.sort(arr);
			int[] rv = new int[arr.length];
			int pos = 0;
			rv[pos++] = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != arr[i - 1]) {
					rv[pos++] = arr[i];
				}
			}
			return Arrays.copyOf(rv, pos);
		}

		long[] uniq(long[] arr) {
			arr = scn.shuffle(arr);
			Arrays.sort(arr);
			long[] rv = new long[arr.length];
			int pos = 0;
			rv[pos++] = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != arr[i - 1]) {
					rv[pos++] = arr[i];
				}
			}
			return Arrays.copyOf(rv, pos);
		}

		int[] reverse(int[] arr) {
			int l = 0, r = arr.length - 1;
			while (l < r) {
				arr[l] = arr[l] ^ arr[r];
				arr[r] = arr[l] ^ arr[r];
				arr[l] = arr[l] ^ arr[r];
				l++;
				r--;
			}
			return arr;
		}

		long[] reverse(long[] arr) {
			int l = 0, r = arr.length - 1;
			while (l < r) {
				arr[l] = arr[l] ^ arr[r];
				arr[r] = arr[l] ^ arr[r];
				arr[l] = arr[l] ^ arr[r];
				l++;
				r--;
			}
			return arr;
		}

		int[] compress(int[] arr) {
			int n = arr.length;
			int[] rv = Arrays.copyOf(arr, n);
			rv = uniq(rv);
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.binarySearch(rv, arr[i]);
			}
			return arr;
		}

		long[] compress(long[] arr) {
			int n = arr.length;
			long[] rv = Arrays.copyOf(arr, n);
			rv = uniq(rv);
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.binarySearch(rv, arr[i]);
			}
			return arr;
		}

		void deepFillInt(Object array, int val) {
			if (!array.getClass().isArray()) {
				throw new IllegalArgumentException();
			}
			if (array instanceof int[]) {
				int[] intArray = (int[]) array;
				Arrays.fill(intArray, val);
			} else {
				Object[] objArray = (Object[]) array;
				for (Object obj : objArray) {
					deepFillInt(obj, val);
				}
			}
		}

		void deepFillLong(Object array, long val) {
			if (!array.getClass().isArray()) {
				throw new IllegalArgumentException();
			}
			if (array instanceof long[]) {
				long[] intArray = (long[]) array;
				Arrays.fill(intArray, val);
			} else {
				Object[] objArray = (Object[]) array;
				for (Object obj : objArray) {
					deepFillLong(obj, val);
				}
			}
		}
	}
}