import java.util.*;
import java.io.*;

public class tr0 {
	static PrintWriter out;
	static StringBuilder sb;
	static long mod = (long) 1e9 + 7;
	static long inf = (long) 1e16;
	static int n, m, k;
	static ArrayList<Integer>[] ad;
	static int[][] remove, add;
	static long[][] memo, memo1[];
	static boolean vis[];
	static long[] inv, ncr[];
	static HashMap<Integer, Integer> hm;
	static int[] pre, suf, Smax[], Smin[];
	static int idmax, idmin;
	static ArrayList<Integer> av;
	static HashMap<Integer, Integer> mm;
	static boolean[] msks;
	static int[] lazy[], lazyCount;
	static int[] dist;
	static char[][] g;
	static int ave;
	static ArrayList<Integer> gl;
	static int[] a, d, q;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		int t = sc.nextInt();
		memo = new long[10][200001];
		for (long[] a : memo)
			Arrays.fill(a, -1);
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			String s=n+"";
			long ans=0;
			for(int i=0;i<s.length();i++)
				ans=(ans+dp(s.charAt(i)-'0', m))%mod;
		out.println(ans);
		}
		out.flush();
	}

	static long dp(int d, int left) {
		if (left < 0)
			return 0;
		if (left == 0)
			return 1;
		if (memo[d][left] != -1)
			return memo[d][left];
		long ans = 0;
		if (d == 9) {
             ans=(dp(0,left-1)+dp(1,left-1))%mod;
		} else {
             ans=dp(d+1,left-1);
		}
		return memo[d][left] = ans;
	}

	static long modPow(long a, long e)

	{
		long res = 1;
		while (e > 0) {
			if ((e & 1) == 1)
				res = (res * a) % mod;
			a = (a * a) % mod;
			e >>= 1;
		}
		return res;
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
				a[i] = a1[i].intValue();
			return a;
		}

		public long[] nextArrLongSorted(int n) throws IOException {
			long[] a = new long[n];
			Long[] a1 = new Long[n];
			for (int i = 0; i < n; i++)
				a1[i] = nextLong();
			Arrays.sort(a1);
			for (int i = 0; i < n; i++)
				a[i] = a1[i].longValue();
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