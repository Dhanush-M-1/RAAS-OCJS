import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A {
	static int node, diam;
	static int [] d;
	static ArrayList<Integer> [] adj;
	static void dfs(int u, int p, int l){
		if(l >= diam){
			diam = l;
			node = u;
		}
		for(int v:adj[u])
			if(v != p)
				dfs(v, u, l+1);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
		adj = new ArrayList[n];
		for (int i = 0; i < adj.length; ++i) {
			adj[i] = new ArrayList<>();
		}
		d = new int[n];
		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < m; ++i) {
			int u = sc.nextInt(), v = sc.nextInt();
			--u; --v;
			adj[u].add(v);
			adj[v].add(u);
			uf.unionSet(u, v);
		}
		for (int i = 0; i < n; ++i) {
			if(i == uf.findSet(i))
				findDiam(i);
		}
		while(q-->0){
			int t = sc.nextInt();
			if(t == 1){
				out.println(d[uf.findSet(sc.nextInt()-1)]);
			}
			else{
				uf.unionSet(sc.nextInt()-1, sc.nextInt()-1);
			}
		}
		out.close();

	}
	static void findDiam(int u){
		node = -1;
		diam = 0;
		dfs(u, -1, 0);
		diam = 0;
		dfs(node, -1, 0);
		d[u] = diam;
	}
	static class UnionFind {                                              
		int[] p, rank, setSize;
		int numSets;

		public UnionFind(int N) 
		{
			p = new int[numSets = N];
			rank = new int[N];
			for (int i = 0; i < N; i++) {  p[i] = i;  }
		}

		public int findSet(int i) { return p[i] == i ? i : (p[i] = findSet(p[i])); }

		public boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

		public void unionSet(int i, int j) 
		{ 
			if (isSameSet(i, j)) 
				return;
			int x = findSet(i), y = findSet(j);
			if(rank[x] > rank[y]) {
				p[y] = x; 
				d[x] = Math.max(d[x], Math.max(d[y], (d[x] + 1)/2 + (d[y] + 1)/2 + 1));
			}
			else
			{	p[x] = y; 
			if(rank[x] == rank[y]) rank[y]++; 
			d[y] = Math.max(d[x], Math.max(d[y], (d[x] + 1)/2 + (d[y] + 1)/2 + 1));
			} 
		}
	}
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

	}

}
