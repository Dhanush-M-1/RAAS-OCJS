import java.util.*;

import javax.sound.midi.Track;

import java.io.*;

public class tr0 {
	static PrintWriter out;
	static StringBuilder sb;
	static long mod = (long) 1e9 + 7;
	static long inf = (long) 1e16;
	static int n, m, ans;
	static ArrayList<Integer>[] ad1, ad2, ad3;
	static int[][] remove, add;
	static long[][][] memoS, memoN;
	static boolean vis[];
	static long[] f, inv, ncr[];
	static HashMap<Integer, Integer> hm;
	static int[] pre, suf, Smax[], Smin[];
	static int idmax, idmin;
	static ArrayList<Integer> av;
	static HashMap<Integer, Integer> mm;
	static boolean[] msks;
	static int[] lazy[], lazyCount;
	static int[] a, dist;
	static char[][] g;
	static int ave;
	static ArrayList<Integer> gl;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] a = new int[n];
			long[] pre = new long[n];
			long sum = 0;
			long max = 0;
			int N = 1;
			while (N < n)
				N <<= 1;
			long[] in = new long[N + 1];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				sum += a[i];
				pre[i] = a[i];
				if (i > 0)
					pre[i] += pre[i - 1];
				max = Math.max(max, pre[i]);
				in[i + 1] = pre[i];
			}

			SegmentTree st = new SegmentTree(in);
			for (int i = 0; i < m; i++) {
				long x = sc.nextInt();
				if (x <= max) {
					int id = st.query(1, n, x);
					out.print((id - 1) + " ");
				} else {
					if (sum <= 0)
						out.print(-1 + " ");
					else {
						long diff = x - max;
						long times = (diff / sum);
						if (diff % sum != 0)
							times++;
						x -= times * sum;
						long ans = times * n;
						ans--;
						int id = st.query(1, n, x);
						ans += id;
						out.print(ans + " ");
					}
				}
			}
			out.println();
		}
		out.flush();
	}

	public static class SegmentTree { // 1-based DS, OOP

		int N; // the number of elements in the array as a power of 2 (i.e. after padding)
		long[] array, sTree;

		SegmentTree(long[] in) {
			array = in;
			N = in.length - 1;
			sTree = new long[N << 1]; // no. of nodes = 2*N - 1, we add one to cross out index zero
			build(1, 1, N);
		}

		void build(int node, int b, int e) // O(n)
		{
			if (b == e)
				sTree[node] = array[b];
			else {
				int mid = b + e >> 1;
				build(node << 1, b, mid);
				build(node << 1 | 1, mid + 1, e);
				sTree[node] = Math.max(sTree[node << 1], sTree[node << 1 | 1]);
			}
		}

		int query(int i, int j, long val) {
			return query(1, 1, N, i, j, val);
		}

		int query(int node, int b, int e, int i, int j, long val) // O(log n)
		{
			if (e == b)
				return e;
			int mid = b + e >> 1;
			if (sTree[node << 1] >= val)
				return query(node << 1, b, mid, i, j, val);
			else
				return query(node << 1 | 1, mid + 1, e, i, j, val);
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

		public int[] nextArrIntSorted(int n) throws IOException {
			int[] a = new int[n];
			Integer[] a1 = new Integer[n];
			for (int i = 0; i < n; i++)
				a1[i] = nextInt();
			Arrays.sort(a1);
			for (int i = 0; i < n; i++)
				a[i] = a1[1].intValue();
			return a;
		}

		public long[] nextArrLongSorted(int n) throws IOException {
			long[] a = new long[n];
			Long[] a1 = new Long[n];
			for (int i = 0; i < n; i++)
				a1[i] = nextLong();
			Arrays.sort(a1);
			for (int i = 0; i < n; i++)
				a[i] = a1[1].longValue();
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