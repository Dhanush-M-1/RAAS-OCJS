// package CF;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class C {
	static final long INF = (long)1e18;	//don't increase, avoid overflow
	static ArrayList<Integer>[] adj;
	static long [] dist, mat[];
	static int V, L, s, t, p [];
	static ArrayList<Edge> zero;
	static boolean [][] z;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		V = sc.nextInt(); int m = sc.nextInt(); L = sc.nextInt(); s = sc.nextInt(); t = sc.nextInt();
		zero = new ArrayList<>();
		adj = new ArrayList[V];
		mat = new long[V][V];
		z = new boolean[V][V];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
			Arrays.fill(mat[i], INF);
		}
		while(m-->0){
			int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
			if(w == 0){
				zero.add(new Edge(u, v));
				z[u][v] = true;
				z[v][u] = true;
			}
			adj[u].add(v);
			mat[u][v] = w;
			adj[v].add(u);
			mat[v][u] = w;
		}
		p = new int[V];
		dist = new long[V];
		long lo = 1, hi = INF, ans = INF;
		while(lo <= hi){
			long mid = (lo + hi)/2;
			for(Edge z:zero){
				mat[z.node][(int) z.cost] = mid;
				mat[(int) z.cost][z.node] = mid;
			}
			long tmp = dijkstra(mid);
			if(tmp >= L){
				if(tmp == L){
					ans = mid;
					break;
				}
				hi = mid-1;
			}
			else lo = mid+1;
		}
		if(ans == INF) out.println("NO");
		else{
			out.println("YES");
			for (int i = 0; i < V; i++) {
				for (int j = i+1; j < V; j++) {
					if(mat[i][j] == INF) continue;
					out.println(i + " " + j + " " + mat[i][j]);
				}
			}
		}
		out.flush();
		out.close();
	}
	static long dijkstra(long l)	//O(E log E)
	{
		Arrays.fill(p, -1);
		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		dist[s] = 0;
		pq.add(new Edge(s, 0));						//may add more in case of MSSP (Mult-Source)
		while(!pq.isEmpty())
		{
			Edge cur = pq.remove();
			if(cur.cost > dist[cur.node])			//lazy deletion
				continue;
			for(int nxt: adj[cur.node])
				if(cur.cost + mat[cur.node][nxt] < dist[nxt]){
					p[nxt] = cur.node;
					pq.add(new Edge(nxt, dist[nxt] = cur.cost + mat[cur.node][nxt] ));
				}
		}
		if(dist[t] > L && dist[t] - L < l){
			boolean can = false;
			int c = t;
			while(c != s && !can){
				if(z[p[c]][c]){
					mat[p[c]][c] = mat[c][p[c]] -= dist[t]-L;
					can = true;
				}
				c = p[c];
			}
			if(can)
				return L;
		}
		return dist[t];
	}

	static class Edge implements Comparable<Edge>
	{
		int node; long cost;

		Edge(int a, long b) { node = a;	cost = b; }

		public int compareTo(Edge e){ return Long.compare(cost, e.cost);	}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader fileReader) {
			br = new BufferedReader(fileReader);
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