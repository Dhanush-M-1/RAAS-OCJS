import java.util.*;

import java.io.*;
import java.math.BigInteger;

public class Main {
	FastScanner in;
	PrintWriter out;
	boolean systemIO = true;

	public class Fraction implements Comparable<Fraction> {
		long x;
		long y;

		public Fraction(long x, long y) {
			this.x = x;
			this.y = y;
		}

		public void norm() {
			long gcd = gcd(x, y);
			x /= gcd;
			y /= gcd;
		}

		@Override
		public int compareTo(Fraction o) {
			if (x > o.x) {
				return 1;
			}
			if (x < o.x) {
				return -1;
			}
			if (y > o.y) {
				return 1;
			}
			if (y < o.y) {
				return -1;
			}
			return 0;
		}
	}

	public Fraction sum(Fraction a, Fraction b) {
		Fraction c = new Fraction(a.x * b.y + a.y * b.x, a.y * b.y);
		c.norm();
		return c;
	}

	public long gcd(long x, long y) {
		if (y == 0) {
			return x;
		}
		if (x == 0) {
			return y;
		}
		return gcd(y, x % y);
	}
	
//	public class Pair implements Comparable<Pair> {
//		long x;
//		long y;
//
//		public Pair(long x, long y) {
//			this.x = x;
//			this.y = y;
//		}
//		
//		public void add(Pair p) {
//			x += p.x;
//			y += p.y;
//		}
//
//		@Override
//		public int compareTo(Pair o) {
////			if (x != o.x) {
////				return x - o.x;
////			}
////			return y - o.y;
//			return 0;
//		}
//	}
	
	public class DSU {
		int groups;
		int[] sz;
		int[] p;
		
		public DSU(int n) {
			sz = new int[n];
			p = new int[n];
			groups = n;
			for (int i = 0; i < p.length; i++) {
				p[i] = i;
				sz[i] = 1;
			}
		}
		
		public int get(int x) {
			if (x == p[x]) {
				return x;
			}
			int par = get(p[x]);
			p[x] = par;
			return par;
		}
		
		public boolean unite(int a, int b) {
			int pa = get(a);
			int pb = get(b);
			if (pa == pb) {
				return false;
			}
			if (sz[pa] < sz[pb]) {
				p[pa] = pb;
				sz[pb] += sz[pa];
			} else {
				p[pb] = pa;
				sz[pa] += sz[pb];
			}
			groups--;
			return true;
		}
	}

	public class Edge implements Comparable<Edge> {
		long w;
		int grl;
		int grr;
		
		public Edge(long w, int grl, int grr) {
			this.w = w;
			this.grl = grl;
			this.grr = grr;
		}

		@Override
		public int compareTo(Edge o) {
			if (w > o.w) {
				return 1;
			}
			if (w < o.w) {
				return -1;
			}
			if (grl != o.grl) {
				return grl - o.grl;
			}
			return grr - o.grr;
		}
	}
	
	public class Pair {
		long x;
		int gr;

		public Pair(long x, int gr) {
			this.x = x;
			this.gr = gr;
		}
		
		public Pair clone() {
			return new Pair(x, gr);
		}
	}
	
	public void solve() {
		int n = in.nextInt();
		long d = in.nextLong();
		DSU dsu = new DSU(n);
		long ans = 0;
		long[] minus = new long[n];
		long[] plus = new long[n];
		for (int i = 0; i < minus.length; i++) {
			long x = in.nextLong();
			plus[i] = x + i * d;
			minus[i] = x - i * d;
		}
		while (dsu.groups > 1) {
			long[] minlx = new long[n];
			long[] minl2x = new long[n];
			long[] minrx = new long[n];
			long[] minr2x = new long[n];
			int[] minlgr = new int[n];
			int[] minl2gr = new int[n];
			int[] minrgr = new int[n];
			int[] minr2gr = new int[n];
			minlx[0] = Long.MAX_VALUE / 2;
			minl2x[0] = Long.MAX_VALUE / 2;
			minrx[n - 1] = Long.MAX_VALUE / 2;
			minr2x[n - 1] = Long.MAX_VALUE / 2;
			minlgr[0] = -1;
			minl2gr[0] = -1;
			minrgr[n - 1] = -1;
			minr2gr[n - 1] = -1;
			for (int i = 0; i < n - 1; i++) {
				minlx[i + 1] = minlx[i];
				minlgr[i + 1] = minlgr[i];
				minl2x[i + 1] = minl2x[i];
				minl2gr[i + 1] = minl2gr[i];
				int gr = dsu.get(i);
				if (minus[i] < minlx[i + 1] || (minus[i] == minlx[i + 1] && gr < minlgr[i + 1])) {
					if (gr != minlgr[i + 1]) {
						minl2x[i + 1] = minlx[i + 1];
						minl2gr[i + 1] = minlgr[i + 1];
					}
					minlx[i + 1] = minus[i];
					minlgr[i + 1] = gr; 
				} else if (gr != minlgr[i + 1] && (minus[i] < minl2x[i + 1] || (minus[i] == minl2x[i + 1] && gr < minl2gr[i + 1]))) {
					minl2x[i + 1] = minus[i];
					minl2gr[i + 1] = gr;
				}
			}
			for (int i = n - 1; i > 0; i--) {
				minrx[i - 1] = minrx[i];
				minrgr[i - 1] = minrgr[i];
				minr2x[i - 1] = minr2x[i];
				minr2gr[i - 1] = minr2gr[i];
				int gr = dsu.get(i);
				if (plus[i] < minrx[i - 1] || (plus[i] == minrx[i - 1] && gr < minrgr[i - 1])) {
					if (gr != minrgr[i - 1]) {
						minr2x[i - 1] = minrx[i - 1];
						minr2gr[i - 1] = minrgr[i - 1];
					}
					minrx[i - 1] = plus[i];
					minrgr[i - 1] = gr; 
				} else if (gr != minrgr[i - 1] && (plus[i] < minr2x[i - 1] || (plus[i] == minr2x[i - 1] && gr < minr2gr[i - 1]))) {
					minr2x[i - 1] = plus[i];
					minr2gr[i - 1] = gr;
				}
			}
			HashMap<Integer, Edge> map = new HashMap<>();
			for (int i = 0; i < minus.length; i++) {
				int grl = dsu.get(i);
				int grr = -1;
				long x = minus[i];
				if (minrgr[i] != grl) {
					if (minrx[i] < Long.MAX_VALUE / 2) {
						x += minrx[i];
						grr = minrgr[i];
					} else {
						continue;
					}
				} else {
					if (minr2x[i] < Long.MAX_VALUE / 2) {
						x += minr2x[i];
						grr = minr2gr[i];
					} else {
						continue;
					}
				}
				Edge e = new Edge(x, grl, grr);
				if (!map.containsKey(grl)) {
					map.put(grl, e);
				} else {
					if (map.get(grl).compareTo(e) > 0) {
						map.put(grl, e);
					}
				}
			}
			for (int i = 0; i < minus.length; i++) {
				int grr = dsu.get(i);
				int grl = -1;
				long x = plus[i];
				if (minlgr[i] != grr) {
					if (minlx[i] < Long.MAX_VALUE / 2) {
						x += minlx[i];
						grl = minlgr[i];
					} else {
						continue;
					}
				} else {
					if (minl2x[i] < Long.MAX_VALUE / 2) {
						x += minl2x[i];
						grl = minl2gr[i];
					} else {
						continue;
					}
				}
				Edge e = new Edge(x, grl, grr);
				if (!map.containsKey(grr)) {
					map.put(grr, e);
				} else {
					if (map.get(grr).compareTo(e) > 0) {
						map.put(grr, e);
					}
				}
			}
			for (int i : map.keySet()) {
				Edge e = map.get(i);
				if (dsu.unite(e.grl, e.grr)) {
					ans += e.w;
				}
			}
		}
		out.println(ans);
	}

	public void run() {
		try {
			if (systemIO) {
				in = new FastScanner(System.in);
				out = new PrintWriter(System.out);
			} else {
				in = new FastScanner(new File("input.txt"));
				out = new PrintWriter(new File("output.txt"));
			}
			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		FastScanner(InputStream f) {
			br = new BufferedReader(new InputStreamReader(f));
		}

		String nextLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
				return null;
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

	}

	// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	public static void main(String[] arg) {
		new Main().run();
	}
}