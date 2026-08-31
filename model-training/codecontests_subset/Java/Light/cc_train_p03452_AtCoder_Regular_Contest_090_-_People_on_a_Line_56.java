import java.util.*;

import java.io.*;

public class Main {
	class Edge {
		int to, cost;

		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

	}

	List<Edge>[] graph;
	boolean[] used;
	long[] pos;
	
	void dfs(int u, long p) {
		used[u] = true;
		pos[u] = p;
		for (int t = 0; t < graph[u].size(); t++) {
			Edge e = graph[u].get(t);
			if (!used[e.to]) {
				dfs(e.to, p + e.cost);
			} else if (pos[e.to] != p + e.cost){
				fail = true;
			}
		}
	}
	boolean fail = false;
	
	void solve() {
		int n = in.nextInt(), m = in.nextInt();
		graph = new List[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i =0; i < m; i++) {
			int from = in.nextInt() - 1, to =in.nextInt() - 1, len = in.nextInt();
			graph[from].add(new Edge(to, len));
			graph[to].add(new Edge(from, -len));
		}
		used = new boolean[n];
		pos = new long[n];
		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				dfs(i, 0);
			}
		}
		out.println(fail ? "No" : "Yes");
	}

	FastScanner in;
	PrintWriter out;

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

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public String nextToken() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(nextToken());
		}

		public long nextLong() {
			return Long.parseLong(nextToken());
		}

		public double nextDouble() {
			return Double.parseDouble(nextToken());
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
