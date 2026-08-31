import java.util.*;
import java.io.*;

public class F1466 {
	static final int mod = (int) 1e9 + 7;

	public static long modPow(long a, long e) {
		if (e == 0)
			return 1;
		if (e % 2 == 1) {
			return (a * modPow(a, e - 1)) % mod;
		}
		long prev = modPow(a, e / 2);
		return (prev * prev) % mod;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int m = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<int[]> edges = new ArrayList<int[]>();
		int[] good = new int[n];
		UnionFind uf = new UnionFind(n);
		ArrayList<Integer> s = new ArrayList<Integer>();
		int ans = 0;
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			if (x == 2) {
				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
//				edges.add(new int[] { u, v, i + 1 });
				if (uf.isSameSet(u, v))
					continue;
				if (uf.good[uf.findSet(u)] && uf.good[uf.findSet(v)])
					continue;
				uf.unionSet(u, v);
				s.add(i + 1);
				ans++;
			} else {
				int u = sc.nextInt() - 1;
//				good[sc.nextInt() - 1] = i + 1;
				if (uf.good[uf.findSet(u)]) {
					continue;
				}
				uf.good[uf.findSet(u)] = true;
				s.add(i + 1);
				ans++;
			}
		}
//		for (int[] x : edges) {
//			if (!uf.isSameSet(x[0], x[1])) {
//				uf.unionSet(x[0], x[1]);
//				s.add(x[2]);
//			}
//		}
//		boolean[] vis = new boolean[n];
//		for (int i = 0; i < n; i++) {
//			if (good[i] != 0) {
//				int par = uf.findSet(i);
//				if (!vis[par]) {
//					ans += uf.sizeOfSet(par);
//					s.add(good[i]);
//					vis[par] = true;
//				}
//			}
//		}
//		for (int i = 0; i < n; i++) {
//			int par = uf.findSet(i);
//			if (!vis[par]) {
//				ans += uf.sizeOfSet(par) - 1;
//				vis[par] = true;
//			}
//		}
		pw.println(modPow(2, ans) + " " + s.size());
		Collections.sort(s);
		for (int x : s) {
			pw.print(x + " ");
		}
		pw.println();
		pw.close();
	}

	static class UnionFind {
		int[] p, rank, setSize;
		boolean[] good;
		int numSets;

		public UnionFind(int N) {
			p = new int[numSets = N];
			rank = new int[N];
			setSize = new int[N];
			good = new boolean[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
				setSize[i] = 1;
			}
		}

		public int findSet(int i) {
			return p[i] == i ? i : (p[i] = findSet(p[i]));
		}

		public boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		public void unionSet(int i, int j) {
			if (isSameSet(i, j))
				return;
			numSets--;
			int x = findSet(i), y = findSet(j);
			if (rank[x] > rank[y]) {
				p[y] = x;
				setSize[x] += setSize[y];
			} else {
				p[x] = y;
				setSize[y] += setSize[x];
				if (rank[x] == rank[y])
					rank[y]++;
			}
			if (good[x] | good[y]) {
				good[x] = true;
				good[y] = true;
			}
		}

		public int numDisjointSets() {
			return numSets;
		}

		public int sizeOfSet(int i) {
			return setSize[findSet(i)];
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader f) {
			br = new BufferedReader(f);
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

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(next());
			}
			return arr;
		}

	}

}
