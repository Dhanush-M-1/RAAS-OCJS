import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class B extends PrintWriter {

	void dfs(int p, int u, int n, int[] size, int[] cnt, List<Integer>[] g) {

		size[u] = 1;

		for (int v : g[u]) {
			if (v == p) {
				continue;
			}

			dfs(u, v, n, size, cnt, g);
			// println(u + " -> " + v + " " + size[v]);

			size[u] += size[v];

			if (size[v] % 2 == 0) {
				// println(u + " " + v);
				++cnt[u];
			}
		}

		if (p != -1 && (n - size[u]) % 2 == 0) {
			// println(u + " root");
			++cnt[u];
		}
	}

	int[] queue;
	int len;
	boolean[] inq;
	int head, tail;

	void init(int len) {
		this.len = len;
		head = tail = 0;
		queue = new int[len];
		inq = new boolean[len];
	}

	void add(int id) {
		if (inq[id]) {
			return;
		}

		inq[id] = true;
		queue[tail] = id;
		tail = (tail + 1) % len;
	}

	int get() {
		int id = queue[head];
		head = (head + 1) % len;
		inq[id] = false;
		return id;
	}

	boolean notEmpty() {
		return head != tail;
	}

	void run() {
		int n = nextInt();

		List<Integer>[] g = new List[n];

		for (int i = 0; i < n; i++) {
			g[i] = new ArrayList<>();
		}

		for (int u = 0; u < n; u++) {
			int v = nextInt() - 1;
			if (v >= 0) {
				g[u].add(v);
				g[v].add(u);
			}
		}

		int p = 0;
		int[] order = new int[n];

		int[] cnt = new int[n];

		int[] deg = new int[n];
		for (int i = 0; i < n; i++) {
			deg[i] = g[i].size();
		}

		dfs(-1, 0, n, new int[n], cnt, g);

		init(n + 3);

		for (int u = 0; u < n; u++) {
			if (deg[u] % 2 == 0 && cnt[u] == 0) {
				add(u);
			}
		}
		// println(Arrays.toString(cnt));

		boolean[] color = new boolean[n];
		Arrays.fill(color, true);

		while (notEmpty()) {

			int u = get();

			if (deg[u] % 2 == 1) {
				continue;
			}
			color[u] = false;
			order[p++] = u;

			for (int v : g[u]) {

				if (color[v]) {
					deg[v] -= 1;
					cnt[v] -= 1;
					if (deg[v] % 2 == 0 && cnt[v] <= 0) {
						add(v);
					}
				}
			}

		}

		if (p == n) {
			println("YES");
			for (int i = 0; i < n; i++) {
				println(order[i] + 1);
			}
		} else {
			println("NO");
		}

	}

	boolean skip() {
		while (hasNext()) {
			next();
		}
		return true;
	}

	int[][] nextMatrix(int n, int m) {
		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				matrix[i][j] = nextInt();
		return matrix;
	}

	String next() {
		while (!tokenizer.hasMoreTokens())
			tokenizer = new StringTokenizer(nextLine());
		return tokenizer.nextToken();
	}

	boolean hasNext() {
		while (!tokenizer.hasMoreTokens()) {
			String line = nextLine();
			if (line == null) {
				return false;
			}
			tokenizer = new StringTokenizer(line);
		}
		return true;
	}

	int[] nextArray(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = nextInt();
		}
		return array;
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

	String nextLine() {
		try {
			return reader.readLine();
		} catch (IOException err) {
			return null;
		}
	}

	public B(OutputStream outputStream) {
		super(outputStream);
	}

	static BufferedReader reader;
	static StringTokenizer tokenizer = new StringTokenizer("");
	static Random rnd = new Random();
	static boolean OJ;

	public static void main(String[] args) throws IOException {
		OJ = System.getProperty("ONLINE_JUDGE") != null;
		B solution = new B(System.out);
		if (OJ) {
			reader = new BufferedReader(new InputStreamReader(System.in));
			solution.run();
		} else {
			reader = new BufferedReader(new FileReader(new File(B.class.getName() + ".txt")));
			long timeout = System.currentTimeMillis();
			while (solution.hasNext()) {
				solution.run();
				solution.println();
				solution.println("----------------------------------");
			}
			solution.println("time: " + (System.currentTimeMillis() - timeout));
		}
		solution.close();
		reader.close();
	}
}