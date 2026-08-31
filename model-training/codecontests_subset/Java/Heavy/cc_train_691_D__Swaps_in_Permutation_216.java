import java.io.*;
import java.util.*;

public class Main {
	FastReader scn;
	PrintWriter out;
	String INPUT = "";

	void solve() {
		int n = scn.nextInt(), m = scn.nextInt();
		int[] arr = scn.nextIntArray(n);
		int[] to = new int[m], from = new int[m];
		for (int i = 0; i < m; i++) {
			from[i] = scn.nextInt() - 1;
			to[i] = scn.nextInt() - 1;
		}
		int[][] g = packU(n, from, to);
		int[] clust = decomposeToSCCNoRec(g, g);
		
		PriorityQueue<Integer>[] pq = new PriorityQueue[n];
		for(int i = 0; i < n; i++) {
			if(pq[clust[i]] == null) {
				pq[clust[i]] = new PriorityQueue<>(Collections.reverseOrder());
			}
			pq[clust[i]].add(arr[i]);
		}
		for(int i = 0; i < n; i++) {
			arr[i] = pq[clust[i]].poll();
			out.print(arr[i] + " ");
		}
	}
	
	int[] decomposeToSCCNoRec(int[][] g, int[][] ig) {
		int n = g.length;
		boolean[] visited = new boolean[n];
		int[] po = new int[n];
		int pop = 0;

		int[] stack = new int[n];
		int[] sinds = new int[n];
		int sp = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				sinds[sp] = 0;
				stack[sp++] = i;
				while (sp > 0) {
					int cur = stack[sp - 1];
					visited[cur] = true;
					while (sinds[sp - 1] < g[cur].length && visited[g[cur][sinds[sp - 1]]])
						sinds[sp - 1]++;
					if (sinds[sp - 1] == g[cur].length) {
						po[pop++] = cur;
						sp--;
					} else {
						stack[sp] = g[cur][sinds[sp - 1]];
						sinds[sp] = 0;
						sp++;
					}
				}
			}
		}

		int[] ret = new int[n];
		Arrays.fill(visited, false);
		int clus = 0;
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = n - 1; i >= 0; i--) {
			if (!visited[po[i]]) {
				q.add(po[i]);
				visited[po[i]] = true;
				while (!q.isEmpty()) {
					int cur = q.poll();
					ret[cur] = clus;
					for (int k : ig[cur]) {
						if (!visited[k]) {
							q.add(k);
							visited[k] = true;
						}
					}
				}
				clus++;
			}
		}

		return ret;
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

	void run() throws Exception {
		long time = System.currentTimeMillis();
		boolean oj = System.getProperty("ONLINE_JUDGE") != null;
		out = new PrintWriter(System.out);
		scn = new FastReader(oj);
		solve();
		out.flush();
		if (!oj) {
			System.out.println(Arrays.deepToString(new Object[] { System.currentTimeMillis() - time + " ms" }));
		}
	}

	public static void main(String[] args) throws Exception {
		new Main().run();
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
				arr[i] = arr[i] ^ arr[j];
				arr[j] = arr[i] ^ arr[j];
				arr[i] = arr[i] ^ arr[j];
			}
			return arr;
		}
	}
}