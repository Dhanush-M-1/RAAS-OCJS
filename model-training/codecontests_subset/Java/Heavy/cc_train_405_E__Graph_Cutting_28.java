

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class GraphCutting {

	static PrintWriter pw;
	static ArrayList<Integer>[] graph;
	static boolean[] vis, blocked;

	static int dfs(int u) {
		vis[u] = true;
		blocked[u] = true;

		LinkedList<Integer> extra = new LinkedList<>();

		for (int v : graph[u]) {
			if (!blocked[v]) {
				int x = -1;
				if (!vis[v])
					x = dfs(v);
				if (x == -1)
					extra.add(v);
				else
					pw.printf("%d %d %d\n", u, v, x);
			}
		}
		while (extra.size() >= 2)
			pw.printf("%d %d %d\n", extra.poll(), u, extra.poll());
		blocked[u] = false;
		return extra.size() == 1 ? extra.poll() : -1;
	}

	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner(System.in);
		pw = new PrintWriter(System.out);
		int V = sc.nextInt(), E = sc.nextInt();
		if ((E & 1) != 0) {
			pw.println("No solution");
		} else {
			graph = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++)
				graph[i] = new ArrayList<>();
			for (int i = 0; i < E; i++) {
				int u = sc.nextInt(), v = sc.nextInt();
				graph[u].add(v);
				graph[v].add(u);
			}
			vis = new boolean[V + 1];
			blocked = new boolean[V + 1];
			for (int i = 1; i <= V; i++)
				if (!vis[i])
					dfs(i);
		}
		pw.close();
	}

	static class MyScanner {
		StringTokenizer st;
		BufferedReader br;

		public MyScanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
