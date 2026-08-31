import java.io.*;
import java.util.*;

public class tr1 {
	static PrintWriter out;
	static StringBuilder sb;
	static int n, m, id, max;
	static long mod = 998244353;
	static Boolean[][] memo;
	static String s;
	static int[][] ad;
	static long inf = Long.MAX_VALUE;
	static int[] color;
	static ArrayList<Integer> o;
	static char[][] g;
	static boolean[] vis, vis1;
	static boolean f;
	static int[] ar, a;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Integer> all = new ArrayList<>();
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();
			if (l == 1 && r == 1)
				all.add(a);
			else if (l == 1)
				left.add(a);
			else if(r==1)
				right.add(a);
		}
		Collections.sort(right);
		Collections.sort(left);
		long ans = 0;
		if (all.size() + Math.min(right.size(), left.size()) < k) {
			System.out.println(-1);
			return;
		}
		for (int i = 0; i < Math.min(right.size(), left.size()); i++) {
			all.add(right.get(i) + left.get(i));
		}
		Collections.sort(all);
		for (int i = 0; i < k; i++)
			ans += all.get(i);
		System.out.println(ans);
		out.flush();
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