import java.util.*;
import java.io.*;
public class F { 

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt(); //no of edges
		int m = sc.nextInt(); //no of vertices
//		Edge[] es = new Edge[n];
		UnionFind uf = new UnionFind(m+1);
		int res = 0;
		for(int i = 0; i < n; i++){
			int k = sc.nextInt();
			if(k == 1) {
				int u = sc.nextInt();
//				es[i] = new Edge(i, 0, u);
				if(uf.find(0) != uf.find(u)) {
					uf.union(0, u);
					sb.append((i+1)+" "); res++;
				}
			}
			else {
				int u = sc.nextInt();
				int v = sc.nextInt();
				if(uf.find(u) != uf.find(v)) {
					uf.union(u, v);
					sb.append((i+1)+" "); res++;
				}
			}
		}
		long num = 1L;
		long mod = 1000000007;
		for(int i = 0; i < res; i++){
			num *= 2; num %= mod;
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(num+" "+res);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static class UnionFind {
		//source: https://www.cs.waikato.ac.nz/~bernhard/317/source/graph/UnionFind.java
		private int[] _parent;
		private int[] _rank;

		public UnionFind(int max) {
			_parent = new int[max];
			_rank = new int[max];
			for (int i = 0; i < max; i++) {
				_parent[i] = i;
			}
		}

		public int find(int i) {
			int p = _parent[i];
			if (i == p) {
				return i;
			}
			return _parent[i] = find(p);
		}

		public void union(int i, int j) {
			int root1 = find(i), root2 = find(j);
			if (root2 == root1) return;
			if (_rank[root1] > _rank[root2]) {
				_parent[root2] = root1;
			} else if (_rank[root2] > _rank[root1]) {
				_parent[root1] = root2;
			} else {
				_parent[root2] = root1;
				_rank[root1]++;
			}
		}
	}
	static class Edge implements Comparable<Edge>{
		int ind, u, v;
		public Edge(int ind, int u, int v){
			this.ind = ind;
			this.u = u; this.v = v;
		}
		public int compareTo(Edge p){
			return Integer.compare(ind, p.ind);
		}
		public String toString(){
			return ind + " " + u + " " + v;
		}
	}
	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
