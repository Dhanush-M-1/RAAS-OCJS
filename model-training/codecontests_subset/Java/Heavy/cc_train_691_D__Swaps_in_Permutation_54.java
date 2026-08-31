// package CF;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class C {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), m = sc.nextInt();
		Point [] p = new Point[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = new Point(sc.nextInt(), i);
		}
		Arrays.sort(p, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.x - o2.x;
			}
		});
		UnionFind uf = new UnionFind(n);
		while(m-->0){
			int u = sc.nextInt(), v = sc.nextInt();
			u--; v--;
			uf.unionSet(u, v);
		}
		int [][] a = new int[uf.numSets][];
		int [] idx = new int[n];
		int [] pnt = new int[uf.numSets];
		for (int i = 0, k = 0; i < n; ++i) {
			if(uf.findSet(i) == i){
				idx[i] = k;
				a[k++] = new int[uf.sizeOfSet(i)];
			}
		}
		for (int i = 0; i < n; ++i) {
			int pr = uf.findSet(i);
			a[idx[pr]][pnt[idx[pr]]++] = i;
		}
		int [] ans = new int[n];
		for (Point po:p) {
			int pr = uf.findSet(po.y);
			ans[a[idx[pr]][--pnt[idx[pr]]]] = po.x;
		}
		for(int i:ans)
			out.print(i + " ");
		out.flush();
		out.close();
	}
	static class UnionFind {                                              
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