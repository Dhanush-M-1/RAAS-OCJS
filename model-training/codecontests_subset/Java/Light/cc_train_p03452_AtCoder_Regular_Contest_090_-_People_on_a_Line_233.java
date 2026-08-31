
import java.util.Arrays;


public class Main {

	static long inf = Long.MAX_VALUE;
	private static void solve() {
		int n = ni();
		int m = ni();
		
		int[] from = new int[m * 2];
		int[] to = new int[m * 2];
		int[] w = new int[m * 2];
		int ptr = 0;
		for (int i = 0; i < m; i ++) {
			int u = ni() - 1;
			int v = ni() - 1;
			int d = ni();
			
			from[ptr] = u;
			to[ptr] = v;
			w[ptr] = d;
			ptr ++;
			from[ptr] = v;
			to[ptr] = u;
			w[ptr] = -d;
			ptr ++;
		}
		
		int[][][] g = packWD(n, from, to, w);
		long[] dist = new long[n];
		Arrays.fill(dist, inf);
		
		for (int i = 0; i < n; i ++) {
			if (dist[i] == inf) {
				boolean ret = dfs(i, 0, dist, g);
				if (!ret) {
					System.out.println("No");
					return;
				}
			}
		}
		System.out.println("Yes");
	}
	
	static boolean dfs(int now, long d, long[] dist, int[][][] g) {
		dist[now] = d;

		for (int[] v : g[now]) {
			int next = v[0];
			long len = v[1];
			
			if (dist[next] == inf) {
				boolean ret = dfs(next, d + len, dist, g);
				if (!ret) {
					return false;
				}
			}
			if (dist[next] != d + len) {
				return false;
			}
		}
		return true;
	}

	public static int[][][] packWD(int n, int[] from, int[] to, int[] w){ return packWD(n, from, to, w, from.length); }
	public static int[][][] packWD(int n, int[] from, int[] to, int[] w, int sup)
	{
		int[][][] g = new int[n][][];
		int[] p = new int[n];
		for(int i = 0;i < sup;i++)p[from[i]]++;
		for(int i = 0;i < n;i++)g[i] = new int[p[i]][2];
		for(int i = 0;i < sup;i++){
			--p[from[i]];
			g[from[i]][p[from[i]]][0] = to[i];
			g[from[i]][p[from[i]]][1] = w[i];
		}
		return g;
	}

	public static void main(String[] args) {
		new Thread(null, new Runnable() {
			@Override
			public void run() {
				long start = System.currentTimeMillis();
				String debug = args.length > 0 ? args[0] : null;
				if (debug != null) {
					try {
						is = java.nio.file.Files.newInputStream(java.nio.file.Paths.get(debug));
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
				reader = new java.io.BufferedReader(new java.io.InputStreamReader(is), 32768);
				solve();
				out.flush();
				tr((System.currentTimeMillis() - start) + "ms");
			}
		}, "", 64000000).start();
	}

	private static java.io.InputStream is = System.in;
	private static java.io.PrintWriter out = new java.io.PrintWriter(System.out);
	private static java.util.StringTokenizer tokenizer = null;
	private static java.io.BufferedReader reader;

	public static String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new java.util.StringTokenizer(reader.readLine());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	private static double nd() {
		return Double.parseDouble(next());
	}

	private static long nl() {
		return Long.parseLong(next());
	}

	private static int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	private static char[] ns() {
		return next().toCharArray();
	}

	private static long[] nal(int n) {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nl();
		return a;
	}

	private static int[][] ntable(int n, int m) {
		int[][] table = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				table[i][j] = ni();
			}
		}
		return table;
	}

	private static int[][] nlist(int n, int m) {
		int[][] table = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				table[j][i] = ni();
			}
		}
		return table;
	}

	private static int ni() {
		return Integer.parseInt(next());
	}

	private static void tr(Object... o) {
		if (is != System.in)
			System.out.println(java.util.Arrays.deepToString(o));
	}
}
