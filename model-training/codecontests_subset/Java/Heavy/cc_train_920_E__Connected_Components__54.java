import java.io.*;
import java.util.*;

import javax.swing.text.html.MinimalHTMLWriter;

public class tr1 {
	static PrintWriter out;
	static StringBuilder sb;
	static int n, m, k, x, y;
	static long mod = 998244353;
	static Boolean[][] memo;
	static String s;
	static HashSet<Integer>[] ad;
	static long inf = Long.MAX_VALUE;
	static int N = 1 << 20 + 1;
	static int[] color;
	static ArrayList<Integer> o, z;
	static char[][] g;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		n = sc.nextInt();
		m = sc.nextInt();
		ad = new HashSet[n];
		for (int i = 0; i < n; i++)
			ad[i] = new HashSet<>();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			ad[a].add(b);
			ad[b].add(a);
		}
		unionfind uf = new unionfind(n);
		TreeSet<Integer> sp = new TreeSet<>();
		for (int i = 0; i < n; i++)
			sp.add(i);
		for (int i = 0; i < n; i++) {
			TreeSet<Integer> del = new TreeSet<>();
			for (int k : sp) {
				if (!uf.add[k].contains(i)) {
					del.add(k);
					uf.combine(i, k);
				}
			}
			sp.removeAll(del);
			sp.add(uf.findSet(i));
		}
		ArrayList<Integer> ar = new ArrayList<>();
		for (int i = 0; i < n; i++)
			if (uf.size[i] > 0)
				ar.add(uf.size[i]);
		Collections.sort(ar);
		out.println(ar.size());
		for (int i = 0; i < ar.size(); i++)
			out.print(ar.get(i) + " ");
		out.flush();
	}

	static class unionfind {
		int[] p;
		int[] size;
		int[] max;
		int num;
		HashSet<Integer>[] add;

		unionfind(int n) {
			p = new int[n];
			size = new int[n];
			max = new int[n];
			add = new HashSet[n];
			for (int i = 0; i < n; i++) {
				p[i] = i;
				max[i] = i;
				add[i] = new HashSet<>();
				add[i] = (HashSet<Integer>) (ad[i].clone());
			}
			Arrays.fill(size, 1);
			num = n;
		}

		int findSet(int v) {
			if (v == p[v])
				return v;

			max[v] = Math.max(max[v], max[p[v]]);

			p[v] = findSet(p[v]);

			max[v] = Math.max(max[v], max[p[v]]);

			return p[v];
		}

		boolean sameSet(int a, int b) {
			a = findSet(a);
			b = findSet(b);
			if (a == b)
				return true;
			return false;
		}

		int max() {
			int max = 0;
			for (int i = 0; i < size.length; i++)
				if (size[i] > max)
					max = size[i];
			return max;
		}

		boolean combine(int a, int b) {
			a = findSet(a);
			b = findSet(b);
			if (a == b)
				return true;
			// System.out.println(num+" ppp");
			num--;
			if (size[a] > size[b]) {
				p[b] = a;
				max[a] = Math.max(max[a], max[b]);
				size[a] += size[b];
				HashSet<Integer> o = new HashSet<>();
				for (int k : add[b])
					if (add[a].contains(k))
						o.add(k);
				add[a] = (HashSet) o.clone();
				size[b] = 0;
			} else {
				p[a] = b;
				max[b] = Math.max(max[a], max[b]);
				size[b] += size[a];
				HashSet<Integer> o = new HashSet<>();
				for (int k : add[a])
					if (add[b].contains(k))
						o.add(k);
				add[b] = (HashSet) o.clone();
				size[a] = 0;
			}
			return false;
		}
	}

	static class pair implements Comparable<pair> {
		int l, r, id;

		pair(int ll, int rr, int i) {
			l = ll;
			r = rr;
			id = i;
		}

		@Override
		public int compareTo(pair o) {
			if (l == o.l)
				return id - o.id;
			return l - o.l;
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public int[] nextArrInt(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public long[] nextArrLong(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}