import java.util.*;

import java.io.*;
public class E {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int q = sc.nextInt();
		PrintWriter pw = new PrintWriter(System.out);
		for(int _q = 0; _q < q; _q++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			UnionFind uf1 = new UnionFind(n);
			UnionFind uf2 = new UnionFind(n);
			UnionFind uf3 = new UnionFind(n);
			for(int i = 0; i < m; i++) {
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				if(u != a && v != a) {
					uf1.union(u, v);
				}
				if(u != b && v != b) {
					uf2.union(u, v);
				}
				if(u != b && v != b && u != a && v != a) {
					uf3.union(u, v);
				}
			}
			int[] color = new int[n];
			for(int i = 0; i < n; i++) {
				if(uf1.find(i) == uf1.find(b)) color[i] += 1;
				if(uf2.find(i) == uf2.find(a)) color[i] += 2;
			}
			long A = 0, B = 0;
			for(int i = 0; i < n; i++) {
				if(i != b && color[i] == 1) A++;
				if(i != a && color[i] == 2) B++;
			}
			pw.write(A*B+"\n");
		}
		pw.flush();

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
	
	
}
