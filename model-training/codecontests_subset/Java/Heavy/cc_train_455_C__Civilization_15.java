import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Template implements Runnable {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	void init() throws FileNotFoundException {
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
		} catch (Exception e) {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		}
	}

	class GraphBuilder {
		int n, m;
		int[] x, y;
		int index;
		int[] size;

		GraphBuilder(int n, int m) {
			this.n = n;
			this.m = m;
			x = new int[m];
			y = new int[m];
			size = new int[n];
		}

		void add(int u, int v) {
			x[index] = u;
			y[index] = v;
			size[u]++;
			size[v]++;
			index++;
		}

		void addDir(int u, int v) {
			x[index] = u;
			y[index] = v;
			size[u]++;
			index++;
		}

		int[][] buildDir() {
			int[][] graph = new int[n][];
			for (int i = 0; i < n; i++) {
				graph[i] = new int[size[i]];
			}
			for (int i = m - 1; i >= 0; i--) {
				graph[x[i]][--size[x[i]]] = y[i];
			}
			return graph;
		}

		int[][] build() {
			int[][] graph = new int[n][];
			for (int i = 0; i < n; i++) {
				graph[i] = new int[size[i]];
			}
			for (int i = m - 1; i >= 0; i--) {
				graph[x[i]][--size[x[i]]] = y[i];
				graph[y[i]][--size[y[i]]] = x[i];
			}
			return graph;
		}
	}

	String readString() throws IOException {
		while (!tok.hasMoreTokens()) {
			try {
				tok = new StringTokenizer(in.readLine());
			} catch (Exception e) {
				return null;
			}
		}
		return tok.nextToken();
	}

	int readInt() throws IOException {
		return Integer.parseInt(readString());
	}

	int[] readIntArray(int size) throws IOException {
		int[] res = new int[size];
		for (int i = 0; i < size; i++) {
			res[i] = readInt();
		}
		return res;
	}

	long readLong() throws IOException {
		return Long.parseLong(readString());
	}

	double readDouble() throws IOException {
		return Double.parseDouble(readString());
	}

	<T> List<T>[] createGraphList(int size) {
		List<T>[] list = new List[size];
		for (int i = 0; i < size; i++) {
			list[i] = new ArrayList<>();
		}
		return list;
	}

	public static void main(String[] args) {
		new Template().run();
		// new Thread(null, new Template(), "", 1l * 200 * 1024 * 1024).start();
	}

	long timeBegin, timeEnd;

	void time() {
		timeEnd = System.currentTimeMillis();
		System.err.println("Time = " + (timeEnd - timeBegin));
	}

	long memoryTotal, memoryFree;

	void memory() {
		memoryFree = Runtime.getRuntime().freeMemory();
		System.err.println("Memory = " + ((memoryTotal - memoryFree) >> 10) + " KB");
	}

	public void run() {
		try {
			timeBegin = System.currentTimeMillis();
			memoryTotal = Runtime.getRuntime().freeMemory();
			init();
			solve();
			out.close();
			if (System.getProperty("ONLINE_JUDGE") == null) {
				time();
				memory();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	int[] p;
	int[] diam;
	
	int find(int x) {
		if (x == p[x]) return x;
		return p[x] = find(p[x]);
	}
	
	void merge(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) return;
		
		p[x] = y;
		diam[y] = mergeDiams(diam[x], diam[y]);
	}
	
	int mergeDiams(int x, int y) {
		int res = (x + 1) / 2 + (y + 1) / 2 + 1;
		res = Math.max(res, x);
		res = Math.max(res, y);
		return res;
	}

	void solve() throws IOException {
		int n = readInt();
		int m = readInt();
		int k = readInt();
		p = new int[n];
		for (int i=0;i<n;i++) {
			p[i] = i;
		}
		diam = new int[n];
		GraphBuilder gb = new GraphBuilder(n, m);
		for (int i = 0; i < m; i++) {
			int x = readInt() - 1;
			int y = readInt() - 1;
			merge(x, y);
			gb.add(x, y);
		}
		int[][] g = gb.build();
		int[] h = new int[n];
		Arrays.fill(h, -1);
		for (int i=0;i<n;i++) {
			if (find(i) == i) {
				int best = dfs(i,i,0,g,h);
				best = dfs(best,best,0,g,h);
				diam[i] = h[best];
			}
		}
		for (int i=0;i<k;i++) {
			int type = readInt();
			if (type == 1) {
				out.println(diam[find(readInt() - 1)]);
			} else {
				int x = readInt() - 1;
				int y = readInt() - 1;
				merge(x, y);
			}
		}
		
	}

	int dfs(int x, int p, int he, int[][] g, int[] h) {
		h[x] = he;
		int best = x;
		for (int y : g[x]) {
			if (y == p)
				continue;
			int rb = dfs(y, x, he + 1, g, h);
			if (h[rb] > h[best]) {
				best = rb;
			}
		}
		return best;
	}

}