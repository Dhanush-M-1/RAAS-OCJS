import java.io.*;
import java.util.*;

public class Civilization {
	
	/*
7 4 5
1 2
2 3
4 5
5 6
1 4
2 3 6
1 5
2 1 7
1 7
	 */
	
	static int n;
	static int[] par, width, rank;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		Edge[] g = new Edge[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			g[a] = new Edge(b, g[a]);
			g[b] = new Edge(a, g[b]);
		}
		
		init(g);
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(in.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken()) - 1;
			if (op == 1) {
				out.println(width[find(a)]);
			} else {
				int b = Integer.parseInt(st.nextToken()) - 1;
				merge(a, b);
			}
		}
		
		in.close();
		out.close();
	}
	
	static int bestV, bestD;
	static void init(Edge[] g) {
		par = new int[n];
		width = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			par[i] = i;
			width[i] = 0;
			rank[i] = 0;
		}
		boolean[] done = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!done[i]) {
				bestD = 0;
				bestV = i;
				dfs(i, g, -1, 0, done, -1);
				int v2 = bestV;
				bestD = 0;
				dfs(v2, g, -1, 0, done, v2);
				width[v2] = bestD;
//				System.err.println("Width for " + i + ": " + bestD);
			}
		}
	}
	
	static void dfs(int v, Edge[] g, int p, int depth, boolean[] done, int setPar) {
		if (setPar != -1) {
			par[v] = setPar;
		}
		if (depth > bestD) {
			bestD = depth;
			bestV = v;
		}
		done[v] = true;
		for (Edge e = g[v]; e != null; e = e.next) {
			if (e.to != p) {
				dfs(e.to, g, v, depth+1, done, setPar);
			}
		}
	}
	
	static int find(int v) {
		if (par[v] == v) return par[v];
		return par[v] = find(par[v]);
	}
	
	static void merge(int a, int b) {
		int pa = find(a), pb = find(b);
		if (pa != pb) {
			int w1 = (width[pa]+1)/2;
			int w2 = (width[pb]+1)/2;
			int w = Math.max(width[pa], Math.max(width[pb], w1+w2+1));
			if (rank[pa] > rank[pb]) {
				par[pb] = pa;
				width[pa] = w;
			} else if (rank[pb] > rank[pa]) {
				par[pa] = pb;
				width[pb] = w;
			} else {
				par[pb] = pa;
				width[pa] = w;
				rank[pa]++;
			}
		}
	}
	
	static class Edge {
		int to;
		Edge next;
		public Edge(int to, Edge next) {
			this.to = to;
			this.next = next;
		}
	}
}
