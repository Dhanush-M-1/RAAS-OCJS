import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Abood3A {

	static int V, E, Q;
	static ArrayList<Integer>[] Tree;
	static int[] root, dia;
	static boolean[] Vis;
	static int far, d, r;

	static void dfs(int i, int p, int h) {
		Vis[i] = true;

		if(h >= d){
			far = i;
			d = h;
		}

		for (int j = 0; j < Tree[i].size(); j++) {
			int v = Tree[i].get(j);

			if(v != p)
				dfs(v, i, h + 1);
		}
	}

	static boolean root(int u, int p, int h) {

		if(h == d)
			return true;
		boolean onP = false;

		for (int i = 0; i < Tree[u].size(); i++) {
			int v = Tree[u].get(i);

			if(v != p)
				onP |= root(v, u, h + 1);
		}

		if(onP && h == d / 2)
			r = u;

		return onP;
	}

	static void reset() {
		far = 0;
		d = 0;
		r = 0;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		V = sc.nextInt();
		E = sc.nextInt();
		Q = sc.nextInt();

		Tree = new ArrayList[V];

		for (int i = 0; i < V; i++)
			Tree[i] = new ArrayList<>();

		UnionFind uf = new UnionFind(V);

		for (int i = 0; i < E; i++) {
			int f = sc.nextInt() - 1;
			int t = sc.nextInt() - 1;

			Tree[f].add(t);
			Tree[t].add(f);

			uf.unionSet(f, t);
		}

		Vis = new boolean[V];
		root = new int[V];
		dia = new int[V];

		for (int i = 0; i < V; i++) {
			if(!Vis[i]) {
				reset();
				dfs(i, -1, 0);
				int p = far;
				reset();
				dfs(p, -1, 0);
				root(far, -1, 0);
				if(d == 0)
					r = i;
				root[uf.findSet(i)] = r;
				dia[uf.findSet(i)] = d;

			}
		}

		for (int i = 0; i < Q; i++) {
			int t = sc.nextInt();

			if(t == 1) {
				out.println(dia[uf.findSet(sc.nextInt() - 1)]);
			} else {
				int x = uf.findSet(sc.nextInt() - 1);
				int y = uf.findSet(sc.nextInt() - 1);

				if(x == y)
					continue;
				int nR = dia[x] > dia[y] ? root[x] : root[y];
				int nD = Math.max(Math.max(dia[x], dia[y]),(dia[x] + 1) / 2 + (dia[y] + 1) / 2 + 1);

				uf.unionSet(x, y);
				root[uf.findSet(x)] = nR;
				dia[uf.findSet(x)] = nD;

			}
		}


		out.flush();

	}

	static public class UnionFind {                                              
		int[] p, rank, setSize;
		int numSets;

		public UnionFind(int N) 
		{
			p = new int[numSets = N];
			rank = new int[N];
			setSize = new int[N];
			for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
		}

		public int findSet(int i) { return p[i] == i ? i : (p[i] = findSet(p[i])); }

		public boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

		public void unionSet(int i, int j) 
		{ 
			if (isSameSet(i, j)) 
				return;
			numSets--; 
			int x = findSet(i), y = findSet(j);
			if(rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
			else
			{	p[x] = y; setSize[y] += setSize[x];
			if(rank[x] == rank[y]) rank[y]++; 
			} 
		}

		public int numDisjointSets() { return numSets; }

		public int sizeOfSet(int i) { return setSize[findSet(i)]; }
	}


	static class Scanner 



	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}


		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}

		public boolean ready() throws IOException {return br.ready();}



	}

}