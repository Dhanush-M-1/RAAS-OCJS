import java.io.*;
import java.util.*;

public class C implements Runnable{
	public static void main (String[] args) {new Thread(null, new C(), "_cf", 1 << 28).start();}

	int[] dist, look, flag;
	
	public void run() {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		System.err.println("Go!");

		int n = fs.nextInt(), m = fs.nextInt();
		int q = fs.nextInt();
		dist = new int[n]; look = new int[n]; Arrays.fill(dist, 100100100);
		flag = new int[n]; Arrays.fill(flag, -1);
		int[] deg = new int[n];
		int[][] edges = new int[m][2];
		for(int i = 0; i < m; i++) {
			int u = fs.nextInt() - 1;
			int v = fs.nextInt() - 1;
			edges[i][0] = u;
			edges[i][1] = v;
			deg[u]++; deg[v]++;
		}
		int[][] adj = new int[n][];
		for(int i = 0; i < n; i++) adj[i] = new int[deg[i]];
		for(int i = 0; i < m; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			adj[u][--deg[u]] = v;
			adj[v][--deg[v]] = u;
		}
		
		DSU ds = new DSU(n);
		boolean[] vis = new boolean[n];
		for(int i = 0; i < n; i++) {
			if(vis[i]) continue;
			getDiam(i, vis, adj, ds);
		}
		while(q-->0) {
			int tp = fs.nextInt();
			if(tp == 1) {
				int u = fs.nextInt() - 1;
				out.println(ds.diam[ds.find(u)]);
			}
			else {
				int u = fs.nextInt() - 1;
				int v = fs.nextInt() - 1;
				ds.union(u, v);
			}
		}
		
		out.close();
	}

	void getDiam(int start, boolean[] vis, int[][] adj, DSU dsu) {
		int n = vis.length, ptr = 0;
		dist[start] = 0;
		ArrayDeque<Integer> bfs = new ArrayDeque<>();
		bfs.add(start);
		int leaf = -1, max = -1;
		while(!bfs.isEmpty()) {
			int u = bfs.pollFirst();
			flag[u] = 1;
			vis[u] = true;
			if(dist[u] > max) {
				max = dist[u];
				leaf = u;
			}
			for(int v : adj[u]) {
				if(1+dist[u] < dist[v]) {
					dsu.union(u, v);
					dist[v] = 1+dist[u];
					bfs.add(v);
				}
			}
		}
		dist[leaf] = 0;
		bfs.clear(); bfs.add(leaf);
		max = -1;
		while(!bfs.isEmpty()) {
			int u = bfs.pollFirst();
			max = Math.max(max, dist[u]);
			flag[u] = -1;
			for(int v : adj[u]) {
				if(1 + dist[u] < dist[v] || flag[v] > 0) {
					dist[v] = dist[u]+1;
					bfs.add(v);
				}
			}
		}
		dsu.diam[dsu.find(start)] = max;
	}
	
	class DSU {
		int n;
		int[] par, rank;
		int[] diam;
		DSU(int a) {
			n = a;
			par = new int[n];
			rank = new int[n];
			diam = new int[n];
			for(int i = 0; i < n; i++) par[i] = i;
		}
		int find(int u) {
			if(par[u] == u) return u;
			return par[u] = find(par[u]);
		}
		boolean union(int u, int v) {
			int pu = find(u);
			int pv = find(v);
			if(pu == pv) return false;
			if(rank[pu] >= rank[pv]) {
				if(rank[pu] == rank[pv]) rank[pu]++;
				diam[pu] = Math.max(Math.max(diam[pv],diam[pu]), ceil(diam[pu])+ceil(diam[pv])+1 );
				par[pv] = pu;
			}
			else {
				diam[pv] = Math.max(Math.max(diam[pv],diam[pu]), ceil(diam[pu])+ceil(diam[pv])+1 );
				par[pu] = pv;
			}
			return true;
		}
	}
	
	int ceil(int x) {
		return x / 2 + (x % 2);
	}

	class FastScanner {
		public int BS = 1<<16;
		public char NC = (char)0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;

		public FastScanner() {
			in = new BufferedInputStream(System.in, BS);
		}

		public FastScanner(String s) throws FileNotFoundException {
			in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
		}

		public char nextChar(){
			while(bId==size) {
				try {
					size = in.read(buf);
				}catch(Exception e) {
					return NC;
				}                
				if(size==-1)return NC;
				bId=0;
			}
			return (char)buf[bId++];
		}

		public int nextInt() {
			return (int)nextLong();
		}

		public long nextLong() {
			num=1;
			boolean neg = false;
			if(c==NC)c=nextChar();
			for(;(c<'0' || c>'9'); c = nextChar()) {
				if(c=='-')neg=true;
			}
			long res = 0;
			for(; c>='0' && c <='9'; c=nextChar()) {
				res = (res<<3)+(res<<1)+c-'0';
				num*=10;
			}
			return neg?-res:res;
		}

		public double nextDouble() {
			double cur = nextLong();
			return c!='.' ? cur:cur+nextLong()/num;
		}

		public String next() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c>32) {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}

		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c!='\n') {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}

		public boolean hasNext() {
			if(c>32)return true;
			while(true) {
				c=nextChar();
				if(c==NC)return false;
				else if(c>32)return true;
			}
		}

		public int[] nextIntArray(int n) {
			int[] res = new int[n];
			for(int i = 0; i < n; i++) res[i] = nextInt();
			return res;
		}

	}

}
